
public class Edge {

	private Vertex destination;
	private Vertex Source;
	private int weight;
	private String type;
	
	public Edge(Vertex source,Vertex destination,int weight,String type) {
		this.Source=source;
		this.destination=destination;
		this.weight=weight;
		this.type=type;
		
	}
	

	public String print()
	{
		String print1;
		if(destination.getName()!=null)
		print1="("+destination.getName().toString()+","+String.valueOf(weight)+")";
		else
			print1=" ";
		return print1;
		}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public Vertex getSource() {
		return Source;
	}

	public void setSource(Vertex source) {
		Source = source;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
