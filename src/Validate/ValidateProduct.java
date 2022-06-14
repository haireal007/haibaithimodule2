package Validate;

import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidateProduct {
    Scanner scanner = new Scanner(System.in);

    //check ID:

    public int getIndexId(int id, ArrayList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }


    // các hàm check từng giá trị:
    public int validateID(ArrayList<Product> products) {
        while (true) {
            try {
                System.out.println("Nhập ID:");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id, products) != -1) {
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.err.println("Nhập sai id rồi");
            }
        }
    }

    public String validateString(String name) {
        while (true) {
            System.out.println("Nhập " + name);
            String str = scanner.nextLine();
            if (str.equals("")) {
                System.err.println("không để trống");
                continue;
            } else {
                return str;
            }
        }
    }

    public double validatePrice() {
        while (true) {
            try {
                System.out.println("Nhập giá sản phẩm :");
                double price = Integer.parseInt(scanner.nextLine());
                return price;
            } catch (Exception e) {
                System.err.println("Nhập sai giá sản phẩm rồi");
            }
        }
    }

    public int validateQuantity() {
        while (true) {
            try {
                System.out.println("Nhập số lượng :");
                int quantity = Integer.parseInt(scanner.nextLine());
                return quantity;
            } catch (Exception e) {
                System.err.println("Nhập sai số lượng rồi");
            }
        }
    }
}
