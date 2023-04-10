public class Es4{
    public static void main(String[] args) {
        Risorsa r = new Risorsa();
        Produttore p1 = new Produttore("Prod1", r);
        Consumatore c1 = new Consumatore("  Cons1", r);
        Produttore p2 = new Produttore("Prod2", r);
        Consumatore c2 = new Consumatore("  Cons2", r);
        Consumatore c3 = new Consumatore("  Cons3", r);

        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        p1.arresta();
        p2.arresta();
        c1.arresta();
        c2.arresta();
        c3.arresta();

        System.out.println("Thread MAIN FINE");
    }
}