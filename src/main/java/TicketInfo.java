public class TicketInfo implements Comparable {
    private int id;
    private int cost;
    private String departure;
    private String arrival;
    private int time;

    public TicketInfo() {
    }

    public TicketInfo(int id, int cost, String departure, String arrival, int time) {
        this.id = id;
        this.cost = cost;
        this.departure = departure;
        this.arrival = arrival;
        this.time = time;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public int compareTo(Object o) {
        TicketInfo p = (TicketInfo) o;
        return this.cost-p.cost;
    }
}
