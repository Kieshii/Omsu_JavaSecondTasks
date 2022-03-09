import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Objects;

public class FinanceReport {
    private  Payment[] arr;
    private  String name;
    private  GregorianCalendar date;

    public FinanceReport(String name, GregorianCalendar date, Payment... arr) {
        this.date = date;
        this.name = name;
        this.arr = arr;
    }

    public FinanceReport(FinanceReport fr) {
        this.date = fr.date;
        this.name = fr.name;
        int len = fr.arr.length;
        this.arr = new Payment[len];
        int i = 0;
        for (Payment p: fr.arr) {
            this.arr[i] = new Payment(p);
            i++;
        }
    }

    public String getName() {
        return name;
    }

    public Payment[] getArr() {
        return arr;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public int getYear() {
        return date.get(GregorianCalendar.YEAR);
    }

    public int getMonth() { return 1 + date.get(GregorianCalendar.MONTH); }

    public int getDay() {
        return date.get(GregorianCalendar.DAY_OF_MONTH);
    }

    private void checkIndex(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (this.arr == null || this.arr.length <= index) throw new IndexOutOfBoundsException();
    }

    public int getCount() {
        return arr.length;
    }

    public Payment getPayment(int index) {
        checkIndex(index);
        return arr[index];
    }

    public void setPayment(int index, Payment payment) {
        checkIndex(index);
        arr[index] = new Payment(payment);
    }

    @Override
    public String toString() {
        String result = String.format("Автор: %s, Дата: %02d.%02d.%04d, Платежи:\n", name, getDay(),getMonth(),getYear());
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    result = result + arr[i].toString();
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceReport)) return false;
        FinanceReport fr = (FinanceReport) o;
        return getYear() == fr.getYear() &&
                getMonth() == fr.getMonth() &&
                getDay() == fr.getDay() &&
                Arrays.equals(arr, fr.arr) &&
                Objects.equals(getName(), fr.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, Arrays.hashCode(arr));
    }
}