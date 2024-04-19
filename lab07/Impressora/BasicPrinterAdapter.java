package Impressora;

public class BasicPrinterAdapter extends AdvancedPrinter {

    private BasicPrinter basicPrinter;

    public BasicPrinterAdapter(BasicPrinter basicPrinter) {
        super();
        this.basicPrinter = basicPrinter;
    }

    // TODO: implementar métodos
    public int print(Document doc) {
        PrintJob job = new PrintJob(doc);
        String[] content = doc.getContent();

        basicPrinter.print(content)


        return ;
    }

    public List<Integer> print(List<Document> docs) {
        List<Integer> jobs = new ArrayList<>();
        for (Document doc : docs) {
            jobs.add(spool.newPrintJob(doc));
        }
        return jobs;
    }

    public void showQueuedJobs() {
        for (PrintJob printJob : spool.getPrintQueue()) {
            System.out.println(printJob);
        }
    }

    public boolean cancelJob(int jobId) {
        return spool.cancelJob(jobId);
    }

    public void cancelAll() {
        spool.getPrintQueue().clear();
    }
    
}
