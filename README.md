## ✅ Description

This Java-based console application simulates a simple e-commerce checkout system with the following features:

- Define different types of products with name, price, quantity.
- Support for **expirable products** (e.g., Cheese, Biscuits) with expiry date.
- Support for **shippable** and **non-shippable** products.
- Add products to cart in specific quantities (must not exceed available stock).
- Perform checkout:
  - Print **shipment notice** with weight and item details.
  - Print **checkout receipt** with subtotal, shipping, total, and customer balance.
  - Validate corner cases: empty cart, insufficient balance, expired product, quantity over stock.

---

## 📦 Assumptions 
I noticed in the output console example that the shipping cost was 30 when the weight was nearly 1 kg (1.1kg → 30 EGP shipping), so I assumed the shipping cost is 30 EGP per kg.
