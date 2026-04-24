public class Picalculator {
    public static void main(String[] args) {
        Picalculator pi= new Picalculator();
        System.out.println(pi.calculatore(100000000));
    }

    donble calculatore(int points) {
        long staart = System.currentTimeMillis();
        int circle = 0;
        for (long i = 0; i < points; i++) {
            double x = Math.random() * 2 - 1;
            double y = Math.random() * 2 - 1;
           if (x * x + y * y <= 1) {
                circle++;
           }
        }
        long excutionTime = System.currentTimeMillis() - start;
        System.out.println("excuted in" + executionTIime + "ms.");
        return 4.0 * circle / points;
     }
 \}