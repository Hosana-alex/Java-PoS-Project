import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class gui {
    private JFrame frame;
    private Menu menu;
    private order order;
    private JTextArea order_details;
    private JTabbedPane tabbed_pane;
    private JTextField total_amount_field; 
    private Customer current_customer;


    public gui(){
        this.menu = new Menu();
        this.order = new order();
        create_and_show_gui();

    }
    private void create_and_show_gui(){
        frame = new JFrame("Cafe Managemant System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        initialize_components();

        frame.setVisible(true);

    }

    private void initialize_components() {
        tabbed_pane = new JTabbedPane();
        JPanel menu_panel = create_menu_panel();
        JPanel order_panel = create_order_panel();
        JPanel payment_panel = create_payment_panel();
    
        tabbed_pane.addTab("Menu", menu_panel);
        tabbed_pane.addTab("Order", order_panel);
        tabbed_pane.addTab("Payment", payment_panel);
    
        tabbed_pane.addChangeListener(e -> {
            if (tabbed_pane.getSelectedIndex() == 2) {  // Assuming payment panel is at index 2
                update_total_amount();
            }
        });
    
        frame.add(tabbed_pane, BorderLayout.CENTER);
    }
    

    //create UI Components
    private JPanel create_menu_panel(){
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Menu Items", SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        //further implementation will go here
        JTabbedPane categoryTabs = new JTabbedPane();

        categoryTabs.addTab("Beverages", new JScrollPane(new JList<>(get_menu_items(menu.get_beverages()))));
        categoryTabs.addTab("Pastries", new JScrollPane(new JList<>(get_menu_items(menu.get_pastries_and_bakery_items()))));
        categoryTabs.addTab("Sandwiches", new JScrollPane(new JList<>(get_menu_items(menu.get_sandwiches_and_wraps()))));
        categoryTabs.addTab("Breakfast", new JScrollPane(new JList<>(get_menu_items(menu.get_breakfast_items()))));
        categoryTabs.addTab("Salads", new JScrollPane(new JList<>(get_menu_items(menu.get_salads_and_healthy_options()))));

        panel.add(categoryTabs, BorderLayout.CENTER);
        

        return panel;
    }
    private String[] get_menu_items(menu_item[] items) {
        String[] menuItems = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            menuItems[i] = items[i].get_name() + " - $" + items[i].get_price();
        }
        return menuItems;
    }
    private JPanel create_order_panel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Order Details", SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);
    
        order_details = new JTextArea(10, 30);
        order_details.setEditable(false);
        JScrollPane scroll_pane = new JScrollPane(order_details);
        panel.add(scroll_pane, BorderLayout.CENTER);
    
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Item");
        JButton removeButton = new JButton("Remove Item");
        JButton clearButton = new JButton("Clear Order");
        JButton proceedToPaymentButton = new JButton("Proceed to Payment");
        proceedToPaymentButton.addActionListener(e -> {
            current_customer = get_customer_details();
            if (current_customer != null) {
                update_total_amount();
                tabbed_pane.setSelectedIndex(2); // Proceed to payment tab
            } else {
                JOptionPane.showMessageDialog(frame, "Customer details are required to proceed to payment.");
            }
        });

    
        addButton.addActionListener(e -> add_item_to_order());
        removeButton.addActionListener(e -> remove_item_from_order());
        clearButton.addActionListener(e -> clear_order());
    
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(proceedToPaymentButton);
    
        panel.add(buttonPanel, BorderLayout.SOUTH);
    
        update_order_details();
    
        return panel;
    }
    
    private void add_item_to_order() {
        String[] categories = {"Beverages", "Pastries", "Sandwiches", "Breakfast", "Salads"};
        String selectedCategory = (String) JOptionPane.showInputDialog(frame, "Select a category:", "Add Item", JOptionPane.PLAIN_MESSAGE, null, categories, categories[0]);
    
        if (selectedCategory != null) {
            menu_item[] items = {};
            switch (selectedCategory) {
                case "Beverages":
                    items = menu.get_beverages();
                    break;
                case "Pastries":
                    items = menu.get_pastries_and_bakery_items();
                    break;
                case "Sandwiches":
                    items = menu.get_sandwiches_and_wraps();
                    break;
                case "Breakfast":
                    items = menu.get_breakfast_items();
                    break;
                case "Salads":
                    items = menu.get_salads_and_healthy_options();
                    break;
            }
    
            ArrayList<String> itemStrings = new ArrayList<>();
            for (menu_item item : items) {
                itemStrings.add(item.get_name() + " - $" + item.get_price());
            }
    
            String selectedItemString = (String) JOptionPane.showInputDialog(frame, "Select an item to add:", "Add Item", JOptionPane.PLAIN_MESSAGE, null, itemStrings.toArray(new String[0]), null);
    
            if (selectedItemString != null) {
                for (menu_item item : items) {
                    if ((item.get_name() + " - $" + item.get_price()).equals(selectedItemString)) {
                        order.add_item(item);
                        update_order_details();  // Assuming order_details is accessible here
                        break;
                    }
                }
            }
        }
    }
    
    private void remove_item_from_order() {
        menu_item[] orderedItems = order.get_ordered_items();
        if (orderedItems == null || orderedItems.length == 0) {
            JOptionPane.showMessageDialog(frame, "No items in the order to remove.");
            return;
        }
    
        Map<String, menu_item> itemMap = new HashMap<>();
        String[] itemStrings = new String[orderedItems.length];
        for (int i = 0; i < orderedItems.length; i++) {
            menu_item item = orderedItems[i];
            String itemString = item.get_name() + " - $" + item.get_price();
            itemStrings[i] = itemString;
            itemMap.put(itemString, item);
        }
    
        String selectedItemString = (String) JOptionPane.showInputDialog(frame, "Select an item to remove:", "Remove Item", JOptionPane.PLAIN_MESSAGE, null, itemStrings, itemStrings[0]);
        if (selectedItemString != null && itemMap.containsKey(selectedItemString)) {
            order.remove_item(itemMap.get(selectedItemString));
            update_order_details(); // Refresh the order details
        }
    }
    
    
    private void clear_order() {
        order = new order(); // Reset the order object
        if (order_details != null) {
            order_details.setText(""); // Clear the text area
        }
        JOptionPane.showMessageDialog(frame, "Order has been cleared.");
        update_order_details(); // To refresh the display and show that the order is now empty
    }
    

    

    private void update_order_details() {
        StringBuilder details = new StringBuilder();
        menu_item[] ordered_items = order.get_ordered_items();
        for (menu_item item : ordered_items) {
            if (item != null) {
                details.append(item.get_name())
                        .append(" - ")
                        .append(item.get_size())
                        .append(" - ksh ")
                        .append(item.get_price())
                        .append("\n");
            }
        }
    
        Customer dummyCustomer = new Customer("Guest", "Unknown", false);  // Placeholder customer
        double total = order.calculate_total_price(dummyCustomer);
        details.append("\nTotal: ksh ").append(total);
    
        order_details.setText(details.toString());
    }
    
    private JPanel create_payment_panel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        panel.add(new JLabel("Total Amount Due (ksh):"), gbc);
    
        total_amount_field = new JTextField(10);
        total_amount_field.setEditable(false);
        gbc.gridx = 1;
        panel.add(total_amount_field, gbc);
    
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(new JLabel("Amount Paid:"), gbc);
    
        JTextField amount_paid_field = new JTextField(10);
        gbc.gridx = 1;
        panel.add(amount_paid_field, gbc);
    
        JButton process_payment_button = new JButton("Process Payment");
        process_payment_button.addActionListener(e -> process_payment(amount_paid_field.getText(), total_amount_field));
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(process_payment_button, gbc);
    
        return panel;
    }
    
    
    
    private void update_total_amount() {
        if (current_customer != null) {
            double total = order.calculate_total_price(current_customer);
            total_amount_field.setText(String.format("ksh %.2f", total));
        }
    }
    
    
    
    
    private void process_payment(String amount_paid_text, JTextField total_amount_field) {
        try {
            double amount_paid = Double.parseDouble(amount_paid_text);
        
            if (current_customer == null) {
                JOptionPane.showMessageDialog(frame, "Customer details not found, please try again.");
                return;
            }
        
            double total_amount_due = order.calculate_total_price(current_customer);
            total_amount_field.setText(String.format("ksh %.2f", total_amount_due));
        
            if (amount_paid >= total_amount_due) {
                JOptionPane.showMessageDialog(frame, "Payment successful! Change: ksh " + (amount_paid - total_amount_due));
                clear_order();
            } else {
                JOptionPane.showMessageDialog(frame, "Insufficient payment, please try again.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid amount entered, please try again.");
        }
    }
    
    
    
    
    private Customer get_customer_details() {
        JTextField nameField = new JTextField();
        JTextField contactField = new JTextField();
        JCheckBox loyaltyCheckBox = new JCheckBox("Loyalty Program Member");
    
        Object[] message = {
            "Name:", nameField,
            "Contact Information:", contactField,
            loyaltyCheckBox
        };
    
        int option = JOptionPane.showConfirmDialog(null, message, "Enter Customer Details", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String contact = contactField.getText();
            boolean isLoyaltyMember = loyaltyCheckBox.isSelected();
            return new Customer(name, contact, isLoyaltyMember);
        } else {
            return null; // Or return a default customer object
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(gui::new);
    }
    

    //implement menu display

    
}
