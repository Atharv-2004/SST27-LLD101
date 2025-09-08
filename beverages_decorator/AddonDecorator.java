package beverages_decorator;

public abstract class AddonDecorator extends Beverage {
    protected final Beverage beverage;

    protected AddonDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}


