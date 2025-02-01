/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package ex3;

public class Book {
    private static int idCounter = 1;
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

    public int getISBN() {
        return ISBN;
    }

    public void registerBook() {
        state.registerBook();
    }

    public void requireBook() {
        state.requireBook();
    }

    public void returnBook() {
        state.returnBook();
    }

    public void reserveBook() {
        state.reserveBook();
    }

    public void cancelBook() {
        state.cancelBook();
    }

    @Override
    public String toString() {
        return String.format("%-4d %-25s %-20s %-10s", ISBN, title, author, state.getClass().getSimpleName());
    }
}
