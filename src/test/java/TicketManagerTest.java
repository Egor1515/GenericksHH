import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {

    TicketManager manager = new TicketManager();
    TicketInfo first = new TicketInfo(1, 110, "VVO", "DME", 200);
    TicketInfo second = new TicketInfo(2, 2200, "VVO", "DME", 200);
    TicketInfo third = new TicketInfo(3, 3200, "VVO", "VKO", 200);
    TicketInfo forth = new TicketInfo(4, 4200, "VVO", "KHV", 200);
    TicketInfo fifth = new TicketInfo(5, 5200, "VVO", "KRR", 200);
    TicketInfo seventh = new TicketInfo(3, 2300, "VVO", "VKO", 200);


    @Test
    void shouldSearchATA() {
        manager.save(second);
        manager.save(first);
        manager.save(third);
        TicketInfo[] expected = {first, second};
        TicketInfo[] actual = manager.searchByAll("VVO", "DME");


        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchDep() {
        manager.save(seventh);
        manager.save(third);
        manager.save(second);

        TicketInfo[] expected = {seventh, third};
        TicketInfo[] actual = manager.searchByAll("VVO", "VKO");
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplay() {

        manager.save(first);
        manager.save(forth);
        manager.save(fifth);

        TicketInfo[] expected = {forth};
        assertArrayEquals(expected, manager.findAll("VVO", "KHV"));
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
        manager.save(third);
        manager.save(second);
        manager.save(fifth);
        manager.save(forth);

        TicketInfo[] expected = {first, second, third, forth, fifth};
        TicketInfo[] actual = manager.findAll();


        assertArrayEquals(expected, actual);


    }

}