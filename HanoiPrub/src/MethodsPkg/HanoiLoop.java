package MethodsPkg;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import java.awt.Font;


/**
 *
 * @author Willian Coral
 */
public class HanoiLoop {
    private boolean exit;
    private int discs, t1, t2, moves=0; //Numero de discos // T1 es la torre que envia el disco y T2 la que lo recibe
    private HStack[] stack; //Pilas (torres) donde van a estar los discos
    private String[] list; //donde se van a guardar los datos de cada pila por separado
    //private String fList; //lista donde se van a guardar los datos de las 3 pilas para mostrarlo por pantalla
    private JPanel fList = new JPanel();
    private JDialog dialog = new JDialog();
    
    private String[] options = {"Torre 1", "Torre 2", "Torre 3", "retry"};
    
    
    //CONSTRUCTOR    
    public HanoiLoop(){
        this.list = new String[3];
        this.exit = false;
        this.stack = new HStack[3];
        this.t1 = 0;
        this.t2 = 0;
        //this.moves = 0;
        
        for(int i=0; i<3; i++){
            stack[i] = new HStack();
            
        }
    }
    
    //BUCLE PRINCIPAL DEL JUEGO
    public void game(){
        
        //ESTABLECER CANTIDAD DE DISCOS
        setDiscs();
        
        //LLENAR LA PRIMERA PILA CON LOS DISCOS
        retry();
        
        //BUCLE PRINCIPAL (AQUI VA CADA FRAME DEL JUEGO)
        do{
            //GUARDAR EN fList LOS DATOS DE CADA PILA
            frame();
            
            //PEDIR DATOS PARA EL PROCESO Y A LA VEZ MOSTRAR CON EL JOptionPane LOS FRAMES (fList)
            setTower1();
            setTower2();
            
            //PROCESO
            if (t1<1 || t1>3 || t2<1 || t2>3){
                JOptionPane.showMessageDialog(null, "MOVIMIENTO INVALIDO");
                moves--;
            }
            else{
                //Verificar que hay discos disponibles para mover desde aux1
                if(stack[t1-1].isEmpty()){
                    JOptionPane.showMessageDialog(null, "MOVIMIENTO INVALIDO");
                    moves--;
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
                            moves--;
                        }
                    }
                }
            }
            
            //condicion de salida 3era pila llena
            if(stack[2].getSize() == discs){
                frame();
                JOptionPane.showMessageDialog(null, fList, "\n\n HAS GANADO, FELICITACIONES", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Cantidad de Movimientos: "+ moves);
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
                //list[i] += stack[i].getContent();
                list[i] += stack[i].getFrameContent();
                
            }
            JTextArea textArea = new JTextArea(list[i]);
            Font font = new Font("Serif", Font.PLAIN, 20);
            textArea.setFont(font);
            fList.add(textArea);

        }
    }
    
    //Establecer numero de discos
    private void setDiscs(){
        //boolean flag = true;
        while(true){
            try{
                String aux;   
                //ingresar cantidad de discos y verificar que no sean menores a 1 ni mayores a 8
                do{
                
                    aux = JOptionPane.showInputDialog(null, "Por favor Ingrese la cantidad de discos: ", "Discos", JOptionPane.INFORMATION_MESSAGE);



                    if(aux == null){
                        throw new NullPointerException();
                    }
                    
                    if(Integer.parseInt(aux) > 8 || Integer.parseInt(aux) < 1){
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad de discos entre 1 y 8");
                    }
                }while(Integer.parseInt(aux) > 8 || Integer.parseInt(aux) < 1);
                
                discs = Integer.parseInt(aux);
                break;
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
    private void setTower1(){
        //boolean flag = true;
            
            while(true){
                
                //TORRE 1
                try{
                    boolean exit2 = false;
                    do{
                        t1 = 1 + JOptionPane.showOptionDialog(dialog,
                            fList,
                            "Mover desde la torre:",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            options,
                            options[0]);
                        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        
                        if(t1 != 4){
                        
                            //si le da a la X (salir)
                            if(t1 == 0 /*|| t1 == -1*/){
                                throw new NullPointerException();
                            }
                            //si la torre seleccionada está vacia
                            if(stack[t1-1].isEmpty()){
                                JOptionPane.showMessageDialog(null, "TORRE VACIA, SELECCIONE OTRA");
                            }
                            
                            if(!stack[t1-1].isEmpty()) exit2 = true;
                        }
                        else{
                            int opc =JOptionPane.showConfirmDialog(null,"Esta seguro de reiniciar el juego?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                    
                            if (opc==JOptionPane.YES_OPTION){
                                throw new retryGame();
                            }
                            else{
                                exit2 = false;
                            }
                        }
                        
                    }while(exit2 != true); //mientras que la torre seleccionada esté vacia
                    
                    moves++;
                    break;
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
                catch(retryGame e){
                    retry();
                    t2 = 0;
                    t1 = 0;
                    
                }
                
            }
    }
    
    private void setTower2(){
        //TORRE 2
        while(true){
            try{
                do{
                    t2 = 1 + JOptionPane.showOptionDialog(dialog,
                        fList,
                        "Mover Hasta la torre:",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    
                    //si no se ha presionado el boton de reincio (4)
                    if(t2 != 4){
                        //si le da a la X (salir)
                        if(t2 == 0 /*|| t2 == -1*/){
                            throw new NullPointerException();
                        }

                        //si selecciona la misma torre de origen
                        if(t1 == t2){
                            //JOptionPane.showMessageDialog(null, "NO PUEDES SELECCIONAR LA MISMA TORRE DE ORIGEN");
                            throw new cancel();
                        }
                    }
                    //si se presiona el boton de reinicio (4)
                    else{
                        int opc =JOptionPane.showConfirmDialog(null,"Esta seguro de reiniciar el juego?", "Confirmacion", JOptionPane.YES_NO_OPTION);

                        if (opc==JOptionPane.YES_OPTION){
                            throw new retryGame();
                        }
                        else{
                            t2 = t1;
                        }
                    }
                }while(t1 == t2);

                break;
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
            catch(retryGame e){
                retry();
                t2 = 0;
                t1 = 0;
                setTower1();
                setTower2();
                break;
            }
            catch(cancel e){
                setTower1();
                setTower2();
                moves--;
                break;
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
    
    //reiniciar el juego
    private void retry(){
        
        for(int i = 0; i<3; i++){
            stack[i].popAll();
        }
        
        for(int i=0; i<discs; i++){
            stack[0].push(discs-i);
        }
        moves = 0;
        frame();
    }
    
    //Exception propia
    private class retryGame extends Exception{
        
        public retryGame(){
            super("retry");
        }
    }
    //Exception propia
    private class cancel extends Exception{
        
        public cancel(){
            super("cancel");
        }
    }
    
    
}
    