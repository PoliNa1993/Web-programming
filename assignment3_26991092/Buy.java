
public class Buy extends Order{

	public Buy(){
		super();
	}
	public Buy(String id, double price, int volume){
		super(id,price,volume);
	}	
	//toString method
	public String toString() {
		return "Bid: "+ super.getPrice() +" "+ super.getVolume();
	}

	//printing all the details
	public String printFullDetails(){
		return ("Bid: "+ super.getPrice() + " " + super.getVolume() + ", by "+ super.getId());
	}


}
