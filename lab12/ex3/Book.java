package ex3;

public class Book {
    private static int idCounter = 0;
    private String title;
    private int ISBN;
    private int year;
    private String author;
    private State state;

    public Book(String title, int year, String author) {
        this.title = title;
        this.ISBN = idCounter++;
        this.year = year;
        this.author = author;
        this.state = new InventoryState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-10s %-10s [%-10s]", ISBN, title, author, state.toString());
    }
}
