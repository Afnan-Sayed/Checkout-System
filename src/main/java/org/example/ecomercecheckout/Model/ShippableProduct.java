package org.example.ecomercecheckout.Model;

//this class represents the product entity that can be shipped
public class ShippableProduct extends Product
{
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight)
    {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
}

