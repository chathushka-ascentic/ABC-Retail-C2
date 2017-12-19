package com.example.admin.abcfashions.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.abcfashions.Database.DatabaseHandler;
import com.example.admin.abcfashions.Model.Item;
import com.example.admin.abcfashions.R;
import com.example.admin.abcfashions.Utilities.Paypal.PaypalActivity;
import com.example.admin.abcfashions.WebService.Communicator;
import com.example.admin.abcfashions.WebService.RegUserEvent;
import com.example.admin.abcfashions.WebService.pojo.TransactionEvent;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class CheckOutActivity extends AppCompatActivity {

    private Button pay;
    private TextView items,price;
    private List<Item> itemList;
    private float item_price_total=0;
    Communicator communicator;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(CheckOutActivity.this);
        setContentView(R.layout.activity_check_out);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        communicator = new Communicator();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        pay= findViewById(R.id.pay);
        items= findViewById(R.id.items);
        price= findViewById(R.id.price);

       db=new DatabaseHandler(CheckOutActivity.this);
        itemList=db.getAllItems();

        for(int i=0;i<itemList.size();i++)
        {
          item_price_total=item_price_total+Float.parseFloat(itemList.get(i).getPrice() );
        }

        items.setText(String.valueOf(itemList.size()));
        price.setText(String.valueOf(item_price_total));

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String methods[] = new String[]{"Paypal","Cash"};

                final AlertDialog.Builder builder = new AlertDialog.Builder(CheckOutActivity.this);

                LayoutInflater inflater = CheckOutActivity.this.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.submit, null);
                builder.setView(dialogView);
                Button paypal= dialogView.findViewById(R.id.paypal);
                Button cash= dialogView.findViewById(R.id.cash);
                final AlertDialog b = builder.create();
                b.show();
                paypal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // startSendItemList(itemList);
                        Intent intent=new Intent(CheckOutActivity.this,PaypalActivity.class);
                        intent.putExtra("Amount",price.getText().toString());
                        startActivity(intent);
                        finish();
                      //  startSendResupplyList(true);
                        b.dismiss();
                    }
                });
                cash.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startSendItemList(itemList);
                        finish();
                        b.dismiss();
                    }
                });

            }
        });

    }

    //Web Services
    private void startSendItemList(List<Item> items) {

        TransactionEvent event = new TransactionEvent();
        items = db.getAllItems();
         event.transacton=items;
         communicator.sentItems(event);

    }
    public void onEvent(RegUserEvent regUserEvent) {

        if (regUserEvent.getReg_user().getResult().equals("success")) {
            //  progressDialog.dismiss();
            db.deleteAll();
            Toast.makeText(getBaseContext(), "Transaction Done!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(CheckOutActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            // onSignupFailed();
        }

    }
}
