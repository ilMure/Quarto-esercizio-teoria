public class Produttore extends Thread{
    private Risorsa r;
    private int val = 0;
    private boolean running = true;

    Produttore(String nome, Risorsa r) {
        super(nome);
        this.r = r;
    }

    public void arresta() {
        this.running = false;
        System.out.println("Thread " + super.getName() + " terminato"); // il Thread comunica la sua fine 
    }

    public void run() {
        while (running) {
            this.val = (int) ((Math.random()) * 100); // valore intero casuale che verrà prodotto
            r.produci(val);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        
    }
}
