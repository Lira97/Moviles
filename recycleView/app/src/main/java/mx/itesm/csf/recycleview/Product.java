package mx.itesm.csf.recycleview;

public class Product {
    private int id;
    private String title;
    private String shortdesc;
    private double rating;
    private double price;
    private String image;

    public Product(double price, String shortdesc ,String image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}













