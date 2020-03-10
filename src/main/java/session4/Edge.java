package session4;

/**
 *  Represents an edge of the graph with all its information
  * We allow direct access to the fields from any class of the package
  * (as if they were properties)
 */
public class Edge implements Comparable<Edge>{
	int sourceNode; //edge source node
	int targetNode;	//edge target node
	int cost; //edge cost
	
	public Edge(int sourceNode, int targetNode, int cost) {
		this.sourceNode = sourceNode;
		this.targetNode = targetNode;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}		
}