package Cabazes;

public abstract class Utils {
    public static int identationInc = 0;

    public static void printIdentation(){
        for (int i = 0; i < identationInc; i++){
            System.out.print("   ");
        }
    }
}
