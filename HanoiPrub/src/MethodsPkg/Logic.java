package MethodsPkg;

import javax.swing.JOptionPane;

/**
 *
 * @author Willian Coral
 */
public class Logic {
    
    public static void main(String[] args){
        
        boolean exit = false;
        int discs = 3;
        String list1, list2, list3, fList;
        
        
        /*HStack stack1 = new HStack();
        HStack stack2 = new HStack();
        HStack stack3 = new HStack();
        */
        
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
            list1 = "-\n"; list2 = "-\n"; list3= "-\n";
            
            //1
            if("".equals(stack[0].getContent())){
                list1 = refill(discs, list2);
            }
            else{
                list1 += stack[0].getContent();
            }

            //2
            if("".equals(stack[1].getContent())){
                list2 = refill(discs, list2);
            }
            else{
                list2 += stack[1].getContent();
            }

            //3
            if("".equals(stack[2].getContent())){
                list3 = refill(discs, list3);
            }
            else{
                list3 += stack[2].getContent();
            }
            fList = list1 + "\n" + list2 + "\n" + list3;

            /*JOptionPane.showMessageDialog(null, list1);
            JOptionPane.showMessageDialog(null, list2);
            JOptionPane.showMessageDialog(null, list3);
            */

            //JOptionPane.showMessageDialog(null, fList);
            int aux1, aux2;
            aux1 = Integer.parseInt(JOptionPane.showInputDialog(null, fList + "\n\n\n Mover desde la torre: "));
            aux2 = Integer.parseInt(JOptionPane.showInputDialog(null, fList + "\n\n\n Hasta la torre: "));
            
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
                        if((int)stack[aux1-1].peek() < (int)stack[aux2-1].peek()){ //MOSCA
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
    
}
