package OldMethods_NoUsar;

import javax.swing.JOptionPane;

/**
 *
 * @author Willian Coral
 */
public class Logic_MainTemporal {
    /*
    public static void main(String[] args){
        
        
        boolean exit = false;
        int discs = 3; //NUMERO DE DISCOS
        String[] list = new String[3]; //donde se van a guardar los datos de cada pila por separado
        String fList; //lista donde se van a guardar los datos de las 3 pilas 
        HStack[] stack = new HStack[3];
        
        for(int i=0; i<3; i++){
            stack[i] = new HStack();
        }
        //LLENAR LA PRIMERA PILA CON LOS DISCOS
        for(int i=0; i<discs; i++){
            stack[0].push(discs-i);
        }
        
        //BUCLE PRINCIPAL
        do{
            
            //MOSTRAR CON JOptionPane
            fList = "";
            for(int i = 0; i < 3; i++){
                list[i] = "-\n";
            }
            
            for(int i = 0; i < 3; i++){
                if("".equals(stack[i].getContent())){
                    list[i] = refill(discs, list[i]);
                }
                else{
                    list[i] += stack[i].getContent();
                }
                fList += list[i]+"\n";
            }
            
            //terminar de mostrar y pedir los datos para el proceso
            int aux1, aux2;
            aux1 = Integer.parseInt(JOptionPane.showInputDialog(null, fList + "\n\n\n Mover desde la torre: "));
            aux2 = Integer.parseInt(JOptionPane.showInputDialog(null, fList + "\n\n\n Hasta la torre: "));
            
            //PROCESO
            if (aux1<1 || aux1>3 || aux2<1 || aux2>3){
                JOptionPane.showMessageDialog(null, "MOVIMIENTO INVALIDO");
            }
            else{
                //Verificar que hay discos disponibles para mover desde aux1
                if(stack[aux1-1].isEmpty()){
                    JOptionPane.showMessageDialog(null, "MOVIMIENTO INVALIDO");
                }
                else{
                    //Verificar si aux2 está vacio, si lo está entonces se mueve el disco
                    if(stack[aux2-1].isEmpty()){
                        stack[aux2-1].push(stack[aux1-1].pop());
                    }
                    //Verificar tamaño del disco de aux1 y que sea menor que el de aux2
                    else{
                        if((int)stack[aux1-1].peek() < (int)stack[aux2-1].peek()){
                            stack[aux2-1].push(stack[aux1-1].pop());
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "MOVIMIENTO INVALIDO");
                        }
                    }
                }
            }
            
            //condicion de salida 3era pila llena
            if(stack[2].getSize() == discs){
                exit=true;
            }
            
        }while(exit!=true);
    }
    
    public static String refill(int tam, String list){
        for(int i = 0; i<tam; i++){
                if(i!=0){
                    list += "\n";
                }
                list += "-";
            }
        list += "\n";
        return list;
    }
    
    */
}
