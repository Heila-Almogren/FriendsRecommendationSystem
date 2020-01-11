/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heila
 */
//I made this class
public class PQNode<P extends Comparable<P>, T> {
	public T data;
	public P priority;
	public PQNode<P, T> next;
	
	public PQNode() {
		next = null;
	}
	
        
        
	public PQNode(T e, P p) {
		data = e;
		priority = p;
	}

	
}
