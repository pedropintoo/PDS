/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-15
 */

package Impressora;
import java.util.List;

public interface AdvancedPrinterInterface {
    public int print(Document doc);
    public List<Integer> print(List<Document> docs);
    public void showQueuedJobs();
    public boolean cancelJob(int jobId) ;
    public void cancelAll();
}
