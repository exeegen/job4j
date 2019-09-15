package ru.job4j.pojo;

public class Shop {

    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index + 1; i < products.length; i++) {
            if (products[i] != null) {
                products[i - 1] = products[i];
            } else {
                products[i - 1] = null;
                break;
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Butter", 12);
        products[2] = new Product("Bread", 4);
        products[3] = new Product("Egg", 19);
        products[4] = null;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println("\nDelete index 1\n");

        delete(products, 1);

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
