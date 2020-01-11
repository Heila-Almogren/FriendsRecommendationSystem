/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heila
 */
public class Node <T> {
    	public T data;
	public Node<T> next;

	public Node () {
		data = null;
		next = null;
	}

	public Node (T val) {
		data = val;
		next = null;
	}
        
        public T getData(){
            return data;
        }
        
        public void setData(T e){
            data = e;
        }
        
        public Node next(){
            return next;
        }
        
        public void setNext(Node<T> N){
            next = N;
        }
        
        

}
