
public class Sell extends Order {
	public Sell(){
		super();
	}
	public Sell(String id, double price, int volume){
		super(id,price,volume);
	}
	//toString method
	public String toString() {
		return "Off: "+ super.getPrice() +" "+ super.getVolume();
	}

	//printing all the details
	public String printFullDetails(){
		return ("Off: "+ super.getPrice() + " " + super.getVolume() + ", by "+ super.getId());
	}


}
