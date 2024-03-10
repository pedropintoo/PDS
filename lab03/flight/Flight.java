/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-04
 */

public class Flight {

    private static int counterRID = 0;
    private String flightCode;

    // Touristic seats
    private int[][] touristicArray;
    private int rowsTouristic;
    private int colsTouristic;

    // Executive seats (OPTIONAL)
    private int[][] executiveArray = null;
    private int rowsExecutive = 0;
    private int colsExecutive = 0;

    public Flight(String flightCode, int rowsTouristic, int colsTouristic) {
        this.touristicArray = new int[rowsTouristic][colsTouristic];
        this.flightCode = flightCode;
        this.rowsTouristic = rowsTouristic;
        this.colsTouristic = colsTouristic;
    }

    public Flight(String flightCode, int rowsTouristic, int colsTouristic, int rowsExecutive, int colsExecutive) {
        this(flightCode,rowsTouristic,colsTouristic);
        this.executiveArray = new int[rowsExecutive][colsExecutive];
        this.rowsExecutive = rowsExecutive;
        this.colsExecutive = colsExecutive;
    }  

    @Override
    public String toString() {
        return "Flight [flightCode=" + flightCode + ", rowsTouristic=" + rowsTouristic + ", colsTouristic="
                + colsTouristic + ", rowsExecutive=" + rowsExecutive + ", colsExecutive=" + colsExecutive + "]";
    }

    // Reserve a ticket (if possible) in the Flight
    public boolean reserveTicket(TicketClass ticketC, int reservations){
        int[][] seatsArray;
        int rows, cols;

        // Check if there are enough seats available and get the array to reserve the seats
        if (ticketC == TicketClass.Touristic) {
            if (reservations > this.touristicTotalSeats() - this.touristicOccupiedSeats()) {
                System.out.println("Not enough seats available.");
                return false;
            }
            seatsArray = this.getTouristicArray();
            rows = this.getRowsTouristic();
            cols = this.getColsTouristic();
        } else if (ticketC == TicketClass.Executive && executiveArray != null) {
            if (reservations > this.executiveTotalSeats() - this.executiveOccupiedSeats()) {
                System.out.println("Not enough seats available.");
                return false;
            }
            seatsArray = this.getExecutiveArray();
            rows = this.getRowsExecutive();
            cols = this.getColsExecutive();
        } else {
            System.out.println("Executive class not available.");
            return false;
        }

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
                this.setTouristicArray(seatsArray);
            } else {
                this.setExecutiveArray(seatsArray);
            }
            counterRID++;
        }

        return success;
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

        if (this.hasExecutive()){
            rows = this.getRowsExecutive();
            cols = this.getColsExecutive();
            int [][] executiveArray = this.getExecutiveArray();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
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
        int[][] executive = this.getExecutiveArray();
        int[][] turist = this.getTouristicArray();

        if (!this.hasExecutive()) {
            executive = new int[0][0];
        }

        int nColumns = 0;
        int nRows = 0;

        if(this.hasExecutive()) {
            if(turist.length >= executive.length) {
                nColumns = executive[0].length + turist[0].length;
                nRows = turist.length;
            }
        } else {
            nColumns = this.getColsTouristic();
            nRows = this.getRowsTouristic();
        }

        // Print the numeration of the columns
        System.out.print("\t");
        for(int i = 1; i <= nColumns; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        int letra = 65; // ASCII code for 'A'

        for(int i = 0; i < nRows; i++) {
            System.out.print((char)letra + "\t");
            letra++;

            for(int j = 0; j < nColumns; j++) {
                if(this.hasExecutive() && j < executive[0].length) {
                    if(i < executive.length) {
                        if(executive[i][j] == 0)
                            System.out.print("0\t");
                        else
                            System.out.print(executive[i][j] + "\t");
                    } else {
                        System.out.print("\t");
                    }
                } else { 
                    int x;
                    if(this.hasExecutive())
                        x = j - 1;
                    else
                        x = j;
                    
                    if(turist[i][x - executive.length] == 0)
                        System.out.print("0");
                    else
                        System.out.print(turist[i][x - executive.length]);
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }



    private boolean hasExecutive(){
        return this.executiveArray != null;
    }

    //Getters & Setters

    public int[][] getTouristicArray(){
        return this.touristicArray;
    }

    public void setTouristicArray(int[][] touristicArray){
        this.touristicArray = touristicArray;
    }

    public int[][] getExecutiveArray(){
        return this.executiveArray;
    }

    public void setExecutiveArray(int[][] executiveArray){
        this.executiveArray = executiveArray;
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

    public int getRowsExecutive(){
        return this.rowsExecutive;
    }

    public int getColsExecutive(){
        return this.colsExecutive;
    }

    public int executiveTotalSeats(){
        return this.rowsExecutive * this.colsExecutive;
    }

    public int touristicTotalSeats(){
        return this.rowsTouristic * this.colsTouristic;
    }

    public String getLastReserve() {
        int rows = this.getRowsTouristic();
        int cols = this.getColsTouristic();
        int [][] touristicArray = this.getTouristicArray();

        int lastRID = counterRID;
        String ret = "";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (touristicArray[i][j] == lastRID) {
                    String position = Integer.toString(j+1) + (char)('A' + i);
                    ret = ret + position + " ";
                }
            }
        }

        if (this.hasExecutive()){
            rows = this.getRowsExecutive();
            cols = this.getColsExecutive();
            int [][] executiveArray = this.getExecutiveArray();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (executiveArray[i][j] == lastRID) {
                        String position = Integer.toString(j+1) + (char)('A' + i);
                        ret = ret + position + " ";
                    }
                }
            }
        }

        return ret == "" ? null : flightCode + ":" + lastRID + " = " + String.join(" | ", ret.trim().split(" "));
    }

    public int executiveOccupiedSeats(){
        int rows = this.getRowsExecutive();
        int cols = this.getColsExecutive();
        int [][] executiveArray = this.getExecutiveArray();
        int occupied = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (executiveArray[i][j] != 0) {
                    occupied++;
                }
            }
        }

        return occupied;
    }

    public int touristicOccupiedSeats(){
        int rows = this.getRowsTouristic();
        int cols = this.getColsTouristic();
        int [][] touristicArray = this.getTouristicArray();
        int occupied = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (touristicArray[i][j] != 0) {
                    occupied++;
                }
            }
        }

        return occupied;
    }

}
