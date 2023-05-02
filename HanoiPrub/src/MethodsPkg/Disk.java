package MethodsPkg;

/**
 *
 * @author Willian Coral
 */
public class Disk {
    private static int count, aux = 0;
    private int value;
    
    public Disk(int numOfDiscs){
        count = numOfDiscs;
        
        this.value = numOfDiscs - aux;
        aux++;
    }
    
    public int getValue(){
        return value;
    }
    
    public int getNOD(){
        return count;
    }
    
    public static void setNewDiscs(){
        aux = 0;
    }
    
    
    
}
