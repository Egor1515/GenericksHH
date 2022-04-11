import java.util.Arrays;

public class TicketManager {

    private TicketInfo[] tickets = new TicketInfo[0];


    public void save(TicketInfo ticket) {
        int length = tickets.length + 1;
        TicketInfo[] tmp = new TicketInfo[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
        Arrays.sort(tickets);


    }

    public void addNew(TicketInfo ticket) {
        save(ticket);
    }

    public TicketInfo[] searchByAll(String departure, String arrival) {
        TicketInfo[] result = new TicketInfo[0];
        for (TicketInfo ticket : findAll()) {
            if (matchesDeparture(ticket, departure)) {
                if (matchesArrival(ticket, arrival)) {
                    TicketInfo[] tmp = new TicketInfo[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;

                }
            }
        }
        return result;
    }

    public boolean matchesDeparture(TicketInfo ticket, String search) {
        return ticket.getDeparture().contains(search);
    }

    public boolean matchesArrival(TicketInfo ticket, String search) {
        return ticket.getArrival().contains(search);
    }

    public TicketInfo[] findAll(String from, String to) {
        return searchByAll(from, to);

    }

    public TicketInfo[] findAll() {
        return tickets;

    }
}

