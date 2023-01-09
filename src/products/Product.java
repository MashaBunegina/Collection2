package products;

import java.util.Objects;

public class Product {private String name;
    private double price;
    private double mass;
    private boolean isBought = false;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, double price, double mass) {
        this.name = name;
        this.price = price;
        this.mass = mass;
    }

    //Проверка на заполненность всех полей товара
    public boolean isCompleted() {
        return !name.isBlank() && mass != 0 && price != 0;
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        return name.equals(product.name) && price == product.price && this.getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public String getName() {
        return name;
    }

    public boolean isBought() {
        return isBought;
    }

    @Override
    public String toString() {

        return String.format("%s:  %.2f руб., %.2f кг.", name, price, mass);
    }

}
