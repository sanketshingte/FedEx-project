import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class TrackPackage {
	static ArrayList<Track> packet_info = new ArrayList<Track>();
	static double entered_id=1;
	
	public ArrayList<Track> getList() {
	    return packet_info;
	}
	
	public double getID() {
	    return this.entered_id;
	}
	 public static ArrayList<Double> packet_id1 = new ArrayList<Double>();
	 public static ArrayList<Integer> src1 = new ArrayList<Integer>();
	 public static ArrayList<Integer> dest1 = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Database db = new Database();
		db.dbconn();
		packet_id1 = db.packet_id;
		src1 = db.src;
		dest1 = db.dest;
		
		ListIterator<Double> id_loop = packet_id1.listIterator();
		ListIterator<Integer> src_loop = src1.listIterator();
		ListIterator<Integer> dest_loop = dest1.listIterator();
		
		while(id_loop.hasNext()){
			Track P= new Track(id_loop.next(),src_loop.next(),dest_loop.next()); // packet id, source and destination values are given to constructor
			packet_info.add(P);
			P.Package();
		}
		/*Track P1= new Track(1,0,24);
		Track P2= new Track(2,5,24);
		Track P3= new Track(3,0,15);
		Track P4= new Track(4,2,17);
		
		packet_info.add(P1);
		packet_info.add(P2);
		packet_info.add(P3);
		packet_info.add(P4);
		
		P1.Package();
		P2.Package();
		P3.Package();
		P4.Package();*/ // the above commented operations were checked for the single packet 
		
		Scanner read = new Scanner(System.in);
		Runnable r1 = new SimulationThread();
		Thread t1 = new Thread(r1);
		Runnable r2 = new QueryThread();
		Thread t2 = new Thread(r2);
		double a =0;
		t1.start();

		while(true){
			if(a>=0){
				
				System.out.println("\nEnter the ID of Packet:");
				a= read.nextInt();
				if(a>100000){
					System.out.println("Enter valid no.");
					continue;
				}
				entered_id = a;
				
				t2.run();
				
			}
		}
		
		
	
	}// end of main

}// end of TrackPackage
