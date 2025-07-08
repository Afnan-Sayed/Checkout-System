package org.example.ecomercecheckout.Service;

import org.example.ecomercecheckout.Model.ExpirableProduct;
import org.example.ecomercecheckout.Model.Product;
import org.example.ecomercecheckout.Model.ShippableProduct;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class ShippingService
{
    public void ship(List<Product> products)
    {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;
        for (Product product : products)
        {
            double weight = getWeight(product);
            totalWeight += weight;
            System.out.printf("1x %-15s %.0fg%n", product.getName(),weight *1000);
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }

    private double getWeight(Product product)
    {
        if (product instanceof ExpirableProduct)
        {
            return ((ExpirableProduct) product).getWeight();}
        else if (product instanceof ShippableProduct){
            return ((ShippableProduct) product).getWeight();
        }
        return 0.0;
    }
}