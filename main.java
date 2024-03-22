class menu_item{
    private String name;
    private double price;
    private String description;
    private String size;

 
    public menu_item(String name, double price, String description, String size){
        this.name = name;
        this.price = price;
        this.description = description;
        this.size = size;
    }
    public String get_name(){
        return this.name;
    }
    public double get_price(){
        return this.price;

    }
    public String get_description(){
        return this.description;
    }
    public String get_size(){
        return this.size;
    }
       
}

class Menu {
    private menu_item[] beverages;
    private menu_item[] pastries_and_bakery_items;
    private menu_item[] sandwiches_and_wraps;
    private menu_item[] breakfast_items;
    private menu_item[] salads_and_healthy_options;

    public Menu() {
        initialize_menu();
    }

    private void initialize_menu() {
        beverages = new menu_item[]{
            new menu_item("Espresso", 250, "Strong coffee brewed by forcing steam through finely-ground coffee beans.", "Regular"),
            new menu_item("Cappuccino", 350, "Espresso mixed with steamed milk foam.", "Regular"),
            new menu_item("Latte", 300, "Espresso mixed with steamed milk.", "Regular"),
            new menu_item("Americano", 200, "Espresso with added hot water.", "Regular"),
            new menu_item("Mocha", 400, "Espresso with steamed milk and chocolate syrup.", "Regular"),
            new menu_item("Macchiato", 300, "Espresso 'stained' with a small amount of frothed milk.", "Regular"),
            new menu_item("Flat White", 350, "Espresso with velvety steamed milk.", "Regular"),
            new menu_item("Hot Chocolate", 350, "Melted chocolate mixed with steamed milk or water.", "Regular"),
            new menu_item("Tea", 150, "Various types of tea such as green tea, black tea, herbal tea.", "Regular"),
            new menu_item("Chai Latte", 350, "Spiced tea concentrate mixed with steamed milk.", "Regular")
        };
        
        pastries_and_bakery_items = new menu_item[]{
            new menu_item("Croissant", 200, "Buttery and flaky pastry.", "Regular"),
            new menu_item("Muffin", 250, "Sweet bread typically with fruits or nuts.", "Regular"),
            new menu_item("Scone", 200, "Sweet bread similar to a biscuit.", "Regular"),
            new menu_item("Danish", 300, "Pastry with various fillings such as fruit or cheese.", "Regular"),
            new menu_item("Bagel", 200, "Doughnut-shaped bread roll.", "Regular"),
            new menu_item("Cookie", 150, "Sweet baked dessert typically containing flour, sugar, and butter.", "Regular"),
            new menu_item("Brownie", 200, "Rich and dense chocolate dessert.", "Regular"),
            new menu_item("Doughnut", 250, "Sweet fried dough typically with glaze or filling.", "Regular"),
            new menu_item("Banana Bread", 250, "Sweet bread made with mashed bananas.", "Regular"),
            new menu_item("Coffee Cake", 300, "Sweet cake with a crumbly topping, often flavored with cinnamon.", "Regular")
        };
        
        sandwiches_and_wraps = new menu_item[]{
            new menu_item("Turkey and Swiss", 400, "Sliced turkey and Swiss cheese on bread.", "Regular"),
            new menu_item("Ham and Cheese", 400, "Sliced ham and cheese on bread.", "Regular"),
            new menu_item("Veggie Delight", 350, "Vegetarian sandwich with various vegetables.", "Regular"),
            new menu_item("Caprese", 350, "Tomato, mozzarella, and basil sandwich.", "Regular"),
            new menu_item("Chicken Caesar Wrap", 400, "Grilled chicken with Caesar dressing wrapped in a tortilla.", "Regular"),
            new menu_item("BLT", 350, "Bacon, lettuce, and tomato sandwich.", "Regular"),
            new menu_item("Tuna Salad Sandwich", 400, "Tuna salad with lettuce and tomato on bread.", "Regular"),
            new menu_item("Grilled Cheese", 300, "Melted cheese between slices of grilled bread.", "Regular"),
            new menu_item("Club Sandwich", 450, "Triple-decker sandwich with turkey, bacon, lettuce, tomato, and mayo.", "Regular"),
            new menu_item("Roast Beef Panini", 450, "Roast beef with cheese and vegetables pressed between slices of bread.", "Regular")
        };
        
        breakfast_items = new menu_item[]{
            new menu_item("Pancakes", 350, "Flat cakes made from batter and cooked on a hot griddle.", "Regular"),
            new menu_item("French Toast", 300, "Bread soaked in beaten eggs and then fried.", "Regular"),
            new menu_item("Waffles", 400, "Batter cooked in a waffle iron.", "Regular"),
            new menu_item("Breakfast Burrito", 400, "Burrito filled with eggs, cheese, and breakfast meat.", "Regular"),
            new menu_item("Avocado Toast", 350, "Toast topped with mashed avocado.", "Regular"),
            new menu_item("Eggs Benedict", 450, "Poached eggs and Canadian bacon on an English muffin, topped with hollandaise sauce.", "Regular"),
            new menu_item("Breakfast Sandwich", 400, "Sandwich with egg, cheese, and choice of sausage, bacon, or ham.", "Regular")
        };
        
        salads_and_healthy_options = new menu_item[]{
            new menu_item("Caesar Salad", 350, "Salad made with romaine lettuce, croutons, Parmesan cheese, and Caesar dressing.", "Regular"),
            new menu_item("Greek Salad", 400, "Salad made with tomatoes, cucumbers, olives, feta cheese, and Greek dressing.", "Regular"),
            new menu_item("Cobb Salad", 400, "Salad made with mixed greens, tomatoes, bacon, chicken, hard-boiled eggs, avocado, and blue cheese dressing.", "Regular"),
            new menu_item("Quinoa Salad", 350, "Salad made with quinoa, vegetables, and vinaigrette dressing.", "Regular"),
            new menu_item("Garden Salad", 300, "Mixed greens with assorted fresh vegetables and choice of dressing.", "Regular"),
            new menu_item("Fruit Salad", 300, "Assorted fresh fruits served as a salad.", "Regular"),
            new menu_item("Greek Yogurt Parfait", 300, "Layered dessert with Greek yogurt, granola, and fruit.", "Regular"),
            new menu_item("Acai Bowl", 400, "Smoothie bowl made with acai berries and topped with granola and fruit.", "Regular")
        };
        
    }
    public menu_item[] get_beverages(){
        return this.beverages;
    }

