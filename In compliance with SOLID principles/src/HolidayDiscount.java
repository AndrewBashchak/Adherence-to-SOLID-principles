public class HolidayDiscount implements DiscountStrategy {
    public double applyDiscount(double price, int quantity) {
        return price * 0.1;
    }

    public String getDiscountName() {
        return "HOLIDAY (-10%)";
    }
}