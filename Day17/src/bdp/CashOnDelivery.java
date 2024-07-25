package bdp;

class CashOnDelivery implements PaymentGateway
{
   private String address;

   public CashOnDelivery(String address) {
       this.address = address;
   }
   public void payment(double amt)
   {
       System.out.println("Payment through Cash On Delivery "+ amt);
   }

   @Override
   public String toString() {
       return "CashOnDelivery{" +
               "address='" + address + '\'' +
               '}';
   }
}
