/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-10
 */

public interface FlightInterface {
    public boolean reserveTicket(TicketClass ticketClass, int reservations);
    public boolean cancelReservation(int RID);
    public void showMap();
    public String getLastReserve();
}
