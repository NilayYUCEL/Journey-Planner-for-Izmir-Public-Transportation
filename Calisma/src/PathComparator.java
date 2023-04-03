import java.util.Comparator;
import java.util.Map.Entry;

@SuppressWarnings("rawtypes")
public class PathComparator implements Comparator<String> {

	//Order for Priority queue 
	@Override
	public int compare(String a, String b) {
		// TODO Auto-generated method stub
		String[] distance1= new String[2];
		String[] distance2= new String[2];
		distance1=a.split("-");
		distance2=b.split("-");
		
		if (Integer.valueOf(distance1[1]) < Integer.valueOf(distance2[1])) {
            return -1;
        }
		else if(Integer.valueOf(distance1[1]) > Integer.valueOf(distance2[1])) {
            return 1;
        }
        
		return 0;
	}

}
