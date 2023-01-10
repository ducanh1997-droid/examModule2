import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("/Users/ducanh/Desktop/examModule2/product.csv");
//        Product product = new Product("keo", 18, 1, "keo deo");
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        MenuProduct(productManager,scanner,file);
    }
    public static void MenuProduct(ProductManager productManager, Scanner scanner,File file){
        int choice;
        do{
            System.out.println("----- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ------");
            System.out.println("Chọn chức năng số (để tiếp tục)");
            System.out.println("1.Xem danh sách");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xoá");
            System.out.println("5.Sắp xếp theo gía tăng dần");
            System.out.println("6.Tìm sản phẩm có giá đắt nhất");
            System.out.println("7.Đọc từ file");
            System.out.println("8.Ghi vào file");
            System.out.println("9.Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    productManager.displayAll(productManager.getProducts());
                    break;
                case 2:
                    productManager.create(scanner);
                    break;
                case 3:
                    productManager.update(scanner);
                    break;
                case 4:
                    productManager.deleteProduct(scanner);
                case 5:
                    productManager.sort();
                    break;
                case 6:
                    productManager.findExpensiveProduct();
                    break;
                case 7:
                    productManager.read(file);
                    break;
                case 8:
                    productManager.write(file);
                    break;
            }
        }while(choice!=0);
    }
}
