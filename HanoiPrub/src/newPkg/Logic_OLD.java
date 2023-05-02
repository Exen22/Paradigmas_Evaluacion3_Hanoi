package newPkg;

import MethodsPkg.HStack;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian Coral
 */

public class Logic_OLD {
    
    //public static void main(String[] args){
    public void lmao(){
        int discs = 3;
        String list = "-\n";
        String list2 = "-\n";
        String list3 = "-\n";
        
        HStack stack1 = new HStack();
        HStack stack2 = new HStack();
        HStack stack3 = new HStack();
        
        //LLENAR LA PRIMERA PILA CON LOS DISCOS
        for(int i=0; i<discs; i++){
            stack1.push(discs-i);
        }
        
        
        
        
        
        /*//PROTOTIPO GUIONES PARA LA PILA
        int count1 = 0;//count1 = 0 si la pila está vacia para mostrar todos los espacios con guiones "-"
        
        
        while(count1 < stack1.getSize()){
            count1++;
            if(count1 == stack1.getSize()){
                list = list + "-";
            }
            else{
                list = list + "-\n";
            }
        }*/
        
        //MOSTRAR PILAS
        if(stack1.isEmpty()){
            for(int i = 0; i<discs; i++){
                if(i!=0){
                    list += "\n";
                }
                list += "-";
            }
        }
        else{
            while(!stack1.isEmpty()){
                list +=  stack1.pop() + "\n";
            }    
        }
        
        //2
        if(stack2.isEmpty()){
            for(int i = 0; i<discs; i++){
                if(i!=0){
                    list2 += "\n";
                }
                list2 += "-";
            }
        }
        else{
            while(!stack2.isEmpty()){
                list2 += stack2.pop() + "\n";
            }    
        }
        
        //3
        if(stack3.isEmpty()){
            for(int i = 0; i<discs; i++){
                if(i!=0){
                    list3 += "\n";
                }
                list3 += "-";
            }
        }
        else{
            while(!stack3.isEmpty()){
                list3 += stack3.pop() + "\n";
            }    
        }
        
        JOptionPane.showMessageDialog(null, list + "\n\n" + list2 + "\n\n" + list3);
        
        
        
        /*
        //MOSTRAR PRIMERA PILA
        for(int i=0; i<discs; i++){
            Disk aux = (Disk) stack1.pop();
            
            JOptionPane.showMessageDialog(null, "VALOR ["+(i+1)+"]: "+aux.getValue());
        }
        */
        

    }
}
