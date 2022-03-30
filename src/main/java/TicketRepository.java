public class TicketRepository {
    public TicketInfo[] tickets = new TicketInfo[0];

    public TicketInfo[] findAll() {
        return tickets;
    }


}
