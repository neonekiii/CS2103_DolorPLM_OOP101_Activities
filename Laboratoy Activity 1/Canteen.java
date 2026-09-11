import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menu items and prices
        String[] pangulam = {
            "Cordon bleu",
            "Fried chicken",
            "Fish fillet",
            "Adobo",
            "Barbecue ribs"
        };

        double[] prices = {
            45.00,
            30.00,
            40.00,
            35.00,
            60.00
        };

        // Order loop
        boolean orderAgain = true;

        // Variables for all orders
        int totalOrders = 0;
        double grandTotal = 0.00;
        double totalDiscount = 0.00;
        double finalTotal = 0.00;

        while (orderAgain) {

            // Display menu
            System.out.println("=== Welcome to the Canteen! ===");
            System.out.println("Menu of the day with free unli rice included:");

            for (int i = 0; i < pangulam.length; i++) {
                System.out.printf("%d. %s - $%.2f%n",
                        (i + 1), pangulam[i], prices[i]);
            }

            // Select order
            System.out.print("Select your order (1-5): ");
            int order = input.nextInt();

            if (order < 1 || order > pangulam.length) {
                System.out.println("Invalid selection. Please select a number between 1 and "
                        + pangulam.length + ".");
                continue;
            }

            // Enter quantity
            System.out.print("Enter the quantity of your order: ");
            int quantity = input.nextInt();

            // Check if quantity is valid
            if (quantity <= 0) {
                System.out.println("Invalid quantity. Please try again.");
                continue;
            }

            // Check if quantity is more than 10
            if (quantity > 10) {
                System.out.println(
                        "Sorry, we can only accept a maximum of 10 orders at a time."
                );
                continue;
            }

            // Calculate total for current order
            double totalAmount = prices[order - 1] * quantity;

            // Student question
            System.out.print("Are you a student (Y/N)? ");
            char studentChoice = input.next().charAt(0);

            boolean isStudent =
                    studentChoice == 'Y' || studentChoice == 'y';

            // Apply discount
            double discountRate;

            if (isStudent && totalAmount >= 500) {
                discountRate = 0.15;
            } else if (isStudent) {
                discountRate = 0.10;
            } else if (totalAmount >= 500) {
                discountRate = 0.05;
            } else {
                discountRate = 0.00;
            }

            double discountAmount = totalAmount * discountRate;
            double finalAmount = totalAmount - discountAmount;

            // Add current order to the overall totals
            totalOrders += quantity;
            grandTotal += totalAmount;
            totalDiscount += discountAmount;
            finalTotal += finalAmount;

            // Current purchase summary
            System.out.println("\n=== Purchase Summary ===");
            System.out.println("Order: " + pangulam[order - 1]
                    + " - Unli Rice Combo");
            System.out.printf("Price per item: $%.2f%n", prices[order - 1]);
            System.out.println("Total quantity: " + quantity);
            System.out.printf("Total amount: $%.2f%n", totalAmount);
            System.out.printf("Discount applied: $%.2f%n", discountAmount);
            System.out.printf("Final amount to pay: $%.2f%n", finalAmount);

            // Order again
            System.out.print("\nDo you want to order again? (Y/N): ");
            char again = input.next().charAt(0);

            if (again == 'Y' || again == 'y') {
                System.out.println();
            } else {
                orderAgain = false;

                // Final order summary
                System.out.println("\n=== Final Order Summary ===");
                System.out.println("Total items ordered: " + totalOrders);
                System.out.printf("Total amount before discount: $%.2f%n", grandTotal);
                System.out.printf("Total discount applied: $%.2f%n", totalDiscount);
                System.out.printf("Final amount to pay: $%.2f%n", finalTotal);
            }
        }

        // Closing message
        System.out.println("\nThank you for your order! Have a great day!");

        input.close();
    }
}