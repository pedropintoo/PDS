package ex3;

public interface State {
    public void registerBook();
    public void requireBook();
    public void returnBook();
    public void reserveBook();
    public void cancelBook();
}
