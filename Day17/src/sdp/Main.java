package sdp;

public class Main {
    public static void main(String[] args) {
        SocketAdapter socketAdapter = new SocketImplAdapter();

        Volt v120 = socketAdapter.get120Volt();
        Volt v12 = socketAdapter.get12Volt();
        Volt v3 = socketAdapter.get3Volt();

        System.out.println("v120 volts using Socket Adapter: " + v120.getVolts());
        System.out.println("v12 volts using Socket Adapter: " + v12.getVolts());
        System.out.println("v3 volts using Socket Adapter: " + v3.getVolts());
    }
}
