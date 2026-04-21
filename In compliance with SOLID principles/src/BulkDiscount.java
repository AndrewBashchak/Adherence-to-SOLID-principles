public class BulkDiscount implements DiscountStrategy {
    public double applyDiscount(double price, int quantity) {
        return (quantity >= 3) ? (price * 0.2) : 0;
    }

    public String getDiscountName() {
        return "BULK (-20%)";
    }
}