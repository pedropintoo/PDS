package ex1;

public class Memory {
    private int ram;

    public Memory(int ram){
        this.ram = ram;
    }

    public int getRam(){
        return ram;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ram;
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
        Memory other = (Memory) obj;
        if (ram != other.ram)
            return false;
        return true;
    }

    
}