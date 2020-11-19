package ph.edu.uic.foodapp.model;

public class AsiaFood {
    String name;
    String price;
    Integer imageUrl;

    public AsiaFood(String name, String price, Integer imageUrl, String rating, String restaurantname) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.restaurantname = restaurantname;
    }


    public String getRating() {
        return rating;
    }

    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
    }

    String rating;
    String restaurantname;



    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }
}