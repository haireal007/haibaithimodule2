package controler;

import Validate.ValidateProduct;
import io.ReaderAndWriteProduct;
import model.Product;
import sort.SortByScore;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    ValidateProduct validateProduct = new ValidateProduct();
    ReaderAndWriteProduct readerAndWriteProduct = new ReaderAndWriteProduct();

    public void menu() {
        System.out.println("===CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM");
        System.out.println("1. hiển thị danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Chỉnh sửa sản phẩm");
        System.out.println("4. Xóa sản phẩm ");
        System.out.println("5. Sắp xếp sản phẩm");
        System.out.println("6. Sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc file");
        System.out.println("8. Ghi file");
        System.out.println("9. Thoát");
        int choice = -1;
        try {
            System.out.println("Nhập lựa chọn ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice > 8) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Lựa chọn sai - vui lòng chọn lại");
        }

        switch (choice) {
            case 1:
                show();
                break;
            case 2:
                addProduct(createProduct());
                break;
            case 3:
                editProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                sortByScore();
                break;
            case 6:
                findProductMax();
                break;
            case 7:
                reader();
                break;
            case 8:
                writer();
                break;
            case 9:
                System.exit(0);
                break;
        }
    }

    public void show() {
        for (Product pr : products) {
            System.out.println(pr);
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product createProduct() {
        int id = validateProduct.validateID(products);
        String name = validateProduct.validateString("name :");
        double price = validateProduct.validatePrice();
        int quantity = validateProduct.validateQuantity();
        String describe = validateProduct.validateString("describe :");
        return new Product(id, name, price, quantity, describe);
    }

    public void editProduct() {
        System.out.println("Nhập id cần sửa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexId(id, products);
        if (index != -1) {
            products.set(index, createProduct());
        } else {
            System.err.println("id không tồn tại");
        }
    }

    public void deleteProduct() {
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexId(id, products);
        if (index != -1) {
            products.remove(index);
        } else {
            System.err.println("id không tồn tại");
        }
    }

    public void sortByScore() {
        products.sort(new SortByScore());
        System.out.println("sắp xếp giảm dần thành công");
    }

    public void reader() {
        products = readerAndWriteProduct.reader();
        System.out.println("đọc thành công");
    }

    public void writer() {
        readerAndWriteProduct.Write(products);
        System.out.println("Ghi thành công");
    }

    public void findProductMax() {
        sortByScore();
        System.out.println("sản phẩm có giá đắt nhất");
        for (Product pr : products) {
            if (pr.getPrice() == products.get(0).getPrice()) {
                System.out.println(pr);
            }

        }
    }
}
