package food;

import java.util.List;

public class BYO extends Pizza{
    String crustType;
    String sauce;
    String cheese;
    List<String> toppings;

    public BYO(String crustType, String sauce, String cheese, List<String> toppings, String size) {
        super(size);
        this.crustType = crustType;
        this.sauce = sauce;
        this.cheese = cheese;
        this.toppings = toppings;
        setPrice(getPrice() + calcToppingPrice());

    }

    public float calcToppingPrice(){
        return (.50f * toppings.size());
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }
}



