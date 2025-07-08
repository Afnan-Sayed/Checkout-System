package org.example.ecomercecheckout.Service;

import org.example.ecomercecheckout.Model.CartItem;
import org.example.ecomercecheckout.Model.Product;
import java.util.ArrayList;
import java.util.List;

//this class represents the Cart Service, it holds all business logic related to cart
public class CartService
{
    private final List<CartItem> items = new ArrayList<>();
    private final ProductService productService = new ProductService();

    //add to cart method, i handled exceptions if quantity not availabe and if the product is expired
    public void add(Product product, int quantity) throws Exception
    {
        if (!productService.isAvailable(product, quantity))
        {throw new Exception("Quantity not available for " + product.getName());}

        if (productService.isExpired(product)) {
            throw new Exception("Product " + product.getName() + " is expired");
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {return items;}
    public boolean isEmpty() {return items.isEmpty();}
}