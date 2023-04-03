import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
	private HashMap<String, Integer> distance;//for record distance
	private String source;//for input for first destination
	private String destination;//for input second destination
	private PriorityQueue<String> pq;//for dijkstra algothritms
	private HashMap<String, String> Path;//The shortest path way
	private Graph g;
	private boolean walking = false;//user should walk one times.

	@SuppressWarnings("rawtypes")
	public Dijkstra(Graph g, String source, String destination) {
		this.source = source;
		this.destination = destination;
		this.g = g;
		pq = new PriorityQueue<String>(g.Size(), new PathComparator());
	}

	//Dijkstra algortihtms
	public void shortestPath() {
		distance = new HashMap<>();
		Path = new HashMap<>();
		for (Vertex v : g.getVertices().values()) {
			distance.put(v.getName(), 999999999);
			Path.put(v.getName(), null);
		}
		distance.replace(source, 0);
		String element = source + "-" + distance.get(source);
		pq.add(element);
		Path.put(source, null);
		while (!pq.isEmpty()) {
			String queue = pq.remove();
			String[] array = new String[2];
			array = queue.split("-");
			if (g.numberEdge(array[0]) != null) {
				LinkedList<Edge> Edges = new LinkedList<>();
				Edges = g.numberEdge(array[0]);
				while (!Edges.isEmpty()) {
					Edge edges = Edges.pollFirst();
					int weight = edges.getWeight() + Integer.valueOf(distance.get(array[0]));
					try {
						if (weight < distance.get(edges.getDestination().getName())) {
							distance.replace(edges.getDestination().getName(), weight);
							Path.put(edges.getDestination().getName(), edges.getSource().getName());
							String insertq = edges.getDestination().getName() + "-"
									+ distance.get(edges.getDestination().getName());
							pq.add(insertq);
							if (edges.getDestination().getType().equals("walking")) {
								walking = true;
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
	}

	public void Print() {

		shortestPath();
		String order = destination + " ";
		String actual = destination;
		String past = "";
		while (actual != null) {
			past = actual;
			actual = Path.get(actual);
			try {
				if (!g.getVertex(past).getStopName().equals(g.getVertex(actual).getStopName())) {
					if (actual != null)
						order += actual + " ";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		System.out.println(order + " ");
	}

}
