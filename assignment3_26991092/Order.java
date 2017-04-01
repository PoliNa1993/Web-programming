//----------------------------------------------------------
// Assignment 3
// Written by: Polina Anis'kina 26991092
// For COMP249 Section: S
//----------------------------------------------------------
public class Order implements Comparable <Order>, anonymous {
	private String id;
	private double price;
	private int volume;

	//constructors
	public Order(){
		this.id="";
		this.price=0.0;
		this.volume=0;
	}

	public Order(String id, double price, int volume) {
		this.id = id;
		this.price = price;
		this.volume = volume;

	}
	//setters and getters

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	//to string method
	public String toString() {
		return "Order (Unknown): " + price + " " + volume;
	}
	//printing all the details
	public String printFullDetails(){
		return ("Order (Unknown): "+ price + " " + volume + ", by "+ id);
	}

	//compare to method
	public int compareTo(Order o) {
		Double price = new Double(this.price);
		Double passingPrice = new Double(o.getPrice());
		return (price.compareTo(passingPrice));
	}


}
