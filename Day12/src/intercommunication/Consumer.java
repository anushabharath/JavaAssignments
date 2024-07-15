package intercommunication;

class Consumer extends Thread {
    private Share share;

    public Consumer(Share share) {
        this.share = share;
    }

    public void run() {
        for (int i = 0; i <= 6; i++) {
            System.out.println("Consumed " + share.reteive());
        }
    }


}
