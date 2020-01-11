public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
	public BSTNode<K, T> root; // Do not change this
	
        int size = 0;
        
	public BSTMap() {
		root = null;
	}
        
        // Return the size of the map.
	public int size(){
            return size;
        }

	// Return true if the map is full.
	public boolean full(){
            return false;
        }

	// Remove all elements from the map.
	public void clear(){
            root = null;
            size = 0;
        }

	// Update the data of the key k if it exists and return true. If k does not exist, the method returns false.
	public boolean update(K k, T e){
            	
            BSTNode<K, T> p = root;
				
		if(root==null)
			return false;
		
		while(p != null) {
			
			if(p.key.compareTo(k)==0) {
				p.data=e;
				return true;
			}
			else if(k.compareTo(p.key)==-1)
				p = p.left;
			else
				p = p.right;
		}
		
		
		return false;

        }

	// Search for element with key k and returns a pair containing true and its data if it exists. If k does not exist, the method returns false and null.
	public Pair<Boolean, T> retrieve(K k){
            BSTNode<K, T> p = root;
            Pair <Boolean, T> ret;
		if(root==null){
                    ret = new Pair <Boolean, T> (false, null);
			return ret;
                }
                    
		
		while(p != null) {
			
			if(p.key.compareTo(k)==0) {
                            ret = new Pair <Boolean, T> (true, p.data);
				return ret;
			}
			else if(k.compareTo(p.key)==-1)
				p = p.left;
			else
				p = p.right;
		}
		
		ret = new Pair <Boolean, T> (false, null);
		return ret;
        }

	// Insert a new element if does not exist and return true. If k already exists, return false.
	public boolean insert(K k, T e){
            
            
            //System.out.println("recieved " + e);
            BSTNode<K, T> p, q;
            if (retrieve(k).first!= false && retrieve(k).second!=null){
                //System.out.println("key already exists");
                return false;
            }
                
		BSTNode<K, T> N = new BSTNode<K, T>(k, e);
		if (root == null) {
			root = N;
                        size++;
                        //System.out.println(e+"Added successfully at root");
			return true;
		}else{
                    p = q = root;
                    while(p != null) {
                        //System.out.println("moving p");
				
			q = p;
                        
			if(p.key.compareTo(k)==0) {
                            //System.out.println("key already exists");
				return false;
			}
			else 
                            if(k.compareTo(p.key)==-1){
                            p = p.left;
                            //System.out.println("p moved left");
                        } else {
                            p = p.right;
                            //System.out.println("p moved right");
                        }
				
		}
                    //System.out.println("p is now null");
                    if (k.compareTo(q.key)==-1){
                        q.left=N;
                        size++;
                        //System.out.println(e+"Added successfully at the left of " + q.data);
                        return true;
                    }
                        
                    else{
                        //System.out.println(e+"Added successfully at the right of " + q.data);
                        q.right=N;
                        size++;
                        return true;
                    }
                        
                    
                }

        }
        boolean removed = false;
	// Remove the element with key k if it exists and return true. If the element does not exist return false.
	public boolean remove(K k){
            
            if (getKeys().exists(k)){
                size--;
                BSTNode<K, T> p;
		p = remove_aux(k, root, removed);
		return true;
            }
            return false;
            
		
         
        }
        
        private BSTNode<K, T> remove_aux(K k, BSTNode<K, T> p, boolean flag) {
		BSTNode<K, T> q, child = null;
		if(p == null)
			return null;
		if(k.compareTo(p.key)==-1)
			p.left = remove_aux(k, p.left, flag); //go left
		else if(k.compareTo(p.key)==1)
			p.right = remove_aux(k, p.right, flag); //go right
		else {
                    
			flag= true;
			if (p.left != null && p.right != null){ //two children
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right, flag);
			}
                        			else {
				if (p.right == null) //one child
					child = p.left;
				else if (p.left == null) //one child
					child = p.right;
				return child;
			}
		}
                
		return p;

                }
        
        
	private BSTNode<K, T> find_min(BSTNode<K,T> p){
		if(p == null)
			return null;
		
		while(p.left != null){
			p = p.left;
		}
		
		return p;
	}



	// Return the list of keys in increasing order.
	public List<K> getKeys(){

                return rec_getKeys(root);
		
		

            
        }
        
        
        
        public LinkedList<K> rec_getKeys(BSTNode<K, T> b){
            
            LinkedList<K> L = new LinkedList<K>();
            if (b==null){
                //System.out.println("now b is null");
                return L;
            }
            //System.out.println("now b is " + b.data);
            if (b.left != null){
                //System.out.println("there is a left child");
                L.append(rec_getKeys(b.left));
            }
            
            L.insert(b.key);
            //System.out.println("added " + b.data);
            if (b.right != null){
                //System.out.println("there is a righf child");
                 L.append(rec_getKeys(b.right));
            }
           
            return L;

        }
}