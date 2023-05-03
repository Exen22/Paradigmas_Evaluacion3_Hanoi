package MethodsPkg;

import javax.swing.JOptionPane;

/**
 *
 * @author Willian Coral
 */
public class HanoiLoop {
    private boolean exit;
    private int discs; //NUMERO DE DISCOS
    private HStack[] stack; //Pilas (torres) donde van a estar los discos
    private String[] list; //donde se van a guardar los datos de cada pila por separado
    private String fList; //lista donde se van a guardar los datos de las 3 pilas para mostrarlo por pantalla
    
        
    public HanoiLoop(){
        this.list = new String[3];
        this.exit = false;
        this.stack = new HStack[3];
        
        for(int i=0; i<3; i++){
            stack[i] = new HStack();
        }
    }
    
    //BUCLE PRINCIPAL DEL JUEGO
    public void game(){
        int aux1, aux2;
        
        //ESTABLECER CANTIDAD DE DISCOS
        setDiscs();
        
        //LLENAR LA PRIMERA PILA CON LOS DISCOS
        for(int i=0; i<discs; i++){
            stack[0].push(discs-i);
        }
        
        
        //BUCLE PRINCIPAL (AQUI VA CADA FRAME DEL JUEGO)
        do{
            //GUARDAR EN fList LOS DATOS DE CADA PILA
            frame();
            
            //PEDIR DATOS PARA EL PROCESO Y A LA VEZ MOSTRAR CON EL JOptionPane LOS FRAMES (fList)
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
    
    //Guardar en fList los datos de cada pila para posteriormente mostrarlo por pantalla
    private void frame(){
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
    }
    
    //Establecer numero de discos
    public void setDiscs(){
        discs = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de discos: "));
    }
    
    //Metodo para llenar una list[] con guiones ("-") si está vacia
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
