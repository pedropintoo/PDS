package ex3;

public class AvailableState implements State{

    private Book book;

    public AvailableState(Book book) {
        this.book = book;
    }

    @Override
    public void registerBook() {
        System.err.println("Book is already available");
    }

    @Override
    public void requireBook() {
        this.book.setState(new BorrowedState(book));
    }

    @Override
    public void returnBook() {
        System.err.println("Cannot return a book that is not borrowed");
    }

    @Override
    public void reserveBook() {
        this.book.setState(new ReservedState(book));
    }

    @Override
    public void cancelBook() {
        System.err.println("Cannot cancel a book that is not reserved");
    }
    
}
