package coffeeShop;

interface Coffee{
    public String getDescription();
    public double getCost();
}

class SimpleCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Simple coffeeShop.Coffee";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
}

abstract class CoffeeDecorator implements Coffee{
    private final Coffee decoratedCoffee;
    public CoffeeDecorator(Coffee decoratedCoffee){
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee decoratedCoffee){
        super(decoratedCoffee);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " ,Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}

class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee decoratedCoffee){
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " ,Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.0;
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        // Start with the base component
        Coffee myCoffee = new SimpleCoffee();
        System.out.println(myCoffee.getDescription() + " cost: $" + myCoffee.getCost());
        // Output: Simple coffeeShop.Coffee cost: $5.0

        // Wrap the coffee in a coffeeShop.MilkDecorator
        myCoffee = new MilkDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " cost: $" + myCoffee.getCost());
        // Output: Simple coffeeShop.Coffee, Milk cost: $7.0

        // Now, wrap the already-decorated coffee in a coffeeShop.SugarDecorator
        myCoffee = new SugarDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " cost: $" + myCoffee.getCost());
        // Output: Simple coffeeShop.Coffee, Milk, Sugar cost: $7.5
    }
}