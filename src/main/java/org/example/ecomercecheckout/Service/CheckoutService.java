package org.example.ecomercecheckout.Service;
import org.example.ecomercecheckout.Model.CartItem;
import org.example.ecomercecheckout.Model.Customer;
import org.example.ecomercecheckout.Model.Product;

import java.util.ArrayList;
import java.util.List;


//this class represents the checkout service, it holds all business logic related to checkout
public class CheckoutService
{
    private final ProductService productService = new ProductService();
    private final ShippingService shippingService = new ShippingService();

    //ASSUMPTION
    //i noticed in the output console example that the shipping cost was 30 when the weight was nearly 1 kg,
    // so i set the shipping cost per kg is 30
    private static final double SHIPPING_RATE_PER_KG = 30.0;

    public void checkout(Customer customer, CartService cartService) throws Exception
    {
        if (cartService.isEmpty()){
            throw new Exception("Cart is empty");
        }

        double subtotal = 0.0;
        List<Product> shippableItems = new ArrayList<>();
        double shippingWeight = 0.0;

        // Prepare receipt details in insertion order
        List<String> receiptLines = new ArrayList<>();

        for (CartItem item : cartService.getItems())
        {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if (!productService.isAvailable(product, quantity)){
                throw new Exception("Not enough quantity for " + product.getName());
            }
            if (productService.isExpired(product)){
                throw new Exception("Product expired: " + product.getName());
            }

            double lineTotal = product.getPrice() * quantity;
            subtotal += lineTotal;
            receiptLines.add(String.format("%dx %-20s %.0f", quantity, product.getName(), lineTotal));

            //update product quantity
            product.setQuantity(product.getQuantity() - quantity);

            //collect shippable items
            if (productService.isShippable(product))
            {
                for (int i = 0; i < quantity; i++)
                {
                    shippableItems.add(product);
                    shippingWeight += productService.getWeight(product);
                }
            }
        }

        double shippingFees = shippingWeight * SHIPPING_RATE_PER_KG;
        double totalAmount = subtotal + shippingFees;

        if (customer.getBalance() < totalAmount){
            throw new Exception("Insufficient balance.");
        }

        customer.setBalance(customer.getBalance() - totalAmount);
        if (!shippableItems.isEmpty()){
            shippingService.ship(shippableItems);
        }

        System.out.println("** Checkout receipt **");
        for (String line : receiptLines) {
            System.out.println(line);
        }
        System.out.println("----------------------");
        System.out.printf("%-18s %.0f%n", "Subtotal", subtotal);
        System.out.printf("%-18s %.0f%n", "Shipping", shippingFees);
        System.out.printf("%-18s %.0f%n", "Amount", totalAmount);
    }
}