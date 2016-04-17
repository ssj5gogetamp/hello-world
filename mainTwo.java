/**
 * 
 */
package feedingSchedule;

/**
 * @author Michael
 *
 */
import java.io.*;
import java.util.Scanner;
public class mainTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		String filename = "HeroInformation";
		Scanner sc = new Scanner(System.in);
		
		File filereader = new File(filename);
		
		if (!filereader.exists()) {
			System.out.println("The file doesn't exist");
			System.exit(0);
		}
		Scanner inputFile = new Scanner(filereader);
		// Created FileReader 
			
		NodeList list1 = new NodeList();
		int numOfSharks = inputFile.nextInt(); // Read in Shark Value
		// Create a list, and read in Sharks 
		
		// Initialize Hunger, nemesis, nemCap, time, and arrivals
		int hunger = 0; 
		boolean nemCap = false;
		//boolean nemDead = false;
		int time = 0;
		int arrivals = 0;
		int nemesis = 0;
		
		Node tempHero = makeHero(inputFile); // Make (time = zero) hero
		
		// Time Zero Conditions 
		System.out.println(time+": "+tempHero.getName()+" has been captured.");
		list1.enqueue(tempHero);
		System.out.println(time+": "+tempHero.getName()+" has been fed to the sharks.");
		list1.dequeue();
		
		tempHero = makeHero(inputFile); // Make 2nd Hero 
		
		while (time <= 60){ // Start Time 
		
		while (inputFile.hasNext()){
					
		if (hunger >= 8/numOfSharks && list1.getSize() > 0){ // hungry check
			
			if (list1.peek().getNemesis() == 1 && arrivals <2){
				
			}
			else {
			if (nemCap == false){
			String msg = time+": "+list1.dequeue().getName()+" has been fed to the sharks.";
			System.out.println(msg);
			
			}
			
			else if (nemCap == true){
			String msg = time+": "+ list1.pop().getName()+" has been fed to the sharks.";
			System.out.println(msg);
			
			}
			
			hunger = hunger - 8/numOfSharks;
			} // Monologue Check 
		}	// end Hunger Check 
		
		if (arrivals == tempHero.getTravelTime()){ // ARRIVAL 
			
			if (nemCap == false && arrivals != 0){ // Queue Hero 
			
			System.out.println(time+": "+tempHero.getName()+" has been captured.");
			list1.enqueue(tempHero);
		
			if (nemesis == 1){
				nemCap = true;
			}
			else{
				nemCap = false;
			}

			tempHero = makeHero(inputFile);
			
			arrivals = 0;
			} // end Queue Hero 
			
			if (nemCap == true && arrivals != 0){ // Push Hero 

			System.out.println(time+": "+tempHero.getName()+" has been captured.");
			list1.push(tempHero);

			if (nemesis == 1){
				nemCap = true;
			}
			else{
				nemCap = false;
			}

			tempHero = makeHero(inputFile);
			
			arrivals = 0;
			} // end Push Hero 
		} // Hero has Arrived 
			
		hunger++;time++;arrivals++;
		} // end while  (Has Next Condition)

		if (hunger >= 8/numOfSharks && list1.getSize() > 0){ // hungry check
			
			if (nemCap == false){
			String msg = time+": "+list1.dequeue().getName()+" has been fed to the sharks.";
			System.out.println(msg);
			}
			
			else if (nemCap == true){
			String msg = time+": "+ list1.pop().getName()+" has been fed to the sharks.";
			System.out.println(msg);
			}
			
			hunger = hunger - 8/numOfSharks;
		}
	
	hunger++;
	time++;
	} // end time loop 
	} // end main 
	public static Node makeHero(Scanner inputFile){ // Returns a Made Hero 
		String name = inputFile.next();
		int nemesis = inputFile.nextInt();
		double travelTime = inputFile.nextDouble();
		Node tempHero;
		return tempHero = new Node(name,nemesis, travelTime);
	} // end Hero making helper method 

} // end class 