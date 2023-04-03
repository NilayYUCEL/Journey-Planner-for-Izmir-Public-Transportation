import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	private HashMap<String, Vertex> vertices;
	private int size;
	private String edge_type;

	public void addVertices(Vertex source, Vertex destination, int weight) {
		Edge edge = new Edge(source, destination, weight, edge_type);

		source.addEdge(edge);
		try {
			if (!vertices.containsKey(source.getName())) {
				vertices.put(source.getName(), source);

			} else
				vertices.get(source.getName()).addEdge(edge);

		} catch (Exception e) {

		}

	}

	public Vertex getVertex(String name) {
		return vertices.get(name);
	}

	public LinkedList<Edge> numberEdge(String name) {
		return vertices.get(name).getEdges();

	}

	public int Size() {
		size = vertices.size();
		return size;
	}

	public void Search(String name) {
		try {

			for (Vertex v : vertices.values()) {
				if (v.getName().equals(name)) {
					System.out.println(v.getName() + "----> ");
					v.printEdge();
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void print() {
		for (Vertex v : vertices.values()) {
			System.out.println(v.getName() + "----> ");
			v.printEdge();
		}

	}

	public HashMap<String, Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(HashMap<String, Vertex> vertices) {
		this.vertices = vertices;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getEdge_type() {
		return edge_type;
	}

	public void setEdge_type(String edge_type) {
		this.edge_type = edge_type;
	}

	public Graph() {
		this.vertices = new HashMap<>();
	}
}
