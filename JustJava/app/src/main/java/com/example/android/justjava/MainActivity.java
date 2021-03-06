package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        if (quantity == 100){
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity += 1;
        display(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1){
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity -= 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // input name
        EditText text = findViewById(R.id.name_field);
        String name = text.getText().toString();

        // Figure out if the user wants whipped cream topping
        CheckBox whipped_cream_checkbox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whipped_cream_checkbox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolate_checkbox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolate_checkbox.isChecked();

        // Calculate the price
        int price = calculatePrice(hasWhippedCream, hasChocolate);

        // Display the order summary on the screen
        String priceMessage = createOrderSummry(name, price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "just java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
//        displayMessage(priceMessage);

    }
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate){
        // price one cup of coffee
        int basePrice = 5;

        // add $1 if the user wants whipped cream
        if (addWhippedCream) {
            basePrice += 1;
        }

        // add $2 if the user wants chocolate
        if (addChocolate) {
            basePrice += 2;
        }

        // calculate the total order price multiply by quantity
        return quantity * basePrice;
    }

    private String createOrderSummry(String name, int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "Name: "+ name;
        priceMessage += "\nAdd whipped cream? "+ addWhippedCream;
        priceMessage += "\nAdd chocolate? "+ addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank You!";
        priceMessage += "\n" + getString(R.string.thank_you);
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
//    private void displayMessage(String message) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(message);
//    }
}