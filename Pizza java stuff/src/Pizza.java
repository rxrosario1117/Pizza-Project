import java.util.List;

//public class Pizza {
//
//    String size;
//    String pizzaType;
//    int quantity;
//    List<String> toppings;
//    SpecialtyPizzas specialtyPizzas;
//
//    //    pizza constructor and getters and setters
//    public Pizza(String size, int quantity, List<String> toppings) {
//        this.size = size;
//        this.quantity = quantity;
//        this.toppings = toppings;
//    }
//
//    public Pizza(String size, String pizzaType){
//        this.size = size;
//        this.pizzaType = pizzaType;
//
//    }
//
//    public String getSize() {
//        return size;
//    }
//
//    public void setSize(String size) {
//        this.size = size;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public List<String> getToppings() {
//        return toppings;
//    }
//
//    public void setToppings(List<String> toppings) {
//        this.toppings = toppings;
//    }
//
//    public SpecialtyPizzas getSpecialtyPizzas() {
//        return specialtyPizzas;
//    }
//
//    public void setSpecialtyPizzas(SpecialtyPizzas specialtyPizzas) {
//        this.specialtyPizzas = specialtyPizzas;
//    }
//
//    //    nested class for Specialty Pizzas w/ constructor, getters, and setters
//    public static class SpecialtyPizzas{
//        // pizza types
//        Boolean sausage;
//        Boolean pepperoni;
//        Boolean Cheese;
//        Boolean Marinara;
//        Boolean Supreme;
//        Boolean Veggie;
//        String size;
//
//        public SpecialtyPizzas(Boolean sausage, Boolean pepperoni, Boolean cheese, Boolean marinara, Boolean supreme, Boolean veggie, String size) {
//            this.sausage = sausage;
//            this.pepperoni = pepperoni;
//            Cheese = cheese;
//            Marinara = marinara;
//            Supreme = supreme;
//            Veggie = veggie;
//            this.size = size;
//        }
//
//        public Boolean getSausage() {
//            return sausage;
//        }
//
//        public void setSausage(Boolean sausage) {
//            this.sausage = sausage;
//        }
//
//        public Boolean getPepperoni() {
//            return pepperoni;
//        }
//
//        public void setPepperoni(Boolean pepperoni) {
//            this.pepperoni = pepperoni;
//        }
//
//        public Boolean getCheese() {
//            return Cheese;
//        }
//
//        public void setCheese(Boolean cheese) {
//            Cheese = cheese;
//        }
//
//        public Boolean getMarinara() {
//            return Marinara;
//        }
//
//        public void setMarinara(Boolean marinara) {
//            Marinara = marinara;
//        }
//
//        public Boolean getSupreme() {
//            return Supreme;
//        }
//
//        public void setSupreme(Boolean supreme) {
//            Supreme = supreme;
//        }
//
//        public Boolean getVeggie() {
//            return Veggie;
//        }
//
//        public void setVeggie(Boolean veggie) {
//            Veggie = veggie;
//        }
//
//        public String getSize() {
//            return size;
//        }
//
//        public void setSize(String size) {
//            this.size = size;
//        }
//    }
//
//    //    nested class for Build Your Own w/ constructor, getters, and setters
//    public static class BuildYourOwn {
//        String crust;
//        char sauce;
//        char cheese;
//        List<String> toppings;
//
//        public BuildYourOwn(String crust, char sauce, char cheese, List<String> toppings) {
//            this.crust = crust;
//            this.sauce = sauce;
//            this.cheese = cheese;
//            this.toppings = toppings;
//        }
//
//        public String getCrust() {
//            return crust;
//        }
//
//        public void setCrust(String crust) {
//            this.crust = crust;
//        }
//
//        public char getSauce() {
//            return sauce;
//        }
//
//        public void setSauce(char sauce) {
//            this.sauce = sauce;
//        }
//
//        public char getCheese() {
//            return cheese;
//        }
//
//        public void setCheese(char cheese) {
//            this.cheese = cheese;
//        }
//
//        public List<String> getToppings() {
//            return toppings;
//        }
//
//        public void setToppings(List<String> toppings) {
//            this.toppings = toppings;
//        }
//    }
//
//}

class Pizza {

    String pizzaType;
    String size;
    private float price;
    private float small = 5.00f;
    private float medium = 7.50f;
    private float large = 10.00f;

//  Specialty Pizza constructor
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

    //This constructor is a constructor used in BYO so that PizzaType is not needed
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
