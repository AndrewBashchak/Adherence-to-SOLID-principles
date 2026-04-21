public interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
    String getDiscountName();
}
