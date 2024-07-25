package bdp;

import java.util.ArrayList;
import java.util.List;

interface PaymentGateway {
    public void payment(double amt);
}

class CreditCard implements PaymentGateway {
    private int cardNo;
    private String name;

    public CreditCard(int cardNo, String name) {
        this.cardNo = cardNo;
        this.name = name;
    }

    public void payment(double amt) {
        System.out.println("Payment done by Credit Card " + amt);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNo=" + cardNo +
                ", name='" + name + '\'' +
                '}';
    }
}



class Shopping {
    private List<Product> l1;

    public Shopping() {
        this.l1 = new ArrayList<>();
    }

    public void addProduct(Product p) {
        l1.add(p);
    }

    public void removeProduct(Product p) {
        l1.remove(p);
    }

    public double calculatePrice() {
        return l1.stream().mapToDouble(Product::getpPrice).sum();
    }

    public void pay(PaymentGateway paymentMethod) {
        double price = calculatePrice();
        System.out.print(paymentMethod + " ");
        paymentMethod.payment(price);
    }
}

