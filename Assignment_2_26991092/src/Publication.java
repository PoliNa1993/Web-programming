//------------------------------------------------------
//Assignment 2
//Questions: Part 1
//Written by: Polina Anis'kina ID:26991092
//For Comp249 Section: S
//------------------------------------------------------

public class Publication {	

	private long publication_code;
	private  String publication_name;
	private int publication_year;
	private String publication_authorname;
	private  double publication_cost;
	private int publication_nbpages;
	//default constructor
	public Publication(){
		this.publication_code=0;
		this.publication_name="";
		this.publication_year=0;
		this.publication_authorname="";
		this.publication_cost=0.0;
		this.publication_nbpages=0;	
	}
	//constructor
	public Publication(long pc, String pn,int py,String pa, double pco, int pnb){
		this.publication_code=pc;
		this.publication_name=pn;
		this.publication_year=py;
		this.publication_authorname=pa;
		this.publication_cost=pco;
		this.publication_nbpages=pnb;	
	}
	//Set and get methods
	public long getPublication_code() {
		return publication_code;
	}
	public void setPublication_code(long publication_code) {
		this.publication_code = publication_code;
	}
	public String getPublication_name() {
		return publication_name;
	}
	public void setPublication_name(String publication_name) {
		this.publication_name = publication_name;
	}
	public int getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(int publication_year) {
		this.publication_year = publication_year;
	}
	public String getPublication_authorname() {
		return publication_authorname;
	}
	public void setPublication_authorname(String publication_authorname) {
		this.publication_authorname = publication_authorname;
	}
	public double getPublication_cost() {
		return publication_cost;
	}
	public void setPublication_cost(double publication_cost) {
		this.publication_cost = publication_cost;
	}
	public int getPublication_nbpages() {
		return publication_nbpages;
	}
	public void setPublication_nbpages(int publication_nbpages) {
		this.publication_nbpages = publication_nbpages;
	}
	//to string method
	public String toString() {
		return (publication_code + "," + publication_name
				+ "," + publication_year + "," + publication_authorname
				+ "," + publication_cost + "," + publication_nbpages );
	}
}
