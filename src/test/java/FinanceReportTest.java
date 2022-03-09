import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class FinanceReportTest {

    FinanceReport TestFinanceReport = new FinanceReport("Васильев Данил Олегович", new GregorianCalendar(2021, Calendar.NOVEMBER, 24),
            new Payment("Плательщиков Один Василевич", 110, new GregorianCalendar(2010, Calendar.MARCH, 12)),
            new Payment("Плачущий Два Игоревич", 250, new GregorianCalendar(2015, Calendar.JULY, 18)),
            new Payment("Заплативший Три Сергеевич", 320, new GregorianCalendar(2020, Calendar.OCTOBER, 22)));

    FinanceReport TestFinanceReportEqual = new FinanceReport("Васильев Данил Олегович", new GregorianCalendar(2021, Calendar.NOVEMBER, 24),
            new Payment("Плательщиков Один Василевич", 110, new GregorianCalendar(2010, Calendar.MARCH, 12)),
            new Payment("Плачущий Два Игоревич", 250, new GregorianCalendar(2015, Calendar.JULY, 18)),
            new Payment("Заплативший Три Сергеевич", 320, new GregorianCalendar(2020, Calendar.OCTOBER, 22)));

    @Test
    public void testFinanceReportEquals1() {
        FinanceReport TestFinanceReport2 = new FinanceReport(TestFinanceReport);
        assertEquals(TestFinanceReport2, TestFinanceReport);
    }

    @Test
    public void testFinanceReportEquals2() {
        assertEquals(TestFinanceReportEqual, TestFinanceReport);
    }

    @Test
    public void testFinanceReportToString() {
        String TestString = "Автор: Васильев Данил Олегович, Дата: 24.11.2021, Платежи:\n" +
                "Плательщик: Плательщиков Один Василевич, Дата: 12.03.2010, Сумма: 1 руб. 10 коп.\n" +
                "Плательщик: Плачущий Два Игоревич, Дата: 18.07.2015, Сумма: 2 руб. 50 коп.\n" +
                "Плательщик: Заплативший Три Сергеевич, Дата: 22.10.2020, Сумма: 3 руб. 20 коп.\n";
        assertEquals(TestFinanceReport.toString(), TestString);
    }

    @Test
    public void testCopy() {
        FinanceReport copy = new FinanceReport(TestFinanceReport);
        copy.setPayment(0, new Payment("Неизвестный Безимени Безотчества", 40, new GregorianCalendar(2020, Calendar.OCTOBER, 22)));
        assertNotEquals(copy.getPayment(0), TestFinanceReport.getPayment(0));

        copy.getPayment(1).setSum(555555);
        assertNotEquals(copy.getPayment(1), TestFinanceReport.getPayment(1));
    }
}