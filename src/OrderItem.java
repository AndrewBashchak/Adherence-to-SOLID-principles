public class OrderItem {
    private final Dish dish;
    private final int quantity;
    private final DiscountStrategy discount;

    public OrderItem(Dish dish, int quantity, DiscountStrategy discount) {
        this.dish = dish;
        this.quantity = quantity;
        this.discount = discount;
    }

    public double calculateTotal() {
        double basePrice = dish.getPrice() * quantity;
        return basePrice - discount.applyDiscount(basePrice, quantity);
    }

    public void printInfo() {
        double base = dish.getPrice() * quantity;
        double disc = discount.applyDiscount(base, quantity);
        System.out.printf("- %-10s x%d | Basic: $%.2f | Discount: $%.2f (%-14s) | Total: $%.2f\n",
                dish.getName(), quantity, base, disc, discount.getDiscountName(), calculateTotal());
    }
}