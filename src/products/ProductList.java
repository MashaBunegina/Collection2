package products;

import java.util.HashSet;
import java.util.Set;

public class ProductList
{private Set<Product> productList = new HashSet<>();
    public void addProduct(Product product) {
        if (!product.isCompleted()) {
            throw new RuntimeException("Товар имеет незаполненные поля. Исправьте это перед добавлением в список!");
        }
        if (productList.contains(product)) {
            throw new RuntimeException("Вы пытаетесть добавить товар, который уже в списке!");
        } else {
            productList.add(product);
        }
    }

    public void markBought(Product product) {
        if (productList.contains(product)) {
            product.setBought(true);
        } else {
            System.out.println("Товар еще не в списке. Поэтому нельзя его поменить как купленный.");
        }
    }

    public void remove(Product product) {
        productList.remove(product);
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }
}

