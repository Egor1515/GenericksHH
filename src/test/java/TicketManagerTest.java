import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {

    TicketManager manager = new TicketManager();
    TicketInfo first = new TicketInfo(1, 100, "VVO", "DME", 200);
    TicketInfo second = new TicketInfo(2, 200, "VVO", "VKO", 200);
    TicketInfo third = new TicketInfo(3, 300, "VVO", "LED", 200);
    TicketInfo forth = new TicketInfo(4, 400, "VVO", "KHV", 200);
    TicketInfo fifth = new TicketInfo(5, 500, "VVO", "KRR", 200);


    @Test
    void shouldSearchATA() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        TicketInfo[] expected = {first};
        TicketInfo[] actual = manager.searchByAtaAr("DME");

        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchDep() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        TicketInfo[] expected = {first, second, third};
        TicketInfo[] actual = manager.searchByDeparture("VVO");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplay() {
        manager.save(fifth);
        manager.save(first);

        TicketInfo[] expected = {first};
        assertArrayEquals(expected, manager.findAll("VVO", "DME"));
    }

    @Test
    void shouldDisplayNone() {
        manager.save(fifth);
        manager.save(first);

        TicketInfo[] expected = new TicketInfo[0];
        assertArrayEquals(expected, manager.findAll("VaO", "DME"));
    }

    @Test
    void shouldCompare() {
        manager.save(first);
        manager.save(second);

        TicketInfo ticket = new TicketInfo();
        TicketInfo[] expected = {first, second, third};
        TicketInfo[] actual = {third, second, first};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);


    }

}