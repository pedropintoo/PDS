/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package ex3;

public class BorrowedState implements State {

    private Book book;

    public BorrowedState(Book book) {
        this.book = book;
    }

    @Override
    public void registerBook() {
        System.err.println("Book can't be registered when borrowed");
    }

    @Override
    public void requireBook() {
        System.err.println("Book is already borrowed");
    }

    @Override
    public void returnBook() {
        this.book.setState(new AvailableState(book));
    }

    @Override
    public void reserveBook() {
        System.err.println("Book can't be reserved when borrowed");
    }

    @Override
    public void cancelBook() {
        System.err.println("Book can't be canceled when borrowed");
    }

    

}
