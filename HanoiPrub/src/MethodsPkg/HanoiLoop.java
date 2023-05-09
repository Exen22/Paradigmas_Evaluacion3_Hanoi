package MethodsPkg;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;


/**
 *
 * @author Willian Coral
 */
public class HanoiLoop {
    private boolean exit;
    private int discs, t1, t2; //Numero de discos // T1 es la torre que envia el disco y T2 la que lo recibe
    private HStack[] stack; //Pilas (torres) donde van a estar los discos
    private String[] list; //donde se van a guardar los datos de cada pila por separado
    //private String fList; //lista donde se van a guardar los datos de las 3 pilas para mostrarlo por pantalla
    private JPanel fList = new JPanel();
    //JTextArea[] textArea;
    
    
        
    public HanoiLoop(){
        this.list = new String[3];
        this.exit = false;
        this.stack = new HStack[3];
        
        
        for(int i=0; i<3; i++){
            stack[i] = new HStack();
            //textArea[i] = new JTextArea();
        }
    }
    
    //BUCLE PRINCIPAL DEL JUEGO
    public void game(){
        
        
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
            setTowers();
            
            //PROCESO
            if (t1<1 || t1>3 || t2<1 || t2>3){
                JOptionPane.showMessageDialog(null, "MOVIMIENTO INVALIDO");
            }
            else{
                //Verificar que hay discos disponibles para mover desde aux1
                if(stack[t1-1].isEmpty()){
                    JOptionPane.showMessageDialog(null, "MOVIMIENTO INVALIDO");
                }
                else{
                    //Verificar si aux2 está vacio, si lo está entonces se mueve el disco
                    if(stack[t2-1].isEmpty()){
                        stack[t2-1].push(stack[t1-1].pop());
                    }
                    //Verificar tamaño del disco de aux1 y que sea menor que el de aux2
                    else{
                        if((int)stack[t1-1].peek() < (int)stack[t2-1].peek()){
                            stack[t2-1].push(stack[t1-1].pop());
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "MOVIMIENTO INVALIDO");
                        }
                    }
                }
            }
            
            //condicion de salida 3era pila llena
            if(stack[2].getSize() == discs){
                frame();
                JOptionPane.showMessageDialog(null, fList, "\n\n HAS GANADO, FELICITACIONES", JOptionPane.INFORMATION_MESSAGE);
                exit=true;
            }
            
        }while(exit!=true);
    }
    
    //Guardar en fList los datos de cada pila para posteriormente mostrarlo por pantalla
    private void frame(){
        fList.removeAll();
        fList.setLayout(new BoxLayout(fList, BoxLayout.X_AXIS));
        
        
        for(int i = 0; i < 3; i++){    
            list[i] = "-\n";
        }

        for(int i = 0; i < 3; i++){
            //si la pila está vacia llenarla de guiones
            if("".equals(stack[i].getContent())){
                list[i] = refill(discs, list[i]);
            }
            else{
                //PONER LOS GUIONES "-" A LAS PILAS 
                for(int j = stack[i].getSize(); j<discs; j++){
                    list[i] += "-\n";
                }
                //añadirle el contenido de la pila
                list[i] += stack[i].getContent();
                
                
            }
            JTextArea textArea = new JTextArea(list[i]);
            fList.add(textArea);

        }
    }
    
    //Establecer numero de discos
    public void setDiscs(){
        boolean flag = true;
        
        while(flag == true){
            
            try{
                String aux;
                aux = JOptionPane.showInputDialog(null, "Ingrese la cantidad de discos: ");
                
                if(aux == null){
                    throw new NullPointerException();
                }
                
                discs = Integer.parseInt(aux);
                //discs = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de discos: "));
                flag = false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalido");
            }
            catch(NullPointerException e){
                
                int opc =JOptionPane.showConfirmDialog(null,"Esta seguro de salir del programa?", "Confirmacion", JOptionPane.YES_NO_OPTION);

                    if (opc==JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                    
            }
        }
        
    }
    
    //Establecer las torres de donde se van a mover los discos
    private void setTowers(){
        boolean flag = true;
            
            while(flag == true){
                try{
                    String aux;
                    /*T1 = Integer.parseInt(JOptionPane.showInputDialog(null, fList + "\n\n\n Mover desde la torre: "));
                    T2 = Integer.parseInt(JOptionPane.showInputDialog(null, fList + "\n\n\n Hasta la torre: "));
                    */
                    aux = JOptionPane.showInputDialog(null, fList, "\n\n\n Mover desde la torre: ", JOptionPane.INFORMATION_MESSAGE);
                    if(aux == null){
                        throw new NullPointerException();
                    }
                    t1 = Integer.parseInt(aux);
                    
                    aux = JOptionPane.showInputDialog(null, fList, "\n\n\n Hasta la torre: ", JOptionPane.INFORMATION_MESSAGE);
                    if(aux == null){
                        throw new NullPointerException();
                    }
                    t2 = Integer.parseInt(aux);
                    
                    flag = false;
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalido");
                }
                catch(NullPointerException e){
                    int opc =JOptionPane.showConfirmDialog(null,"Esta seguro de salir del programa?", "Confirmacion", JOptionPane.YES_NO_OPTION);

                    if (opc==JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                }
            }
        
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
