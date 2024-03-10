/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-09
 */

public enum TicketClass {
    Executive,
    Touristic;

    public static TicketClass getTicketClass(char sym) {
        return sym == 'E' ? Executive : Touristic;
    }
}
