package Impressora;

public class PrintJob {

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

    // Getters

    public int getJobId() {
        return this.jobId;
    }

    public Document getDocument() {
        return this.doc;
    }
}
