package org.example.ecomercecheckout.Model;

//this class represents the product entity that is nott shipped
public class NotShippableProduct extends Product
{
    public NotShippableProduct(String name, double price, int quantity)
    {
        super(name, price, quantity);
    }
}