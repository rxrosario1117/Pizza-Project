import com.google.gson.annotations.SerializedName;
import customer_info.*;
import employees.*;
import food.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//      Customer 1 creation
        customerAddress address = new customerAddress("3070 west", "Powder Springs", "GA", "30127");
        customerCreditCard creditCard = new customerCreditCard("Ray Rosario", "123456789", "123", "02/22");
        Customer c1 = new Customer( "Ray","Rosario", address, "848488555", creditCard);

//        Customer 2 creation
        customerAddress address2 = new customerAddress("919 ensign ave", "Beachwood", "NJ", "08722");
        customerCreditCard creditCard2 = new customerCreditCard("Melinda Duong", "987654321", "789", "09/59");
        Customer c2 = new Customer( "Melinda", "Duong", address2, "9998887777", creditCard2);

        List<Customer> custList = new ArrayList<>();
        custList.add(c1);
        custList.add(c2);

        custList =  Customer.deserializeAList(Customer.serializeAList(custList));

        System.out.println(custList.get(0).getPhoneNumber());
    }

}
