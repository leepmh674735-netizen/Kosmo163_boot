public class CoffeeWaker {
    private EsperssoMachine espressoMachine;
}
 public CoffeeMarker () {
    this.espressoMachine = new EspressoMachine();
 }
 
  public void makeCoffee() {
    System.out.println(espressMachine.brew());
   }
 }