    public menu_item[] get_pastries_and_bakery_items(){
        return this.pastries_and_bakery_items;
    }

    public menu_item[] get_sandwiches_and_wraps(){
        return this.sandwiches_and_wraps;
    }

    public menu_item[] get_breakfast_items(){
        return this.breakfast_items;
    }

    public menu_item[] get_salads_and_healthy_options(){
        return this.salads_and_healthy_options;
    }

    public void print_beverages() {
        print_items(beverages);
    }

    public void print_pastries_and_bakery_items() {
        print_items(pastries_and_bakery_items);
    }

    public void print_sandwiches_and_wraps() {
        print_items(sandwiches_and_wraps);
    }

    public void print_breakfast_items() {
        print_items(breakfast_items);
    }

    public void print_salads_and_healthy_options() {
        print_items(salads_and_healthy_options);
    }

    private void print_items(menu_item[] items) {
        int i = 1;
        for (menu_item item : items) {
            System.out.println(i + ". " + item.get_name() + "\t" + item.get_description() + "\t" + item.get_price() + "\t" + item.get_size());
            i++;
        }
        System.out.println();
    }

}


class order{
    private menu_item[] ordered_items;
    private int item_count;
    private double total_price;
    private String order_status;


    public order(){
        this.ordered_items = new menu_item[10];
        this.item_count = 0;
        this.total_price = 0.0;
        this.order_status = "Pending";

    }

