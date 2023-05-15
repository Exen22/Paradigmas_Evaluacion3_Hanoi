package MethodsPkg;

import javax.swing.JOptionPane;

/*
 INTEGRANTES DEL EQUIPO:

Jose Flores C.I: 31.197.661
Willian Coral C.I: 31.296.612
Carlos Andrade C.I: 30.629.071
José García C.I: 

 */
public class Main {
    public static void main(String[] args){
        
        boolean exit = false;
        
        JOptionPane.showMessageDialog(null, "BIENVENIDO AL JUEGO 'TORRES DE HANOI'\n\n"
                + "El  juego consiste en tratar de llevar todos los discos desde la torre 1 hasta la torre 3\n"
                + "\nREGLAS:\n-No se puede colocar un disco sobre otro disco de menor tamaño\n"
                + "-Solo se puede mover 1 disco a la vez\n\n"
                + "ACERCA DEL JUEGO:\nSi desea cancelar el movimiento de un disco, vuelva a seleccionar la torre para cancelar", "INFO", JOptionPane.INFORMATION_MESSAGE);
        
        //Bucle de juego
        do{
            HanoiLoop nLoop = new HanoiLoop();
            nLoop.game(); 
            
            //Opcion para repetir el juego una vez finalizado
            int opc =JOptionPane.showConfirmDialog(null,"Quiere volver a jugar?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (opc==JOptionPane.NO_OPTION){
                exit = true;
            }
            
        }while(exit != true);
        System.exit(0);
        
    }
    
}
