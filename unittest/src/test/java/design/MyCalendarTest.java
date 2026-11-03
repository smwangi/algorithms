package design;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCalendarTest {

    @Test
    void canBookEmptyCalendar() {
        assertTrue(new MyCalendar().book(10, 20));
    }

    // Each case books [10, 20) first, then tries a second booking
    @ParameterizedTest(name = "[10,20) then [{0},{1}) -> {2}")
    @CsvSource({
            "20, 30, true",   // touches the end
            "0,  10, true",   // touches the start
            "15, 25, false",  // overlaps the end
            "5,  15, false",  // overlaps the start
            "12, 18, false",  // inside
            "5,  25, false"   // surrounds
    })
    void rejectsOverlappingBookings(int start, int end, boolean expected) {
        MyCalendar calendar = new MyCalendar();
        calendar.book(10, 20);
        assertEquals(expected, calendar.book(start, end));
    }
}
