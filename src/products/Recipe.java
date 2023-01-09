package products;

import java.util.*;

public class Recipe {
    private String name;
    private Map<Product,Integer> products = new HashMap<>();

    private double totalPrice;

    public Recipe(String name, Set<Product> products) {
        this.name = name;
        for (Product product : products) {
            addProduct(product, 3);
        }
    }

    private void calculateTotalPrice() {
        double price = 0;
            for (Product product : products.keySet()) {
                price += product.getPrice() * products.get(product);
            }
            totalPrice = price;
        }

    public double getTotalPrice() {
        calculateTotalPrice();
        return totalPrice;
    }

    public void addProduct(Product product, int i){
        if (!product.isCompleted()) {
            throw new RuntimeException("Товар имеет незаполненные поля. Исправьте это перед добавлением в список!");
        }
        if (products.containsKey(product)) {
            throw new RuntimeException("Вы пытаетесть добавить товар, который уже в списке!");
        } else {
            products.put(product,1);
        }
    }

    public String getName() {
        return name;
    }

    public void setProducts(Map<Product,Integer> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name) && Objects.equals(products, recipe.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products, totalPrice);
    }
    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", products=" + products +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}

