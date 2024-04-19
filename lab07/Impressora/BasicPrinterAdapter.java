// package Impressora;

// import java.util.ArrayList;
// import java.util.List;

// public class BasicPrinterAdapter extends AdvancedPrinter {

//     private BasicPrinter basicPrinter;
//     private PrinterService spool;

//     public BasicPrinterAdapter(BasicPrinter basicPrinter) {
//         super();
//         this.spool = new PrinterService();
//         new Thread(this.spool).start();
//         this.basicPrinter = basicPrinter;
//     }

//     private void addQueue(PrintJob job) {
//         printQueue.add(job);
//         if (basicPrinter.print(content) == false) {
//             basicPrinter.refill();
//             basicPrinter.print(content);
//         }
//         printQueue.remove(job);
//     }

//     // TODO: implementar métodos
//     @Override
//     public int print(Document doc) {
//         PrintJob job = new PrintJob(doc);
//         String[] content = job.getContent();

//         if (basicPrinter.print(content) == false) {
//             basicPrinter.refill();
//             basicPrinter.print(content);
//         }

//         return job.getJobId();
//     }

//     @Override
//     public List<Integer> print(List<Document> docs) {
//         List<Integer> jobs = new ArrayList<>();
//         for (Document doc : docs) {
//             PrintJob job = new PrintJob(doc);
//             String[] content = job.getContent();
            
//             addQueue(job);

//             jobs.add(job.getJobId());

//         }
//         return jobs;
//     }

//     public void showQueuedJobs() {
//         for (PrintJob printJob : printQueue) {
//             System.out.println(printJob);
//         }
//     }

//     public boolean cancelJob(int jobId) {
//         return printQueue.removeIf(job -> job.getJobId() == jobId);
//     }

//     public void cancelAll() {
//         printQueue.clear();
//     }
    
// }
