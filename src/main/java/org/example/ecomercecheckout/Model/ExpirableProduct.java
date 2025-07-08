package org.example.ecomercecheckout.Model;

import java.time.LocalDate;

//this class represents the product entity that may expire
public class ExpirableProduct extends Product
{
    private LocalDate expiryDate;
    private double weight;

    public ExpirableProduct (String name, double price, int quantity,
                             LocalDate expiryDate, double weight)
    {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public LocalDate getExpiryDate() {return expiryDate;}
    public void setExpiryDate(LocalDate expiryDate){ this.expiryDate =expiryDate; }
    public double getWeight() { return weight;}
    public void setWeight(double weight) { this.weight = weight; }
}