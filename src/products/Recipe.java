package products;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipe {
    private String name;
    private Set<Product> products = new HashSet<>();
    private double totalPrice;

    public Recipe(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    private void calculateTotalPrice() {
        double price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }
        totalPrice = price;
    }

    public double getTotalPrice() {
        calculateTotalPrice();
        return totalPrice;
    }

    public void addProduct(Product product){
        if (!product.isCompleted()) {
            throw new RuntimeException("Товар имеет незаполненные поля. Исправьте это перед добавлением в список!");
        }
        if (products.contains(product)) {
            throw new RuntimeException("Вы пытаетесть добавить товар, который уже в списке!");
        } else {
            products.add(product);
        }
    }

    public String getName() {
        return name;
    }

    public void setProducts(Set<Product> products) {
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

}