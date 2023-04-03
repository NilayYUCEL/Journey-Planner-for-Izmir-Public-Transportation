import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Operations {

	public Vertex toVertex(String name, String stopName, String x, String y, String type) {
		Vertex vertex = new Vertex(name, stopName, x, y, type);
		return vertex;
	}

	public void ReadFile() throws IOException {

		Graph g = new Graph();
		Vertex source = null;
		Vertex destination;
		//All Hash Maps for adding.
		HashMap<String, String> all_destinations = new HashMap<>();
		HashMap<String, Vertex> all_vertices = new HashMap<>();
		//All arrays for split txt files.
		String[] splitStop;
		String[] splitNeighbor;
		String[] splitDistance;
		String[] splitname;
		String[] splitweight;
		String line_splitStop;
		String stop = "";
		String distance = "";
		String destination_s;
		int control = 0;

		BufferedReader br = new BufferedReader(new FileReader("Stop.txt"));
		while ((stop = br.readLine()) != null) {

			control++;
			if (control != 1) {
				splitStop = stop.split(";");
				source = toVertex(splitStop[0], splitStop[1], splitStop[2], splitStop[3], splitStop[4]);
				line_splitStop = splitStop[5];

				all_destinations.put(source.getName(), splitStop[5]);
				all_vertices.put(source.getName(), source);

			}

		}

		for (Vertex v : all_vertices.values()) {
			try {
				splitNeighbor = all_destinations.get(v.getName()).split("\\.");

				for (int i = 0; i < splitNeighbor.length; i++) {
					splitweight = splitNeighbor[i].split(":");

					destination = toVertex(splitweight[0], all_vertices.get(splitweight[0]).getStopName(),
							all_vertices.get(splitweight[0]).getX(), all_vertices.get(splitweight[0]).getY(),
							all_vertices.get(splitweight[0]).getType());

					g.addVertices(v, destination, Integer.valueOf(splitweight[1]));
					all_vertices.get(splitweight[0]).setType("walking");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		control = 0;
		BufferedReader br1 = new BufferedReader(new FileReader("Distance.txt"));
		while ((distance = br1.readLine()) != null) {

			control++;//Ýlk satýrý okumamak için 
			try {
				if (control != 1) {

					splitDistance = distance.split("\\;");

					//Dosyada bazý vertexlerin bilgileri yoktu. Null atama yapýldý.
					if (!all_vertices.containsKey(splitDistance[0])) {
						source = toVertex(splitDistance[0], null, null, null, null);
						all_vertices.put(splitDistance[0], null);
					}

					else {
						source = toVertex(splitDistance[0], all_vertices.get(splitDistance[0]).getStopName(),
								all_vertices.get(splitDistance[0]).getX(), all_vertices.get(splitDistance[0]).getY(),
								all_vertices.get(splitDistance[0]).getType());
					}
					System.out.println(splitDistance[1]);

					//Dosyada bazý vertexlerin bilgileri yoktu. Null atama yapýldý.
					if (!all_vertices.containsKey(splitDistance[1])) {
						destination = toVertex(splitDistance[1], null, null, null, null);
						all_vertices.put(splitDistance[1], null);
					} else {
						destination = toVertex(splitDistance[1], all_vertices.get(splitDistance[1]).getStopName(),
								all_vertices.get(splitDistance[1]).getX(), all_vertices.get(splitDistance[1]).getY(),
								all_vertices.get(splitDistance[1]).getType());
					}
					g.addVertices(source, destination, Integer.valueOf(splitDistance[2]));
					if (all_vertices.containsKey(splitDistance[0]))
						g.setEdge_type(all_vertices.get(splitDistance[0]).getType());

				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		g.print();
		System.out.println("\n\nSEARCH:");
		g.Search("50515");
		
		
	    Dijkstra dij= new Dijkstra(g,"40015","40121");
	    System.out.println("\n\nSHORTEST PATH: ");
		dij.Print();

	}

}
