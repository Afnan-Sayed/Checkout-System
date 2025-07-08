package org.example.ecomercecheckout.Model;

import java.util.ArrayList;
import java.util.List;

//this class represents cart entity
public class Cart
{
    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }
}
