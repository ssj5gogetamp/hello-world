package feedingSchedule;
import java.io.*;
import java.util.Scanner;

public class Main {
	int numOfSharks = 0;
	public static void main(String[] args)throws IOException {
		// We are Batman
		
		NodeList list1 = new NodeList();
		String filename = "HeroInformation";
		Scanner sc = new Scanner(System.in);
		Node[] feedOrder = new Node[8];
		int arrayIndex = 0;
		
		File filereader = new File(filename);
		
		if (!filereader.exists()) {
			System.out.println("The file doesn't exist");
			System.exit(0);
		}
		
		Scanner inputFile = new Scanner(filereader);
		int nemesisCaptureCheck = 0;
		double monologueOverCheck = 0;
		int sharksReadCheck =0;
		int numOfSharks = 0;
		double time = 0;
		
		while (inputFile.hasNext()) { // Read in the Heros 
					
			if (sharksReadCheck == 0){ // Read number of sharks 
			numOfSharks = inputFile.nextInt();
			sharksReadCheck++;
			} // end read number of sharks 
			
			// stacking 
			if (nemesisCaptureCheck == -1){
				String name1 = inputFile.next();
				int nemesis1 = inputFile.nextInt();
				double travelTime1 = inputFile.nextDouble();
				Node tempHero = new Node(name1,nemesis1,travelTime1);
				list1.push(tempHero);
				time = time + travelTime1; // increment time 
				tempHero.setArrivalTime(time);
				feedOrder[arrayIndex] = tempHero;
				arrayIndex++;
				
				monologueOverCheck = monologueOverCheck + travelTime1;
				if (monologueOverCheck >= 1){
					nemesisCaptureCheck = 0;
				} // end monologue over check
			} // end stacking condition 
			
			// Queueing 
			if (nemesisCaptureCheck == 0){
			String name1 = inputFile.next();
			int nemesis1 = inputFile.nextInt();
			double travelTime1 = inputFile.nextDouble();
			Node tempHero = new Node(name1,nemesis1,travelTime1);
			list1.enqueue(tempHero);
			time = time + travelTime1; // increment time
			tempHero.setArrivalTime(time);
			feedOrder[arrayIndex] = tempHero;
			arrayIndex++;
				if (nemesis1 == 1){
					nemesisCaptureCheck = -1;
				} // end nemesis capture check 
			} // End queueing condition		
		} // end File Has Next	
		

		System.out.println("Time Simulation starts here\n\n");
		int i = 0; // check arrival times
		int j = 0; // who's to be fed next 
		double realTime = 0;
		while (realTime < 30.00){ // Time simulation condition 
			i = 0;
			while (i < 7){
			double nextArrival = feedOrder[i].getArrivalTime();
			if (nextArrival == realTime)
			System.out.println(nextArrival+": "+feedOrder[i].getName()+" has been captured.");	
			i++; // check all arrival times
			} // end check for arrival
			
			if (realTime%(8/numOfSharks) == 0 && j<7){ // Shark Feeder
				if (realTime < feedOrder[j].getArrivalTime() ){
					System.out.println(feedOrder[j].getArrivalTime()+": "+feedOrder[j].getName()+" has been fed to the sharks.");
					j++;
				}
				else{
				System.out.println(realTime+": "+feedOrder[j].getName()+" has been fed to the sharks.");
				j++; // who's to be fed next
				}
			} // end shark feeder 			
			realTime = realTime + 1; // Time increment 
		} // end time simulator 			
	
	} // end Main
} // end Class definition 
	
