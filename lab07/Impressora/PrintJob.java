package Impressora;

import java.util.concurrent.Callable;

public class PrintJob implements Callable<String[]> {

    private Document doc;
    private static int jobIdCounter = 0;
    private int jobId = 0;

    public PrintJob(Document doc) {
        this.doc = doc;
        this.jobId = jobIdCounter++;
    }

    public String[] getContent() {
        if (doc.hasNextLine() == false) {
            doc.reopen();
        }
        
        // max 15
        String[] content = new String[15];
        int i = 0;
        while (doc.hasNextLine()) {
            content[i] = doc.readLine();
            i++;
        }
        return content;
    }

    @Override
    public String toString() {
        String content[] = this.getContent();
        return "Job " + this.jobId + ": \"" + content[0].substring(0, Math.min(20, content[0].length()-1)) + "...\"";
    }

    // Getters

    public int getJobId() {
        return this.jobId;
    }

    public Document getDocument() {
        return this.doc;
    }

    @Override
    public String[] call() throws Exception {
        String[] res = this.getContent();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished " + this.toString());
        return res;
    }
}
