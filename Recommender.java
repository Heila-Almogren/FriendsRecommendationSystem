
import java.io.File;
import java.util.Scanner;

public class Recommender {

	// Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
		
            
            if(!g.getNodes().exists(i)){
                return null;
            }
            PQK <Double, K> top = new PQKImp<Double, K>(k);
                
                List<K> Nodes = g.getNodes();
                int len = Nodes.size();
                
                Nodes.findFirst();
                for(int j = 0; j < len; j++){
                    K key = Nodes.retrieve();
                    if(key!=i&&!g.neighb(key).exists(i) ){
                        double degree = g.deg(key);
                        top.enqueue(degree, key);
                    }
                    Nodes.findNext();
                }
                return top;
	}

	// Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
		
            if(!g.getNodes().exists(i)){
                return null;
            }
            
            PQK <Double, K> top = new PQKImp<Double, K>(k);
                
                List<K> Nodes = g.getNodes();
                int len = Nodes.size();
                
                Nodes.findFirst();
                for(int j = 0; j < len; j++){
                    K key = Nodes.retrieve();
                    if(key!=i&&!g.neighb(key).exists(i)){
                        double common = CommonItems(g.neighb(i), g.neighb(key));
                        
                        top.enqueue(common, key);
                    }
                    Nodes.findNext();
                }
                return top;
	}

	// Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
	public static Graph<Integer> read(String fileName) {

		try {
			Graph<Integer> g = new MGraph<Integer>();
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextInt()) {
				int i = scanner.nextInt();
				g.addNode(i);
				int j = scanner.nextInt();
				g.addNode(j);
				g.addEdge(i, j);
			}
			scanner.close();
			return g;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
        
        public static <K extends Comparable<K>> int CommonItems(List<K> L1, List<K> L2){
            
            int c = 0;
            int len1 = L1.size();
            int len2 = L2.size();
            
            L1.findFirst();
            K matchItem;
            K s;
            for(int i = 0; i < len1; i++){
                matchItem = L1.retrieve();
                
                //searching for matching of item in L2
                L2.findFirst();
                for(int z = 0; z < len2; z++){
                    s = L2.retrieve();
                    
                    if (s.compareTo(matchItem)==0){
                        c++;
                    }
                    L2.findNext();
                }
                
                
                
                L1.findNext();
            }
            
            
            return c;
        }
        
}
