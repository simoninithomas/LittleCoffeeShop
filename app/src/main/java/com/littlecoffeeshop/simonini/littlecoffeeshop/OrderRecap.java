package com.littlecoffeeshop.simonini.littlecoffeeshop;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.TextView;
import android.widget.Toast;

public class OrderRecap extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_recap);

        // On récupère les variables envoyés depuis l'intent.
        Intent myIntent = getIntent();
        String price = myIntent.getStringExtra("price");
        String order = myIntent.getStringExtra("order");
        String customerName = myIntent.getStringExtra("customerName");

        TextView customerText = (TextView) findViewById(R.id.customerName_text_view);
        customerText.setText(customerName);

        TextView orderText = (TextView) findViewById(R.id.order_recap_text_view);
        orderText.setText(order);

        TextView totalText = (TextView) findViewById(R.id.total_text_view);
        totalText.setText(price);

        // On envoi une notification
        sendNotificationOrderBegin();
        // On démarre le chronomètre
        new CountDownTimer(60000, 1000) {

            TextView totalTime = (TextView) findViewById(R.id.total_time_text_view);


            public void onTick(long millisUntilFinished) {
                totalTime.setText("" + millisUntilFinished / 1000);

            }

            public void onFinish() {
                sendNotificationOrderReady();
            }

        }.start();





    }

    public void sendNotificationOrderBegin(){

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("Commande envoyée")
                        .setContentText("Nous préparons votre commande elle sera prête dans 1min");

        // Sets an ID for the notification
        int mNotificationId = 001;
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    public void sendNotificationOrderReady(){

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("Commande prête")
                        .setContentText("Vous pouvez venir chercher votre commande");

        // Sets an ID for the notification
        int mNotificationId = 001;
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
}
