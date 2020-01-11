/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heila
 */
public class LinkedStack<T> implements Stack<T> {
	private Node<T> top;
        int counter;

	/* Creates a new instance of LinkStack */
	public LinkedStack() {
		top = null;
	}
        
        public boolean empty(){
		return top == null;
	}
        
        
        
        
        
	
	public boolean full(){
		return false;
	}
        
        public void push(T e){
		Node<T> tmp = new Node<T>(e);
		tmp.next = top;
		top = tmp;
                counter ++;
	}
        
        public T pop(){
		T e = top.data;
		top = top.next;
                counter--;
                return e;
	}
        
        
}

