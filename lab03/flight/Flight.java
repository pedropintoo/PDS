/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-04
 */

package lab03.flight;

import java.util.Arrays;

public class Flight {

    private static int Rid = 0;
    private String flightCode;

    // Touristic seats
    private int[][] touristicArray;
    private int rowsTouristic;
    private int colsTouristic;

    // Exclusive seats (OPTIONAL)
    private int[][] exclusiveArray = null;
    private int rowsExclusive = 0;
    private int colsExclusive = 0;

    public Flight(String flightCode, int rowsTouristic, int colsTouristic) {
        this.touristicArray = new int[rowsTouristic][colsTouristic];
        this.flightCode = flightCode;
        this.rowsTouristic = rowsTouristic;
        this.colsTouristic = colsTouristic;
    }

    public Flight(String flightCode, int rowsTouristic, int colsTouristic, int rowsExclusive, int colsExclusive) {
        this(flightCode,rowsTouristic,colsTouristic);
        this.exclusiveArray = new int[rowsExclusive][colsExclusive];
        this.rowsExclusive = rowsExclusive;
        this.colsExclusive = colsExclusive;
    }  

    @Override
    public String toString() {
        return "Flight [flightCode=" + flightCode + ", rowsTouristic=" + rowsTouristic + ", colsTouristic="
                + colsTouristic + ", rowsExclusive=" + rowsExclusive + ", colsExclusive=" + colsExclusive + "]";
    }

    // Reserve a ticket (if possible) in the Flight
    public void reserveTicket(TicketClass ticketC, int reservations){
        // Rid++;
        return;
    }

    //Getters

    public int[][] getTouristicArray(){
        return this.touristicArray;
    }

    public int[][] getExclusiveArray(){
        return this.exclusiveArray;
    }

    public String getFlightCode(){
        return this.flightCode;
    }

}
