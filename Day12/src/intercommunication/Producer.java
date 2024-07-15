package intercommunication;

class Producer extends Thread {
    private Share share;

    public Producer(Share share) {
        this.share = share;
    }

    public void run() {
        for (int i = 0; i <= 6; i++) {
            share.add(i);
            System.out.println("Produced " + i);
        }
    }
}