public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {      //tested
	
        private int maxsize = 0;
    private int size = 0;
    private PQNode<P, T> head;
    
    public PQKImp(int k) {
		maxsize=k;
	}
		// Return the length of the queue
	public int length(){
            return size;
        }

	// Enqueue a new element. The queue keeps the k elements with the highest priority. In case of a tie apply FIFO.
	public void enqueue(P pr, T e){
            
            
                                PQNode<P, T> tmp = new PQNode<P, T>(e, pr);
		if((size == 0) || pr.compareTo(head.priority)==1) {
			tmp.next = head;
			head = tmp;
		}
		else {
			PQNode<P, T> p = head;
			PQNode<P, T> q = null;
			while((p != null) && (pr.compareTo(p.priority)<=0)) {
				q = p;
				p = p.next;
			}
			tmp.next = p;
			q.next = tmp;
		}
		size++;
                if(size > maxsize){
                removeSmallest();
            }
        }
        
        private void removeSmallest(){
            
            
            int len = size;
            PQKImp<P, T> s = new PQKImp<P, T>(len);
            Pair<P, T> pqe;
            
            for (int i = 0 ; i < len ; i++){
                pqe = serve();
                
                s.enqueue(pqe.first, pqe.second);
            }
            
            for (int i = 0 ; i < maxsize ; i++){
                pqe = s.serve();
                enqueue(pqe.first, pqe.second);
            }
            
            
            
                
            
        }

	// Serve the element with the highest priority. In case of a tie apply FIFO.
	public Pair<P, T> serve(){
            		PQNode<P, T> node = head;
		Pair<P, T> pqe=new Pair<P, T>(node.priority, node.data);
		head = head.next;
		size--;
		return pqe;
        }
}
