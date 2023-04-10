public class Consumatore extends Thread{
    private Risorsa r;
    private int val = 0;
    private boolean running = true;

    Consumatore(String nome, Risorsa r) {
        super(nome);
        this.r = r;
    }

    public void arresta() {
        this.running = false;
        System.out.println("Thread " + super.getName() + " terminato"); // il Thread comunica la sua fine 
    }

    public void run() {
        while (running) {
            this.val = r.consuma();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        
    }
}
