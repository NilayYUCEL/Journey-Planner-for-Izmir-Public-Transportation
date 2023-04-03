
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Vertex {

	private String name;
	private LinkedList<Edge> edges;//for record vertex's edges.
	private String stopName;
	private String x;
	private String y;
	private String type;
	

	public Vertex(String name,String stopName,String x,String y,String type) {
		this.name = name;
		edges = new LinkedList<>();
		this.stopName=stopName;
		this.x=x;
		this.y=y;
		this.type=type;
		
	
	}

	public void addEdge(Edge edge) {
		if (!edges.contains(edge)) {
			edges.add(edge);
		}
	}
	public void printEdge() {
		Iterator<Edge> i = edges.iterator();
		while(i.hasNext())
		    System.out.println(i.next().print());
	}
	



	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(LinkedList<Edge> edges) {
		this.edges = edges;
	}

}
