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
        System.out.println(Thread.currentThread().getName() +" ha consumato "+val); // valore consumato dal Thread "consumatore" (current, che sta accedendo alla risorsa)
        disponibile = false;
        notifyAll(); //notifica tutti i produttori
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
        System.out.println(Thread.currentThread().getName() +" ha prodotto "+val); // valore prodotto dal Thread "produttore" (current)
        notifyAll(); //notifica tutti i consumatori 
    }
}
