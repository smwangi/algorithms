import org.junit.jupiter.api.Test;

public class MyCalendarTest {

    @Test
    public void CanBookCalendar() {
        MyCalendar obj = new MyCalendar();
        obj.book(10, 15);
        boolean b1 = obj.book(16, 30);
    }
}
