package MethodsPkg;

public class HNode <T> {  
    private T value;
    private HNode<T> next;
    
    public HNode(T value){
        this.value = value;
        this.next = null;
    }
    
    public T getValue(){
        return this.value;
    }
    
    public void setValue(T value){
        this.value = value;
    }
    
    public HNode<T> getNext(){
        return this.next;
    }
    
    public void setNext(HNode<T> next){
        this.next = next;
    }
    
}
