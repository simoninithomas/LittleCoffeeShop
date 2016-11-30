package com.littlecoffeeshop.simonini.littlecoffeeshop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //My little coffee font
        //TextView myTextView=(TextView)findViewById(R.id.coffee_shop_text_view);
        //Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/frenchy.ttf");
        //myTextView.setTypeface(typeFace);

        Button buttonView = (Button) findViewById(R.id.order_button);
        buttonView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeActivity.this, OrderActivity.class);
                startActivity(intent);
            }

        });


    }


}
