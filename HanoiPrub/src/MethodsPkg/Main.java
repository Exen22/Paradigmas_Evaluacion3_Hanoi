package MethodsPkg;

import javax.swing.JOptionPane;

/**
 *
 * @author Willian Coral
 */
public class Main {
    public static void main(String[] args){
        
        boolean exit = false;
        
        JOptionPane.showMessageDialog(null, "BIENVENIDO AL JUEGO 'TORRES DE HANOI'\n\n"
                + "-El objetivo del juego consiste en llevar todos los discos desde la torre 1 hasta la torre 3\n"
                + "-No se puede colocar un disco sobre otro disco de menor tamaño\n\n"
                + "Si desea cancelar el movimiento de un disco, vuelva a seleccionar la torre para cancelar", "INFO", JOptionPane.INFORMATION_MESSAGE);
        do{
            HanoiLoop nLoop = new HanoiLoop();
            nLoop.game(); 
            
            //Opcion para repetir el juego
            int opc =JOptionPane.showConfirmDialog(null,"Quiere volver a jugar?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (opc==JOptionPane.NO_OPTION){
                exit = true;
            }
        }while(exit != true);
        System.exit(0);
        
    }
    
}
