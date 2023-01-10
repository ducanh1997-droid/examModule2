import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {

    private final ArrayList<Product> products;


    public ProductManager() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void create(Scanner scanner){
        String name;
        int price = 0;
        int amount = 0;
        String description;
        boolean check = false;
        do{

            System.out.println("Thêm tên sản phẩm:");
            name = scanner.nextLine();
            if(name.equals("")){
                System.out.println("Không để trống yêu cầu nhập lại");
            }else{
                check = true;
            }
        }while(!check);
        check = false;
        do{
            try{
                System.out.println("Thêm giá sản phẩm:");
                price = Integer.parseInt(scanner.nextLine());
                check = true;
            }catch(NumberFormatException e){
                System.out.println("Nhập dữ liệu là số");
            }
        }while(!check);
        check = false;

        do{
            try{
                System.out.println("Thêm số lượng sản phẩm:");
                amount = Integer.parseInt(scanner.nextLine());
                check = true;
            }catch(NumberFormatException e){
                System.out.println("Nhập dữ liệu là số");
            }
        }while(!check);
        check = false;
        do{

            System.out.println("Thêm mô tả sản phẩm:");
            description = scanner.nextLine();
            if(name.equals("")){
                System.out.println("Không để trống yêu cầu nhập lại");
            }else{
                check = true;
            }
        }while(!check);
        Product product = new Product(name,price,amount,description);
        products.add(product);
    }

    public void displayAll(ArrayList<Product> products){
        title();
        if(products.isEmpty()){
            System.out.println("Không có sản phẩm nào trên hệ thống");
        }else{
            for(Product product: products){
                product.display();
            }
        }
    }

    public void update(Scanner scanner){
        String name;
        int price;
        int amount;
        String description;
        System.out.println("Nhập id sản phẩm muốn sửa:");
        int id = Integer.parseInt(scanner.nextLine());
        for(Product product: products){
            if(id == product.getId()){
                System.out.println("Nhập tên sản phẩm:");
                name = scanner.nextLine();
                product.setName(name);
                System.out.println("Nhập giá sản phẩm:");
                price = Integer.parseInt(scanner.nextLine());
                product.setPrice(price);
                System.out.println("Nhập số lượng sản phẩm:");
                amount = Integer.parseInt(scanner.nextLine());
                product.setAmount(amount);
                System.out.println("Nhập mô tả sản phẩm:");
                description = scanner.nextLine();
                product.setDescription(description);
            }
        }
    }

    public void deleteProduct(Scanner scanner){
        boolean check = false;
        if(products.isEmpty()){
            System.out.println("không có sản phẩm nào trên hệ thống");
        }else{
            System.out.println("Nhập id sản phẩm muốn xoá:");
            int id = Integer.parseInt(scanner.nextLine());
            for(Product product:products){
                if(id == product.getId()){
                    System.out.println("Bạn có muốn xoá sản phẩm có id "+id+"này không? Y/N");
                    String choice;
                    choice = scanner.nextLine();
                    switch(choice){
                        case "Y":
                            products.remove(id-1);
                            System.out.println("Xoá sản phẩm thành công!");
                            displayAll(products);
                            break;
                        case "N":
                            break;
                    };
                    check = true;
                    break;
                }
            }
            if(!check){
                System.out.println("không tồn tại id này");
            }
        }

    }
    public void sort(){
        ArrayList<Product> productsSort;
        productsSort = products;
            for (int i = 0; i < productsSort.size(); i++) {
                for (int j = productsSort.size() - 1; j > i; j--) {
                    if (productsSort.get(j).getPrice() < productsSort.get(j - 1).getPrice()) {
                        Product temp = productsSort.get(j);
                        //int[j] = int[j - 1]
                        productsSort.set(j, productsSort.get(j - 1));
                        productsSort.set(j - 1, temp);
                    }
                }
            }
            displayAll(productsSort);
    }

    public void findExpensiveProduct(){

        int maxPrice = products.get(0).getPrice();
        for(Product product:products){
            if(maxPrice < product.getPrice()){
                maxPrice = product.getPrice();
            }
        }
        title();
        if(products.isEmpty()){
            System.out.println("không có sản phẩm nào");
        }else{
            for(Product product:products){
                if(maxPrice == product.getPrice()){
                    product.display();
                }
            }
        }
    }

    public Product read(File file){
        Product product = null;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text;

            while ((text = bufferedReader.readLine()) != null) {
                String[] strings = text.split(",");
                product = new Product(strings[0], Integer.parseInt(strings[1]),
                        Integer.parseInt(strings[2]), strings[3]);
                products.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void write(File file){
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Product product: products){
                String write = product.getName() + "," + product.getPrice() + ","
                        + product.getAmount() + ","
                        + product.getDescription() + "\n";
                bufferedWriter.write(write);
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void title(){
        System.out.printf("%-15s%-15s%-15s%-15s%s",
                "ID","NAME","PRICE","AMOUNT","DESCRIPTION" +'\n');
    }
}
