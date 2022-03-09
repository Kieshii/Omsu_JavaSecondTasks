public class FinanceReportProcessor {
    public static FinanceReport GetPaymentByFirstSymbol(FinanceReport fr, char fl) {
        FinanceReport result;
        if (fr == null) {
            throw new IllegalArgumentException("Пустой Финансовый отсчет");
        }
        int length = fr.getCount();
        boolean[] symbolTrue = new boolean[length];
        int countPayments = 0;
        Payment p;
        for (int i = 0; i < length; i++) {
            p = fr.getPayment(i);
            if (p.getName().charAt(0) == fl) {
                symbolTrue[i] = true;
                countPayments++;
            } else {
                symbolTrue[i] = false;
            }
        }
        Payment[] payments = new Payment[countPayments];
        for (int i = 0, j = 0; i < length; i++) {
            if (symbolTrue[i]) {
                payments[j] = new Payment(fr.getPayment(i));
                j++;
            }
        }
        result = new FinanceReport(fr.getName(), fr.getDate(), payments);
        return result;
    }

    public static FinanceReport GetPaymentUnderValue(FinanceReport fr, double value) {
        FinanceReport result;
        if (fr == null) {
            throw new IllegalArgumentException("Пустой финансовый отсчет");
        }
        int length = fr.getCount();
        boolean[] symbolTrue = new boolean[length];
        int countPayments = 0;
        Payment p;
        for (int i = 0; i < length; i++) {
            p = fr.getPayment(i);
            if (p.getSum() <= value) {
                symbolTrue[i] = true;
                countPayments++;
            } else {
                symbolTrue[i] = false;
            }
        }
        Payment[] payments = new Payment[countPayments];
        for (int i = 0, j = 0; i < length; i++) {
            if (symbolTrue[i]) {
                payments[j] = new Payment(fr.getPayment(i));
                j++;
            }
        }
        result = new FinanceReport(fr.getName(), fr.getDate(), payments);
        return result;
    }
}