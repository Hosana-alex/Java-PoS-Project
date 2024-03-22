import java.util.Scanner;

class ui{
    

    private Menu menu;
    private Scanner scanner;
    private order order;

    public ui() {
        this.menu = new Menu();
        this.scanner = new Scanner(System.in);
        this.order = new order();
    }

    public void displayMenu() {
        System.out.println("Here is our menu:");
        System.out.println("1. Beverages");
        System.out.println("2. Pastries and Bakery Items");
        System.out.println("3. Sandwiches and Wraps");
        System.out.println("4. Breakfast Items");
        System.out.println("5. Salads and Healthy Options");
        System.out.println("6. View Order");
        System.out.println("7. Exit");
        System.out.println();
    }


    public void start() {
        int choice;
        while(true) {
            displayMenu();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            if(choice == 1){
                menu.print_beverages();
                order_item(menu.get_beverages());

            }else if(choice == 2){
                menu.print_pastries_and_bakery_items();
                order_item(menu.get_pastries_and_bakery_items());
            
            }else if(choice == 3){
                menu.print_sandwiches_and_wraps();
                order_item(menu.get_sandwiches_and_wraps());


            }else if(choice == 4){
                menu.print_breakfast_items();
                order_item(menu.get_breakfast_items());

            }else if(choice == 5){
                menu.print_salads_and_healthy_options();
                order_item(menu.get_salads_and_healthy_options());

            }else if(choice == 6){

                view_order();
            
            }else if(choice == 7){
                System.out.println("Thank you for visiting! Goodbye.");
                System.exit(0); 

            }else{
                System.out.println("Invalid choice. please try again");
            }
            

        }
    }

    
    private void order_item(menu_item[] items) {
        System.out.print("Enter the number of the item you want to add to your order (or 0 to cancel): ");
        int choice = scanner.nextInt();
    
        if (choice >= 1 && choice <= items.length) {
            menu_item selectedItem = items[choice - 1];

            if (selectedItem != null) {
                order.add_item(selectedItem);
                System.out.println();
                System.out.println(selectedItem.get_name() + " added to your order.");
                System.out.println();

            } else {
                System.out.println();
                System.out.println("Invalid selection. Please try again.");
                System.out.println();
            }

        } else if (choice == 0) {
            System.out.println();
            System.out.println("Order canceled.");
            System.out.println();

        } else {
            System.out.println();
            System.out.println("Invalid Choice");
            System.out.println();
        }
    }
    
    private void process_payment() {
        System.out.println();
        System.out.println("Please provide your details:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Contact Information: ");
        String contactInformation = scanner.next();
        System.out.print("Are you a loyalty program member (true/false): ");
        boolean isLoyaltyProgramMember = scanner.nextBoolean();
        
        Customer customer = new Customer(name, contactInformation, isLoyaltyProgramMember);
    
        double amount_due = order.calculate_total_price(customer);
        System.out.println("Amount Due: " + amount_due);
            
        System.out.print("Enter the amount you want to pay: ");
        double amount_paid = scanner.nextDouble();
        
        Payment payment = new Payment(amount_due, amount_paid, customer);

    
        double change = payment.calculate_change();
        if (change >= 0) {
            System.out.println("Payment successful!");
            System.out.println("Change: " + change);
            order.update_order_status();

            print_receipt(customer, payment);

        } else {
            System.out.println("Insufficient payment. Please try again.");
        }
    }
    private void print_receipt(Customer customer, Payment payment) {
        clear_screen();
        System.out.println();
        System.out.println();
        System.out.println("Here is your receipt\n");
        System.out.println("Customer Details:");
        System.out.println("Name: " + customer.get_name());
        System.out.println("Contact Information: " + customer.get_contact_information());
        System.out.println("Loyalty Customer: " + customer.is_loyalty_program_member());
        System.out.println();
    
        System.out.println("Payment Information:");
        System.out.println("Amount Due: " + payment.get_amount_due());
        System.out.println("Amount Paid: " + payment.get_amount_paid());
        System.out.println("Change: " + payment.calculate_change());
        System.out.println();
    
        Discount discount = payment.get_discount();
        if (discount != null) {
            System.out.println("Discount Applied:");
            System.out.println("Name: " + discount.get_name());
            System.out.println("Amount: " + discount.get_amount());
            System.out.println();
        }

        System.out.println();
        System.out.println("Order status ");
        System.out.println("Order status: " + order.get_order_status());
    
        System.out.println("\n\nThank you for your purchase!");
        System.out.println("\n\nPress any key to continue.....");
        scanner.nextLine();
        scanner.nextLine();
    }
    
    
    
    private void view_order() {
        order.display_order();

        System.out.println();
        System.out.print("Would you like to proceed to payment (y/n): ");
        char choice = scanner.next().charAt(0);
        System.out.println();

        if (choice == 'y'){
            process_payment();
            System.out.println();
        }
        
    }

    private void clear_screen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}

    
