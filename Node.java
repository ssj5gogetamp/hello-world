package feedingSchedule;

public class Node {

	private String heroName;
	private int nemesis;
	private double travelTime;
	private double arrivalTime;
	private Node prev;
	private Node next;

	// Default Constructor
	public Node() {
		heroName = "";
		nemesis = 0;
		travelTime = 0;
		arrivalTime = 0;
	}

	// 3 parameter constructor 
	public Node(String heroName, int nemesis, double travelTime) {
		this.heroName = heroName;
		this.travelTime = travelTime;
		this.nemesis = nemesis;
		this.arrivalTime = 0;
	}

	// 5 field constructor
	public Node(String heroName, int nemesis, double travelTime, Node next, Node prev) {
		this.heroName = heroName;
		this.nemesis = nemesis;
		this.travelTime = travelTime;
		this.next = next;
		this.prev = prev;
		this.arrivalTime = 0;
	}
	public Node(Node node){
		this.heroName = node.getName();
		this.nemesis = node.getNemesis();
		this.travelTime = node.getTravelTime();
		this.next = node.getNext();
		this.prev = node.getPrev();
		this.arrivalTime = node.arrivalTime;
	}


	public String getName() {
		return this.heroName;
	}

	public int getNemesis() {
		return this.nemesis;
	}

	public double getTravelTime() {
		return this.travelTime;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = (next);
	}

	public Node getPrev() {
		return this.prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public String info(){
		return this.heroName +" "+ this.nemesis +" "+ this.travelTime;
	}
	public void setArrivalTime(double arrivalTime){
		this.arrivalTime = arrivalTime;
	}
	public double getArrivalTime(){
		return this.arrivalTime;
	}
}
