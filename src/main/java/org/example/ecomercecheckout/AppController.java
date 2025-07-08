package org.example.ecomercecheckout;

import org.example.ecomercecheckout.Model.*;
import org.example.ecomercecheckout.Service.CartService;
import org.example.ecomercecheckout.Service.CheckoutService;
import java.time.LocalDate;

public class AppController
{
    public static void main(String[] args)
    {
        //case1:successful checkout
        System.out.println("Case 1: Successful Checkout ");
        try
        {
            Customer customer1 = new Customer("Afnan",1000);
            Product cheese = new ExpirableProduct("Cheese", 100, 10,LocalDate.now().plusDays(2),0.4);
            Product biscuits = new ExpirableProduct("Biscuits", 150, 5, LocalDate.now().plusDays( 5),0.7);
            Product tv = new ShippableProduct("TV", 500, 3, 8.0);
            Product scratchCard = new NotShippableProduct("Mobile Scratch Card", 10, 50);

            CartService cart1 = new CartService();
            cart1.add(cheese, 2);
            cart1.add(biscuits, 1);
            cart1.add(scratchCard, 1);

            CheckoutService checkoutService1 = new CheckoutService();
            checkoutService1.checkout(customer1, cart1);
        }
        catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }

        // case2:empty cart
        System.out.println("\nCase 2: Empty Cart ");
        try
        {
            Customer customer2 = new Customer("Sayed", 500);
            CartService emptyCart = new CartService();
            CheckoutService checkoutService2 = new CheckoutService();
            checkoutService2.checkout(customer2, emptyCart);
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        //case3:insufficient balance
        System.out.println("\nCase 3: Insufficient Balance");
        try
        {
            Customer customer3 = new Customer("Mahmoud", 50);
            Product tv = new ShippableProduct("TV", 500, 2, 8.0);
            CartService cart3 = new CartService();
            cart3.add(tv, 1);
            CheckoutService checkoutService3 = new CheckoutService();
            checkoutService3.checkout(customer3, cart3);
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        //case4: product expired
        System.out.println("\nCase 4: Expired Product ");
        try {
            Customer customer4 = new Customer("Alaa", 1000);
            Product expiredCheese = new ExpirableProduct("Cheese", 100, 5, LocalDate.now().minusDays(1), 0.4);
            CartService cart4 = new CartService();
            cart4.add(expiredCheese, 1);
            CheckoutService checkoutService4 = new CheckoutService();
            checkoutService4.checkout(customer4, cart4);
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        //case5: quantity requested is more than available stock
        System.out.println("\nCase 5: Quantity Exceeds Stock ");
        try {
            Customer customer5 = new Customer("Hamza", 1000);
            Product tv = new ShippableProduct("TV", 500, 2, 8.0);
            CartService cart5 = new CartService();
            cart5.add(tv, 5);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }}