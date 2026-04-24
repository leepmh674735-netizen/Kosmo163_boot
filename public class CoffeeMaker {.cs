public class CoffeeMaker {
    private DripCoffeeMachine dripCoffeeMappine;
}
public CoffeeMaker {
    this.dripCoffeeMachine = new DripCoffeeMachine();
}

public void makeCoffee() {
    System.out.println(dripCoffeeMachine.brew());
  }
}
