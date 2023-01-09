package products;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Product banana = new Product("Бананы", 50, 2);
        Product milk = new Product("Молоко", 45, 1);
        Product bread = new Product("Хлеб");
        bread.setMass(0.5);
        bread.setPrice(20);
        Product bread2 = new Product("Хлеб", 20, 0.5);

        ProductList productList = new ProductList();

        productList.addProduct(banana);
        productList.addProduct(milk);
        productList.addProduct(bread);

        System.out.println(productList.getProductList());



        Recipe breakfast = new Recipe("Breakfast", productList.getProductList());
        Recipe lunch = new Recipe("Lunch", productList.getProductList());
        RecipeBook recipeBook = new RecipeBook();
        recipeBook.addRecipe(breakfast);
        recipeBook.addRecipe(lunch);
        Recipe dinner = new Recipe("Dinner", new HashSet<>());

    }
}

