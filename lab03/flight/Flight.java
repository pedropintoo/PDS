/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-04
 */

package lab03.flight;

import java.util.Arrays;

public class Flight {

    private static int counterRID = 0;
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
    public boolean reserveTicket(TicketClass ticketC, int reservations){
        return true;
    }

    // Cancel a reservation (if possible) in the Flight
    public boolean cancelReservation(int RID) {
        int rows = this.getRowsTouristic();
        int cols = this.getColsTouristic();
        int [][] touristicArray = this.getTouristicArray();
        int removed = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (touristicArray[i][j] == RID) {
                    touristicArray[i][j] = 0;
                    removed++;
                }
            }
        }

        if (this.hasExclusive()){
            rows = this.getRowsExclusive();
            cols = this.getColsExclusive();
            int [][] exclusiveArray = this.getExclusiveArray();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (exclusiveArray[i][j] == RID) {
                        exclusiveArray[i][j] = 0;
                        removed++;
                    }
                }
            }
        }
        
        return removed > 0;
    }

    private boolean hasExclusive(){
        return this.exclusiveArray != null;
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

    public int getRowsTouristic(){
        return this.rowsTouristic;
    }

    public int getColsTouristic(){
        return this.colsTouristic;
    }

    public int getRowsExclusive(){
        return this.rowsExclusive;
    }

    public int getColsExclusive(){
        return this.colsExclusive;
    }

}
