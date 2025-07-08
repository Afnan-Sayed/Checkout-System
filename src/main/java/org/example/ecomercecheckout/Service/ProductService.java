package org.example.ecomercecheckout.Service;

import org.example.ecomercecheckout.Model.ExpirableProduct;
import org.example.ecomercecheckout.Model.Product;
import org.example.ecomercecheckout.Model.ShippableProduct;

import java.time.LocalDate;

public class ProductService
{
    public boolean isAvailable(Product product ,int requestedQuantity)
    {
        return product.getQuantity() >= requestedQuantity;
    }

    public boolean isExpired(Product product)
    {
        if (product instanceof ExpirableProduct)
        {
            ExpirableProduct expirableProduct = (ExpirableProduct) product;
            return LocalDate.now().isAfter(expirableProduct.getExpiryDate());
        }
        return false;
    }

    public boolean isShippable(Product product)
    {
        return product instanceof ExpirableProduct || product instanceof ShippableProduct;
    }

    public double getWeight(Product product)
    {
        if (product instanceof ExpirableProduct)
        {
            return ((ExpirableProduct) product).getWeight();
        }
        else if (product instanceof ShippableProduct)
        {
            return ((ShippableProduct) product).getWeight();
        }
        return 0.0;
    }
}