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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnBook'");
    }

    @Override
    public void reserveBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reserveBook'");
    }

    @Override
    public void cancelBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelBook'");
    }
    
}
