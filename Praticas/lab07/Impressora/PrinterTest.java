/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-15
 */

package Impressora;
import java.util.ArrayList;
import java.util.List;

public class PrinterTest {
    
    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AdvancedPrinterInterface p1 = new AdvancedPrinter();
        AdvancedPrinterInterface p2 = new BasicPrinterAdapter(new BasicPrinter());

        List<Document> docs = new ArrayList<Document>();
        docs.add(new Document("text1.txt"));
        docs.add(new Document("text2.txt"));
        docs.add(new Document("text3.txt"));

        p1.print(docs.get(0));   // print first document only
        pause(2000);            // wait for a while

        p1.print(docs);
        p1.showQueuedJobs();
        pause(4000);            // wait for a while

        p2.print(docs);
        p2.cancelJob(6);
        p2.showQueuedJobs();
        pause(4000);            // wait for a while

        p1.print(docs);
        p1.cancelAll();
        p1.showQueuedJobs();
        pause(2000);            // wait for a while
    }
}
