
public class Client {
    private String number;
    private String name;

    public Client(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public void notifyChange() {
        System.out.println(this + " notified with change.");
    }

    public void notifyAvailability() {
        System.out.println(this + " has now the product!");
    }

    @Override
    public String toString() {
        return "Client [number=" + number + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Client other = (Client) obj;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    

}