    public double calculate_total_price(Customer customer) {
        double discounted_total = 0;
    
        for (menu_item item : ordered_items) {
            if (item != null) {
                discounted_total += item.get_price();
            }
        }
    
        if (customer.is_loyalty_program_member()) {
            Discount loyalty_discount = new Discount("10% off", 10, true);
            if (loyalty_discount.is_percentage()) {
                double discountAmount = (loyalty_discount.get_amount() / 100) * discounted_total;
                discounted_total -= discountAmount;
            } else {
                discounted_total -= loyalty_discount.get_amount();
            }
    
        } else {
            Discount other_discount = new Discount("10$ off", 10, false);
                if (other_discount.is_percentage()) {
                    discounted_total -= (other_discount.get_amount() / 100) * discounted_total;
                } else {
                    discounted_total -= other_discount.get_amount();
                }                
            
        }
    
        total_price = discounted_total;
        return total_price;
    }
    
    
    public void add_item(menu_item item){
        if(item_count < ordered_items.length){
            ordered_items[item_count] = item;
            total_price += item.get_price();
            item_count++;
        }else{
            System.out.print("Order is full. Cannot add more items");
        }
    }
    public void remove_item(menu_item item) {
        boolean found = false;
    
        for (int i = 0; i < item_count; i++) {
            if (ordered_items[i] == item) {
                this.total_price -= item.get_price();
                ordered_items[i] = null;
                item_count--;
                
                for (int j = i; j < item_count; j++) {
                    ordered_items[j] = ordered_items[j + 1];
                }
                ordered_items[item_count] = null;
                
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in the order.");
        }
    }
    
    public void display_order() {
        if (item_count == 0) {
            System.out.println();
            System.out.println("Your order is empty.");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Your current order:");
            for (int i = 0; i < item_count; i++) {
                menu_item item = ordered_items[i];
                System.out.println((i + 1) + ". " + item.get_name() + "\t" + item.get_description() + "\t" + item.get_price() + "\t" + item.get_size());
            }
            System.out.println();
            System.out.println("Total Price: " + total_price);
            System.out.println();
        }
    }

    public String get_order_status(){
        return this.order_status;
    }

    public void update_order_status(){
        this.order_status = "Completed";
    }
}
class Discount {
    private String name;
    private double amount;
    private boolean percentage; 

    public Discount(String name, double amount, boolean percentage) {
        this.name = name;
        this.amount = amount;
        this.percentage = percentage;
    }

    
    public String get_name() {
        return name;
    }

    public double get_amount() {
        return amount;
    }

    public boolean is_percentage() {
        return percentage;
    }
}


class Payment {
    private double amount_due;
    private double amount_paid;
    private Discount discount; 

    public Payment(double amount_due, double amount_paid) {
        this.amount_due = amount_due;
        this.amount_paid = amount_paid;
    }

   
    public Payment(double amount_due, double amount_paid, Discount discount) {
        this(amount_due, amount_paid); 
        this.discount = discount;
    }


    public Payment(double amount_due, double amount_paid, Customer customer) {
        this.amount_due = amount_due;
        this.amount_paid = amount_paid;

        if (customer != null && customer.is_loyalty_program_member()) {
            this.discount = new Discount("Loyalty Discount 10% off", 10, true);
        }else{
            this.discount = new Discount("10$ off", 10, false);
        }
    }

    public double calculate_change() {
        double discounted_amount_due = amount_due;
    
        if (discount != null) {
            if (discount.is_percentage()) {
                double discount_amount = (discount.get_amount() / 100) * amount_due;
                discounted_amount_due -= discount_amount;
            } else {
                discounted_amount_due -= discount.get_amount();
            }
        }
    
        if (amount_paid >= discounted_amount_due) {
            return amount_paid - discounted_amount_due;
        }
        return 0;
    }
    

    public double get_amount_due(){
        return this.amount_due;
    }
    public double get_amount_paid(){
        return this.amount_paid;
    }

    public Discount get_discount(){
        return this.discount;
    }
}

class Customer {
    private String name;
    private String contact_information;
    private boolean loyalty_program_member;

    public Customer(String name, String contact_information, boolean loyalty_program_member) {
        this.name = name;
        this.contact_information = contact_information;
        this.loyalty_program_member = loyalty_program_member;
    }

  
    public String get_name() {
        return name;
    }

    public String get_contact_information() {
        return contact_information;
    }

    public boolean is_loyalty_program_member() {
        return loyalty_program_member;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_contact_information(String contact_information) {
        this.contact_information = contact_information;
    }

    public void set_loyalty_program_member(boolean loyalty_program_member) {
        this.loyalty_program_member = loyalty_program_member;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", contactInformation='" + contact_information + '\'' +
                ", loyaltyProgramMember=" + loyalty_program_member +
                '}';
    }
}
