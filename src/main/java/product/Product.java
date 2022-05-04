package product;

public class Product {
    private String name;
    private double price;
    private String category;
    private String state;
    private double discount;

    public Product(String name, double price, String category,String state, double discount) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.state = state;
        this.discount= discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
