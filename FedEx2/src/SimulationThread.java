import java.util.ArrayList;
import java.util.Iterator;


public class SimulationThread implements Runnable {

		// TODO Auto-generated method stub
		public static ArrayList<Track> packet_info1 = new ArrayList<Track>();
		public void run() {
			while(true){
			// TODO Auto-generated method stub
				TrackPackage pt = new TrackPackage();
				packet_info1 = pt.getList();
				Iterator<Track> it = packet_info1.iterator();
				Track temp;
			
				while(it.hasNext()){
					temp = it.next();
					temp.TimeStamp(1);
				}
				try {
					Thread.sleep(4000);
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
		}

}
