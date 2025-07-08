package org.example.ecomercecheckout.Model;

//this class represents customer entity
public class Customer
{
    private String name;
    private double balance;

    public Customer(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {return name;}
    public void setName(String name) { this.name = name;}
    public double getBalance() { return balance;}
    public void setBalance(double balance) { this.balance = balance;}
}