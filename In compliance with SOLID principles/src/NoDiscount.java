public class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double price, int quantity) {
        return 0;
    }

    public String getDiscountName() {
        return "None";
    }
}