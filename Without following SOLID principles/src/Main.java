import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CafeOrder system = new CafeOrder();

        system.addDish("Coca-Cola", 3, "Bulk");
        system.addDish("Pizza", 1, "Holiday");
        system.addDish("Burger", 2, "None");

        system.generateReceipt();
    }
}

class CafeOrder {
    class OrderItem {
        String name;
        int quantity;
        double price;
        String discountType;

        OrderItem(String name, int quantity, double price, String discountType) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.discountType = discountType;
        }
    }

    private List<OrderItem> items = new ArrayList<>();

    public void addDish(String dishName, int quantity, String discountType) {
        double pricePerUnit = 0;

        if (dishName.equalsIgnoreCase("Pizza")) {
            pricePerUnit = 4.0;
        } else if (dishName.equalsIgnoreCase("Burger")) {
            pricePerUnit = 3.0;
        } else if (dishName.equalsIgnoreCase("Coca-Cola")) {
            pricePerUnit = 0.5;
        }

        if (pricePerUnit > 0) {
            items.add(new OrderItem(dishName, quantity, pricePerUnit, discountType));
        } else {
            System.out.println("Error: Dish '" + dishName + "' isn't on the menu.");
        }
    }

    public void generateReceipt() {
        double grandTotal = 0;

        System.out.println("\n========== YOUR TOTAL CHECK ==========");

        for (OrderItem item : items) {
            double itemTotal = item.price * item.quantity;
            double discountAmount = 0;

            if (item.discountType.equals("Holiday")) {
                discountAmount = itemTotal * 0.1;
            } else if (item.discountType.equals("Bulk") && item.quantity >= 3) {
                discountAmount = itemTotal * 0.2;
            }

            double finalItemPrice = itemTotal - discountAmount;
            grandTotal += finalItemPrice;

            System.out.printf("- %-10s x%d | Basic: $%.2f | Discount: $%.2f | Total: $%.2f\n",
                    item.name, item.quantity, itemTotal, discountAmount, finalItemPrice);
        }

        System.out.println("---------------------------------------");
        System.out.printf("TOTAL PAYMENT: $%.2f\n", grandTotal);
        System.out.println("=======================================");
    }
}
