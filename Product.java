public class Product {

    private int id;
    private static int INDEX = 1;
    private String name;
    private int price;
    private int amount;
    private String description;

    public Product(String name, int price, int amount, String description) {
        this.id = INDEX;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        INDEX++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getINDEX() {
        return INDEX;
    }

    public static void setINDEX(int INDEX) {
        Product.INDEX = INDEX;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void display(){
        System.out.printf("%-15s%-15s%-15s%-15s%s",
                id,name,price,amount,description +'\n');
    }
}
