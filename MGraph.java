
public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Map<K, List<K>> adj; // Do not change this
	public MGraph() {
		adj = new BSTMap<K, List<K>>();
	}
        
        
	// Add a node to the graph if it does not exist and return true. If the node already exists, return false.
	public boolean addNode(K i){
            
            LinkedList<K> list = new LinkedList<K>();
            return adj.insert(i, list);
        }

	// Check if i is a node
	public boolean isNode(K i){
            
            
            List<K> q = adj.getKeys();
            int len = q.size();
            q.findFirst();
            for(int k = 0; k < len;k++){
                if(q.retrieve().compareTo(i)==0)
                    return true;
                q.findNext();
            }
            return false;
        }

	// Add an edge to the graph if it does not exist and return true. If i or j do not exist or the edge (i, j) already exists, return false.
	public boolean addEdge(K i, K j){
            
            
            
            if (isNode(i)&&isNode(j)){
             List<K> f = adj.retrieve(i).second;
             List<K> s = adj.retrieve(j).second;
             if (!f.exists(j)&&!s.exists(i)){
                 f.insert(j);
                 s.insert(i);
                 return true;
             }
            }
                 return false;
            
        }

	// Check if (i, j) is an edge.
	public boolean isEdge(K i, K j){
            
            if (isNode(i)&&isNode(j)){
                if(adj.retrieve(i).second.exists(j) && adj.retrieve(j).second.exists(i))
                    return true;
            }
                return false;
        }

	// Return the set of neighbors of node i. If i does not exist, the method returns null.
	public List<K> neighb(K i){
            if (isNode(i)){
                List <K>neigh = adj.retrieve(i).second;
            return neigh;
            }
            return null;
            
        }

	// Return the degree (the number of neighbors) of node i. If i does not exist, the method returns -1.
	public int deg(K i){
            if (isNode(i)){
                return adj.retrieve(i).second.size();
            }
            return -1;
        }

	// Return a list containing the nodes in increasing order.
	public List<K> getNodes(){
            
                return adj.getKeys();
            
        }
	
} 
