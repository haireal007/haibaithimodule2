package Main;

import controler.ManagerProduct;

public class Main {
    public static void main(String[] args) {
        ManagerProduct managerProduct = new ManagerProduct();
        while (true) {
            managerProduct.menu();
        }
    }
}
