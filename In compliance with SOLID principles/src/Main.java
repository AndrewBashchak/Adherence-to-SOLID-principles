public class Main {
    public static void main(String[] args) {
        Dish pizza = new Dish("Pizza", 4.0);
        Dish burger = new Dish("Burger", 3.0);
        Dish cocacola = new Dish("Coca-cola", 0.5);

        CafeOrder order = new CafeOrder();

        order.addItem(new OrderItem(burger, 2, new NoDiscount()));
        order.addItem(new OrderItem(pizza, 1, new HolidayDiscount()));
        order.addItem(new OrderItem(cocacola, 3, new BulkDiscount()));

        order.generateReceipt();
    }
}