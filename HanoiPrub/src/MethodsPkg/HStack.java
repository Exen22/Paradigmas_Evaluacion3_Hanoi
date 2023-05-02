package MethodsPkg;

public class HStack<T> {
    
    private HNode<T> lastValue;
    private int size;
    String list;
    
    //Constructor
    public HStack(){
        lastValue = null;
        size = 0;
        list = "";
    }
    
    //Push
    public void push(T nodeValue){
        HNode<T> newNode = new HNode<>(nodeValue);
        newNode.setNext(lastValue);
        lastValue = newNode;
        size++;
    }
    
    //Pop
    public T pop(){
        T aux = lastValue.getValue();
        lastValue = lastValue.getNext();
        size--;
        return aux;
    }
    
    //peek
    public T peek(){
        return lastValue.getValue();
    }
    
    //is Empty?
    public boolean isEmpty(){
        return lastValue == null;
    }
    
    //get size
    public int getSize(){
        return size;
    }
    
    //Pop All
    public void popAll(){
        while(!isEmpty()){
            pop();
        }
    }
    
    //Contenido de la pila
    public String getContent(){
        HNode<T> aux = lastValue;
        list = "";
        
        while(aux != null){
            list += aux.getValue() + "\n";
            aux = aux.getNext();
        }
        
        return list;
    }
}
