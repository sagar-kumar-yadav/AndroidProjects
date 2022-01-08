package com.example.android.justjava;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
    * This method is called when the plus button is clicked.
    */
    public void increment(View view) {
        quantity += 1;
        display(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity -= 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Figure out if the user wants whipped cream topping
        CheckBox whipped_cream_checkbox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whipped_cream_checkbox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolate_checkbox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolate_checkbox.isChecked();

        // Calculate the price
        int price = calculatePrice();

        // Display the order summary on the screen
        String priceMessage = createOrderSummry(price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }
    private int calculatePrice(){
        return quantity*5;
    }

    private String createOrderSummry(int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "Sagar kumar yadav";
        priceMessage += "\nAdd whipped cream? "+ addWhippedCream;
        priceMessage += "\nAdd chocolate? "+ addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}