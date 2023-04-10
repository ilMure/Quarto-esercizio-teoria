public class Risorsa {
    private int val = 0;
    private boolean disponibile = false;

    public synchronized int consuma() {
        while (!disponibile) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() +" ha consumato "+val);
        disponibile = false;
        notifyAll();
        return val;
    }

    public synchronized void produci(int val) {
        while (disponibile) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.val = val;
        disponibile = true;
        System.out.println(Thread.currentThread().getName() +" ha prodotto "+val);
        notifyAll();
    }
}
