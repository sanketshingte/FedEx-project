import java.util.Date;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ListIterator;


public class Track {

	double id1;
	int source,destination,sum=0;
	int SPEED = 115;
	ArrayList<String> current_time = new ArrayList<String>();
	int[] time = null;
	ArrayList<Integer> path = new ArrayList<Integer>();
	ArrayList<Integer> time_req = new ArrayList<Integer>();
	ArrayList<Integer> current_City = new ArrayList<Integer>();

	public Track(double id, int src, int dest) {
		this.id1 = id;
		this.source =src;
		this.destination = dest;
		//this.current_City.add(src);
	}

	public double getID(){
		return this.id1;
	}
	@SuppressWarnings("unchecked")
	
	public void Package(){
		
		Layout city = new Layout();
		path = city.getShortestPath(this.source, this.destination);
		
		int[] ints = new int[path.size()];
		int[] dist = new int[ints.length - 1];
		time = new int[35];
		
		for(int i=0, len = path.size(); i < len; i++)
		   ints[i] = path.get(i);
		
		for(int i=0, len = path.size(); i < len-1; i++){
			dist[i]= city.time(ints[i], ints[i+1]);	
		}
		
		for(int i=0, len = path.size(); i < len-1; i++){
			sum = sum +(dist[i]/SPEED);
			time [i]= sum;
			time_req.add(time[i]);
			//System.out.println(time[i]);			
		}
	
	}// end of Package()
	
	public void TimeStamp(int glob_time){
		int j =0;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		current_City.clear();
		//int temp = glob_time -1;
		//current_time.clear();
		for(int i = j; i<=time_req.size(); i++){
			
			//int packet_time;
			time[i] = time[i]- glob_time;
			//	current_time.add(dateFormat1.format(date));
			//String packet_time = Integer.toString(time[i]);
			if(time[j]<=0){
				//current_City = path.get(i);
				current_City.add(path.get(i));
				current_time.add(dateFormat1.format(date));
				
				j = i;
			}
			
		}

	}//end of TimeStamp()

}// end of Track


