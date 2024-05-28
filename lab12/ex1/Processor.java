package ex1;

public class Processor{
    private int cores;

    public Processor(int cores){
        this.cores = cores;
    }

    public int getCores(){
        return cores;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cores;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Processor other = (Processor) obj;
        if (cores != other.cores)
            return false;
        return true;
    }

    
}