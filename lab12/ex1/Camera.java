package ex1;

public class Camera{
    private int megapixels;

    public Camera(int megapixels){
        this.megapixels = megapixels;
    }

    public int getMegaPixels(){
        return megapixels;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + megapixels;
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
        Camera other = (Camera) obj;
        if (megapixels != other.megapixels)
            return false;
        return true;
    }

    
}