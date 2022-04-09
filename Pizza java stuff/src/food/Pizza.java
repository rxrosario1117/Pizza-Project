package food;

import java.util.List;

public class Pizza {

    String pizzaType;
    String size;
    private float price;
    private float small = 5.00f;
    private float medium = 7.50f;
    private float large = 10.00f;

//  Specialty food.Pizza constructor
    public Pizza(){

    }

    public Pizza(String pizzaType, String size){
        if (size.equalsIgnoreCase("small")) {
            this.pizzaType = pizzaType;
            this.size = size;
            price += small;
        }
        else if (size.equalsIgnoreCase("medium")){
            this.pizzaType = pizzaType;
            this.size = size;
            price += medium;
        }
        else if (size.equalsIgnoreCase("large")){
            this.pizzaType = pizzaType;
            this.size = size;
            price += large;
        }
    }

    //This constructor is a constructor used in food.BYO so that PizzaType is not needed
    public Pizza(String size){
        this.size = size;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSmall() {
        return small;
    }

    public void setSmall(float small) {
        this.small = small;
    }

    public float getMedium() {
        return medium;
    }

    public void setMedium(float medium) {
        this.medium = medium;
    }

    public float getLarge() {
        return large;
    }

    public void setLarge(float large) {
        this.large = large;
    }


}
