package OldMethods_NoUsar;

/**
 *
 * @author Willian Coral
 */
public class Disk_NoUsar {
    private static int count, aux = 0;
    private int value;
    
    public Disk_NoUsar(int numOfDiscs){
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