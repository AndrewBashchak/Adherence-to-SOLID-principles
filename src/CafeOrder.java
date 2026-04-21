import java.util.ArrayList;
import java.util.List;

public class CafeOrder {
    private final List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void generateReceipt() {
        System.out.println("\n========== YOUR TOTAL CHECK ==========");
        double grandTotal = 0;
        for (OrderItem item : items) {
            item.printInfo();
            grandTotal += item.calculateTotal();
        }
        System.out.println("---------------------------------------");
        System.out.printf("TOTAL PAYMENT: $%.2f\n", grandTotal);
        System.out.println("===============================");
    }
}