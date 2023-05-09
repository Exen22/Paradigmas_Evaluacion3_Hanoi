package MethodsPkg;

import javax.swing.JOptionPane;

/**
 *
 * @author Willian Coral
 */
public class Main {
    public static void main(String[] args){
        
        boolean exit = false;
        do{
            HanoiLoop nLoop = new HanoiLoop();
            nLoop.game();
            
            //Opcion para repetir el juego
            int opc =JOptionPane.showConfirmDialog(null,"Quiere volver a jugar?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (opc==JOptionPane.NO_OPTION){
                exit = true;
            }
        }while(exit != true);
        
    }
    
}
