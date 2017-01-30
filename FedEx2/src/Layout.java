
import java.util.ArrayList;
import java.util.Collections;

public class Layout {
	
	private int[][] prev_dest = new int[25][25];
	private int min = 99999, nextNode = 0; 
	
    @SuppressWarnings("rawtypes")
	ArrayList<ArrayList> shortestpath = new ArrayList<ArrayList>();
	public int[][] distance_mat = new int[25][25]; 
	
						//  0		1		2		3		4		5		6		7		8		9		10		11		12		13		14		15		16		17		18		19		20		21		22		23		24
	
	int[][] matrix = 	{ { 0,		1000,	0,		1044,	0,		0,		0,		0,		0,		0,		0,		1086,	0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0}, 
			/*1-*/	  	  { 1000,	0,		0,		1579,	1207,	993,	0,		919,	0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		840,	0}, 
			/*2*/		  { 0,		0,		0,		1738,	1029,	0,		0,		0,		0,		1179,	0,		911,	445,	0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0},
			/*3-*/		  { 940,	570,	1038,	0,		1150,	0,		0,		0,		0,		0,		0,		417,	0,		0,		0,		400,	0,		0,		0,		1111,	0,		0,		0,		0,		0},
			/*4*/		  { 0,		871,	1129,	850,	0,		1019,	0,		0,		0,		1275,	0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0},
			/*5*/		  { 0,		993,	0,		0,		1319,	0,		646,	985,	1021,	803,	1403,	0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0},
			/*6*/		  { 0,		0,		0,		0,		0,		1000,	0,		1089,	852,	0,		0,		0,		0,		300,	0,		0,		781,	906,	0,		0,		0,		0,		0,		0,		0},
			/*7*/		  { 0,		890,	0,		0,		0,		785,	789,	0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0},
			/*8*/		  { 0,		1030,	0,		0,		0,		928,	952,	0,		0,		973,	0,		0,		0,		0,		508,	673,	840,	0,		1111,	0,		840,	0,		0,		0,		0},
			/*9*/		  { 0,		0,		1179,	0,		1275,	1103,	0,		0,		1573,	0,		1165,	1107,	0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0},
			/*10*/		  { 0,		0,		0,		0,		0,		1003,	0,		0,		0,		565,	0,		0,		231,	804,	829,	0,		0,		0,		0,		0,		0,		0,		0,		0,		0},
			/*11*/		  { 1586,	0,		1111,	1917,	0,		0,		0,		0,		0,		1207,	0,		0,		260,	0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0},
			/*12*/		  { 0,		0,		945,	0,		0,		0,		0,		0,		0,		0,		231,	1260,	0,		1095,	0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0},
			/*13*/		  { 0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		504,	0,		995,	0,		1544,	1552,	0,		0,		697,	0,		0,		0,		0,		0,		0},
			/*14*/		  { 0,		0,		0,		0,		0,		0,		0,		0,		0,		1208,	1229,	0,		0,		444,	0,		947,	0,		0,		0,		0,		0,		0,		0,		0,		0},
			/*15*/		  { 0,		0,		0,		0,		0,		0,		0,		0,		1073,	0,		0,		0,		0,		952,	1047,	0,		500,	0,		559,	0,		0,		0,		0,		0,		0},
			/*16*/		  { 0,		0,		1111,		0,		0,		0,	1000,	0,		1040,	0,		0,		0,		0,		0,		0,		500,	0,		524,	668,	0,		892,	0,		0,		0,		0},
			/*17*/		  { 0,		0,		0,		0,		0,		0,		1006,	0,		0,		0,		0,		0,		0,		0,		0,		0,		1024,	0,		0,		0,		1026,	0,		0,		0,		0},
			/*18*/		  { 0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		597,	0,		1059,	1068,	0,		0,		1374,	573,	0,		0,		0,		1033},
			/*19*/		  { 0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		674,	0,		484,	0,		523,	534,	711},
			/*20*/		  { 0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		892,	1026,	573,	484,	0,		662,	931,	0,		0},
			/*21*/		  { 0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		362,	0,		632,	631,	0},
			/*22*/		  { 0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		523,	331,	1032,	0,		349,	0},
			/*23*/		  { 0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		534,	0,		1031,	949,	0,		623},
			/*24*/		  { 0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		0,		1455,	0,		0,		0,		0,		1033,	711,	0,		0,		0,		623,	0}
			}; 
	
	int[][] vistd = new int[25][25];

	@SuppressWarnings({ "rawtypes", "unchecked" })
		
	public Layout() {
			
		for(int a=0; a<25; a++){
			for(int b=0;b<25;b++){
				if(matrix[a][b]==0) matrix[a][b] = 99999; 
			}
		}
		
		for (int src = 0; src < 25; src++) {
			distance_mat[src] = matrix[src]; 
			vistd[src][0] = 1;
			distance_mat[src][src] = 0; 
									
			for (int counter = 0; counter < 25; counter++) {
				min = 99999;
				for (int i = 0; i < 25; i++) {
					if (min > distance_mat[src][i] && vistd[src][i] != 1) {
						min = distance_mat[src][i];
						nextNode = i;
					}
				}
				vistd[src][nextNode] = 1;
				for (int i = 0; i < 25; i++) {
					if (vistd[src][i] != 1) {
						if (min + matrix[nextNode][i] < distance_mat[src][i]) {
							distance_mat[src][i] = min + matrix[nextNode][i];
							prev_dest[src][i] = nextNode;
						}
					}
				}
			}
		}
		
		for(int a=0; a<25; a++){
			for(int b=0;b<25;b++){
				distance_mat[b][a]=distance_mat[a][b]; 
			}
		}
		
		for(int src=0;src<25;src++){
			int j;
			for (int i = 0; i < 25; i++) {
					j=i;
					ArrayList temp = new ArrayList();
					temp.clear();
					temp.add(i);
					while (j != 0) {
						j = prev_dest[src][j];
						if(j!=0) temp.add(j);
					} 
					temp.add(src);
					Collections.reverse(temp);
					shortestpath.add(temp);
			}
		}
	}
	
	public int time(int src, int dest){
		return matrix[src][dest];
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getShortestPath(int src, int dst){
		return shortestpath.get(src*25+dst);
	}
	
	
	public String cityName(int cid){
		switch(cid){
		case 0  : return "Raleigh, NC";
		case 1  : return "New York City, NY";
		case 2  : return "Pittsburgh, PA";
		case 3  : return "James Town, VA";
		case 4  : return "Boston, MA";
		case 5  : return "Charlotte, NC";
		case 6  : return "Atlanta, GA";
		case 7  : return "Orlando, FL";
		case 8  : return "Memphis, TN";
		case 9  : return "Grove City, OH";
		case 10 : return "Indianapolis, IN";
		case 11 : return "Auburn, MI";
		case 12 : return "New Berlin, WI";
		case 13 : return "Minneapolis, MN";
		case 14 : return "Miami, FL";
		case 15 : return "Arlignton, TX, ";
		case 16 : return "Dallas, TX";
		case 17 : return "Houston, TX";
		case 18 : return "Denver, CO";
		case 19 : return "Chicago IL";
		case 20 : return "Phoenix, AZ";
		case 21 : return "Los Angeles, CA";
		case 22 : return "Chino, CA";
		case 23 : return "Sacramento, CA";
		case 24 : return "Seattle, WA";
		default : return"City Error";
		}
	}

}