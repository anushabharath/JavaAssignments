package bdp;

public class Strategy {
    public static void main(String args[]) {
        Shopping bag = new Shopping();
        Product p1 = new Product("1111", 200.00);
        Product p2 = new Product("2222", 400.00);
        bag.addProduct(p1);
        bag.addProduct(p2);
        bag.pay(new CashOnDelivery("Delhi"));
        System.out.println(" ");
        bag.pay(new CreditCard(12345, "Rani"));
    }
}