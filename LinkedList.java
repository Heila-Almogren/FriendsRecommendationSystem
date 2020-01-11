/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heila
 */
public class LinkedList<T> implements List<T>{      //tested

    private Node<T> head;
    private Node <T> current;
    private int length = 0;
    
public LinkedList () {  //varified
head = current = null;
}





public int getLength(){
    return length;
}

    @Override    
public boolean empty(){     //varified
    
    return (head == null);
}

@Override
public boolean full(){      //varified
    return false;    
}

@Override
public void findFirst(){        //varified
    current = head;
}

@Override
public void findNext(){         //varified
    current = current.next;
}

@Override
public boolean last(){      //varified

    return (current.next == null);
}

@Override
public T retrieve(){        //varified
    return current.data;
}

@Override
public void update(T e){        //varified
    current.data = e;
}

@Override
public void insert(T e){        //varied
    
    Node<T> tmp;
    length++;
		if (empty()) {
			current = head = new Node<T> (e);
                        
		}
		else {
			tmp = current.next;
			current.next = new Node<T> (e);
			current = current.next;
			current.next = tmp;
		}
}

@Override
public void remove(){       //varified
    
    		if (current == head) {
			head = head.next;
		}
		else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
                
                if (length > 0){
                    length--;
                }
	}

            public int size(){
                return length;
            }


        public boolean exists(T e){
            
            
            boolean found = false;
            Node <T> p = current;
            T x;
            findFirst();
            for (int i = 0; i < size(); i++){
                x = retrieve();
                if (x == e){
                    found = true;
                    break;
                }
                findNext();
            }
            findFirst();
            for (int i = 0; i < size(); i++){
                x = retrieve();
                if (x == p.data){
                    return found;
                }
                findNext();
            }
            return found;
        }
        
        
        public void append(LinkedList<T> t){
            //checking
            int len = t.getLength();
            t.findFirst();
            for(int i = 0; i < len; i++){
                insert(t.retrieve());
                t.findNext();
            }
            
        }




}
