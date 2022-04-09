package food;

import java.util.List;

public class BYO extends Pizza{
    private String crustType;
    private String sauce;
    private String cheese;
    private List<String> toppings;

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
}



