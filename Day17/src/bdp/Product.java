package bdp;

public class Product {
	
	private String pCode;
	private double pPrice;
	
	public Product(String pCode, double pPrice) {
		this.pCode = pCode;
		this.pPrice = pPrice;
	}
	
	public String getpCode() {
		return pCode;
	}
	
	public double getpPrice(){
		return pPrice;
	}
}
