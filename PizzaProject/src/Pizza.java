import Utilities.Constants;

public class Pizza {

    String[] toppingsList = Constants.TOPPINGSLIST;
    SpecialtyPizzas specialtyPizzas;
    int quantity;


    public static class SpecialtyPizzas{
        // pizza types
        String sausage;
        String pepperoni;
        String Cheese;
        String Marinara;
        String Supreme;
        String Veggie;
    }


    public static class BuildYourOwn{
        ///
        String crust;
    }
}
