package com.littlecoffeeshop.simonini.littlecoffeeshop;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

import static android.R.attr.order;

public class OrderActivity extends Activity {

    //Initialize public values
    double totalPrice = 1.5;
    double priceCreamTopping = 0.5;
    double priceChocolateTopping = 1;
    double priceCaramelTopping = 1.5;
    double priceBrownieCake = 2.5;
    double priceCheeseCake = 3;
    double priceCarrotCake = 3.5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Add prices to checkboxes
        TextView cream = (TextView) findViewById(R.id.cream_checkbox);
        cream.setText(getResources().getString(R.string.cream) + " +" + NumberFormat.getCurrencyInstance().format(priceCreamTopping));

        TextView chocolate = (TextView) findViewById(R.id.chocolate_checkbox);
        chocolate.setText(getResources().getString(R.string.chocolate) + " +" + NumberFormat.getCurrencyInstance().format(priceChocolateTopping));

        TextView caramel = (TextView) findViewById(R.id.caramel_checkbox);
        caramel.setText(getResources().getString(R.string.caramel) + " +" + NumberFormat.getCurrencyInstance().format(priceCaramelTopping));

        TextView brownie = (TextView) findViewById(R.id.brownie_checkbox);
        brownie.setText(getResources().getString(R.string.brownie_checkbox) + " +" + NumberFormat.getCurrencyInstance().format(priceBrownieCake));

        TextView cheeseCake = (TextView) findViewById(R.id.cheeseCake_checkbox);
        cheeseCake.setText(getResources().getString(R.string.cheeseCake_checkbox) + " +" + NumberFormat.getCurrencyInstance().format(priceCheeseCake));

        TextView carrotCake = (TextView) findViewById(R.id.carrotCake_checkbox);
        carrotCake.setText(getResources().getString(R.string.carrotCake_checkbox) + " +" + NumberFormat.getCurrencyInstance().format(priceCarrotCake));


        Button orderButton = (Button) findViewById(R.id.order_button);
        orderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String price = calculatePrice();
                String order = submitOrder();
                String customerName = getCustomerName();
                Intent intent = new Intent(OrderActivity.this, OrderRecap.class);
                intent.putExtra("price", price);
                intent.putExtra("order", order);
                intent.putExtra("customerName", customerName);
                startActivity(intent);

            }

        });




    }

    public String getCustomerName(){
        EditText name = (EditText) findViewById(R.id.customerName_edit_text);
        final String customerName = name.getText().toString();
        return customerName;
    }

    public String calculatePrice (){
        //Verify that checkbox are true or false
        CheckBox creamCheckbox = (CheckBox) findViewById(R.id.cream_checkbox);
        boolean creamCheckBoxB = creamCheckbox.isChecked();

        if(creamCheckBoxB){
            totalPrice = totalPrice + priceCreamTopping;

        }
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean chocolateCheckboxB = chocolateCheckbox.isChecked();
        if(chocolateCheckboxB){
            totalPrice = totalPrice + priceChocolateTopping;
        }

        CheckBox caramelCheckbox = (CheckBox) findViewById(R.id.caramel_checkbox);
        boolean caramelCheckboxB = caramelCheckbox.isChecked();
        if(caramelCheckboxB){
            totalPrice = totalPrice + priceCaramelTopping;
        }

        CheckBox brownieCheckbox = (CheckBox) findViewById(R.id.brownie_checkbox);
        boolean brownieCheckboxB = brownieCheckbox.isChecked();
        if(brownieCheckboxB){
            totalPrice = totalPrice + priceBrownieCake;
        }

        CheckBox cheeseCakeCheckbox = (CheckBox) findViewById(R.id.cheeseCake_checkbox);
        boolean cheeseCakeCheckboxB = cheeseCakeCheckbox.isChecked();
        if(cheeseCakeCheckboxB){
            totalPrice = totalPrice + priceCheeseCake;
        }

        CheckBox carrotCakeCheckbox = (CheckBox) findViewById(R.id.carrotCake_checkbox);
        boolean carrotCakeCheckboxB = carrotCakeCheckbox.isChecked();
        if(carrotCakeCheckboxB){
            totalPrice = totalPrice + priceCarrotCake;
        }
        String totalPriceInCurrency = NumberFormat.getCurrencyInstance().format(totalPrice);

        return totalPriceInCurrency;

    }

    public String submitOrder (){
        String order = "Coffee with";

        //Verify that checkbox are true or false
        CheckBox creamCheckbox = (CheckBox) findViewById(R.id.cream_checkbox);
        boolean creamCheckBoxB = creamCheckbox.isChecked();

        if(creamCheckBoxB){
            order = order + "\n" + getString(R.string.cream);

        }
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean chocolateCheckboxB = chocolateCheckbox.isChecked();
        if(chocolateCheckboxB){
            order = order + "\n" + getString(R.string.chocolate);
        }

        CheckBox caramelCheckbox = (CheckBox) findViewById(R.id.caramel_checkbox);
        boolean caramelCheckboxB = caramelCheckbox.isChecked();
        if(caramelCheckboxB){
            order = order + "\n" + getString(R.string.caramel);
        }

        CheckBox brownieCheckbox = (CheckBox) findViewById(R.id.brownie_checkbox);
        boolean brownieCheckboxB = brownieCheckbox.isChecked();
        if(brownieCheckboxB){
            order = order + "\n" + getString(R.string.brownie_checkbox);
        }

        CheckBox cheeseCakeCheckbox = (CheckBox) findViewById(R.id.cheeseCake_checkbox);
        boolean cheeseCakeCheckboxB = cheeseCakeCheckbox.isChecked();
        if(cheeseCakeCheckboxB){
            order = order + "\n" + getString(R.string.cheeseCake_checkbox);
        }

        CheckBox carrotCakeCheckbox = (CheckBox) findViewById(R.id.carrotCake_checkbox);
        boolean carrotCakeCheckboxB = carrotCakeCheckbox.isChecked();
        if(carrotCakeCheckboxB){
            order = order + "\n" + getString(R.string.carrotCake_checkbox);
        }
        return order;
    }


}
