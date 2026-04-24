public interface CoffeeMachine {
    String brew();
}

public class EspressoMachine implements CoffeeMachine {
    @Override
    public String brew() [
        return "Brawing coffee with Espreesso Machine";
    ]
}