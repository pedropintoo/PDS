/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package Impressora;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AdvancedPrinter implements AdvancedPrinterInterface {

    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ExecutorService.html
    class PrinterService implements Runnable {
        private final LinkedBlockingQueue<PrintJob> printQueue;
        private final ExecutorService pool;
     
        // este serviço simula a fila de impressão e a impressão de um documento de cada vez
        public PrinterService() {
                printQueue = new LinkedBlockingQueue<>();
                pool = Executors.newFixedThreadPool(1);
        }
     
        public void run() { // run the service
            try {
                for (;;) {
                    PrintJob j = printQueue.take();
                    pool.submit(j).get();
                }
            } catch (java.util.concurrent.RejectedExecutionException ex) {
                System.out.println("Job rejected by spool: service shutting down?");
            } catch (ExecutionException e) {
                System.out.println("Error");
                e.printStackTrace();
            } catch (InterruptedException ex) {
            this.shutdownAndAwaitTermination();
            }
        }

        public int newPrintJob(Document doc) {
            // TODO: adiciona 'print job' à fila de impressão
            PrintJob job = new PrintJob(doc);
            printQueue.add(job);
            return job.getJobId();    
        }

        public boolean cancelJob(int job) {
           // TODO: cancela 'print job', se existir na fila
            for (PrintJob printJob : printQueue) {
                if (printJob.getJobId() == job) {
                    printQueue.remove(printJob);
                    return true;
                }
            }
            return false;
        }
    
        void shutdownAndAwaitTermination() {
            pool.shutdown(); // Disable new tasks from being submitted
            try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Spool did not terminate.");
            }
            } catch (InterruptedException ie) {
                // (Re-)Cancel if current thread also interrupted
                pool.shutdownNow();
                printQueue.clear();
                // Preserve interrupt status
                Thread.currentThread().interrupt();
            }
        }

        public LinkedBlockingQueue<PrintJob> getPrintQueue() {
            return printQueue;
        }

    }

    private PrinterService spool;

    public AdvancedPrinter() {
        this.spool = new PrinterService();
        new Thread(this.spool).start();
    }

    // TODO: implementar métodos
    // Métodos provisórios
    public int print(Document doc) {
        System.out.println("Spooling 1 document.");
        return spool.newPrintJob(doc);
    }

    public List<Integer> print(List<Document> docs) {
        System.out.printf("Spooling %d document.\n", docs.size());
        List<Integer> jobs = new ArrayList<>();
        for (Document doc : docs) {
            jobs.add(spool.newPrintJob(doc));
        }
        return jobs;
    }

    public void showQueuedJobs() {
        if (spool.getPrintQueue().isEmpty()) {
            System.out.println("No spooled jobs.");
            return;
        }
        System.out.println("Spooled jobs:");
        for (PrintJob printJob : spool.getPrintQueue()) {
            System.out.println("\t * " + printJob);
        }
        System.out.println();
    }

    public boolean cancelJob(int jobId) {
        PrintJob job = spool.getPrintQueue().stream().filter(j -> j.getJobId() == jobId).findFirst().orElse(null);
        boolean returnVal = spool.cancelJob(jobId);
        if (returnVal) {
            System.out.println("Cancelled " + job);
        } 
        return returnVal;
    }

    public void cancelAll() {
        spool.shutdownAndAwaitTermination();
        spool.getPrintQueue().clear();
    }
}
