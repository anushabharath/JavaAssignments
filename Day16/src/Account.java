
public class Account {
	
	private double balanceAmount;
	
	public Account (double balanceAmount)
	{
		this.balanceAmount = balanceAmount;
	}
	
	public double getBalanceAmount() {
		return balanceAmount;
	}
	
	public void deposit(double amount) {
		balanceAmount = balanceAmount + amount;
	}
	
	public void withDraw(double amount) {
		balanceAmount = balanceAmount - amount;
	}
}
