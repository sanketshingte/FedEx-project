
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Iterator;
//import java.util.ListIterator;

public class QueryThread implements Runnable {
	
	double ID=0;
	Track curr_packet;
	static String s= "";
	public static ArrayList<Track> packet_info1 = new ArrayList<Track>();
	public void run(){
		TrackPackage pt = new TrackPackage();
		packet_info1 = pt.getList();
		Iterator<Track> it = packet_info1.iterator();
		double usrid = pt.getID();
		while(it.hasNext()){	
			if(ID == usrid)
				break;
			curr_packet=it.next();
			ID = curr_packet.id1;
		}
		ID=0;
		PacketDetails(curr_packet);
	}
	
	public void PacketDetails(Track curr_packet1){
		
		Layout city1 = new Layout();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("                       FedEx Tracking History                             ");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Tracking ID:"+curr_packet1.id1);
		System.out.println("Source City:"+city1.cityName(curr_packet1.source));
		System.out.println("Destination City:"+city1.cityName(curr_packet1.destination));

		for(int i=0; i<curr_packet1.current_City.size(); i++){
			
			System.out.println("Location:"+city1.cityName(curr_packet1.current_City.get(i))+" Arrived at"+curr_packet1.current_time.get(i)+"");
				
		}
		System.out.println("--------------------------------------------------------------------------\n");
		//System.out.println("                       FedEx Tracking History                             ");
		//System.out.println("--------------------------------------------------------------------------");
	}
	
}
