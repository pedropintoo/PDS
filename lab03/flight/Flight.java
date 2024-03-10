/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-04
 */

public class Flight {

    private int counterRID = 0;
    private String flightCode;

    // Touristic seats
    private int[][] touristicArray;

    // Executive seats (OPTIONAL)
    private int[][] executiveArray = null;

    public Flight(String flightCode, int rowsTouristic, int colsTouristic) {
        this.touristicArray = new int[rowsTouristic][colsTouristic];
        this.flightCode = flightCode;
        this.counterRID = 0;
    }

    public Flight(String flightCode, int rowsTouristic, int colsTouristic, int rowsExecutive, int colsExecutive) {
        this(flightCode,rowsTouristic,colsTouristic);
        this.executiveArray = new int[rowsExecutive][colsExecutive];
    }  

    // Reserve a ticket (if possible) in the Flight
    public boolean reserveTicket(TicketClass ticketC, int reservations){
        int[][] seatsArray;

        // Filter seats depending on required ticket
        if (ticketC == TicketClass.Touristic && hasTouristicSpace(reservations)) {   
            seatsArray = touristicArray;

        } else if (hasExecutive() && ticketC == TicketClass.Executive && hasExecutiveSpace(reservations)) {
            seatsArray = executiveArray;

        } else {
            return false;
        }
        
        int rows = seatsArray.length;
        int cols = seatsArray[0].length;
        int countSuccess = 0;
        // Try to reserve the seats in empty queues
        for (int j = 0; j < cols; j++) {
            if (seatsArray[0][j] == 0){
                for (int i = 0; i < reservations; i++) {
                    if (j + i/rows < cols){
                        seatsArray[i % rows][j+i/rows] = counterRID + 1;
                        countSuccess++;
                    }
                }
                break;
            }
        }
        boolean success;
        if (countSuccess == reservations){
            success = true;
        } else {
            success = false;
        }

        // If the previous method didn't get completed, try to reserve the seats sequentially
        if (!success){
            for (int j = 0; j < cols && !success; j++) {
                for (int i = 0; i < rows && !success; i++) {
                    if (seatsArray[i][j] == 0){
                        seatsArray[i][j] = counterRID + 1;
                        countSuccess++;

                        if (countSuccess == reservations){
                            success = true;
                        }
                    }
                }
            }
        }
        
        if (success){
            if (ticketC == TicketClass.Touristic){
                touristicArray = seatsArray;
            } else {
                executiveArray = seatsArray;
            }
            counterRID++;
        }

        return success;
    }

    // Cancel a reservation (if possible) in the Flight
    public boolean cancelReservation(int RID) {
        int removed = 0;

        for (int i = 0; i < touristicArray.length; i++) {
            for (int j = 0; j < touristicArray[0].length; j++) {
                if (touristicArray[i][j] == RID) {
                    touristicArray[i][j] = 0;
                    removed++;
                }
            }
        }

        if (removed == 0 && hasExecutive()){
            for (int i = 0; i < executiveArray.length; i++) {
                for (int j = 0; j < executiveArray[0].length; j++) {
                    if (executiveArray[i][j] == RID) {
                        executiveArray[i][j] = 0;
                        removed++;
                    }
                }
            }
        }

        return removed > 0;
    }

    public void showMap() {

        int totalCols = touristicArray[0].length;
        int totalRows = touristicArray.length;

        if(hasExecutive()) {
            totalCols += executiveArray[0].length;
            if (executiveArray.length > totalRows) {
                totalRows = executiveArray.length;
            }
        }

        // Columns label
        System.out.print(" ");
        for(int i = 1; i <= totalCols; i++) {
            System.out.printf("%3d",i);
        }
        System.out.println();

        for (int i = 0; i < totalRows; i++) {
            // Rows label
            System.out.print((char)('A' + i));

            for (int j = 0; j < totalCols; j++) {
                if (hasExecutive()){
                    if (j < executiveArray[0].length) {
                        System.out.printf("%3s", i < executiveArray.length ? executiveArray[i][j] : " ");
                    } else {
                        System.out.printf("%3s", i < touristicArray.length ? touristicArray[i][j - executiveArray[0].length] : " ");
                    }
                } else {
                    System.out.printf("%3s", touristicArray[i][j]);
                }
            }
            System.out.println();
        }

    }


    public String getLastReserve() {
        String ret = getSeatsPosition(touristicArray, counterRID);

        if (ret == null && hasExecutive()){
            ret = getSeatsPosition(executiveArray, counterRID);
        }

        return ret == null ? null : flightCode + ":" + counterRID + " = " + String.join(" | ", ret.trim().split(" "));
    }

    //Getters & Setters
    
    private boolean hasExecutive(){
        return this.executiveArray != null;
    }

    private String getSeatsPosition(int[][] seatsArray, int RID){
        // Returns a string (e.g. "1A 1B 1C")
        String ret = "";
        int count = 0;

        for (int i = 0; i < seatsArray.length; i++) {
            for (int j = 0; j < seatsArray[0].length; j++) {
                if (seatsArray[i][j] == RID) {
                    String position = Integer.toString(j+1) + (char)('A' + i);
                    ret = ret + position + " ";
                    count++;
                }
            }
        }

        return count > 0 ? ret : null;
    }

    private int getExecutiveTotalSeats(){
        return executiveArray.length * executiveArray[0].length;
    }

    private int getTouristicTotalSeats(){
        return touristicArray.length * touristicArray[0].length;
    }

    private boolean hasTouristicSpace(int reservations) {
        return reservations <= getTouristicTotalSeats() - getTouristicOccupiedSeats();
    }

    private boolean hasExecutiveSpace(int reservations) {
        return reservations <= getExecutiveTotalSeats() - getExecutiveOccupiedSeats();
    }

    private int getOccupiedSeats(int[][] seatsArray) {
        int occupied = 0;
        for (int i = 0; i < seatsArray.length; i++) {
            for (int j = 0; j < seatsArray[0].length; j++) {
                if (seatsArray[i][j] != 0) {
                    occupied++;
                }
            }
        }
        return occupied;
    }

    private int getExecutiveOccupiedSeats(){
        return getOccupiedSeats(executiveArray);
    }

    private int getTouristicOccupiedSeats(){
        return getOccupiedSeats(touristicArray);
    }

}
