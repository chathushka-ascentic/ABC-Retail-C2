package com.example.admin.abcfashions.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.abcfashions.Database.DatabaseHandler;
import com.example.admin.abcfashions.Model.Item;
import com.example.admin.abcfashions.R;
import com.example.admin.abcfashions.Utilities.QRCode.BarcodeReader;

public class AddItemActivity extends AppCompatActivity {

    private Button qrCodeOpen,add;
    private EditText name,price,quantity;
    String Result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        qrCodeOpen= findViewById(R.id.qrcode);
        add= findViewById(R.id.add);
        name= findViewById(R.id.name);
        price= findViewById(R.id.price);
        quantity= findViewById(R.id.quantity);

       add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Item item=new Item(name.getText().toString(),price.getText().toString(),quantity.getText().toString());
                DatabaseHandler db=new DatabaseHandler(AddItemActivity.this);
                db.addItem(item);
                Intent intent=new Intent(AddItemActivity.this,ItemActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(getBaseContext(), "Item Added", Toast.LENGTH_LONG).show();
                Log.e("test","Add");


            }
        });

        qrCodeOpen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(AddItemActivity.this,BarcodeReader.class);
                startActivity(intent);
                finish();
                Log.e("test","Add");


            }
        });

        String value=getIntent().getStringExtra("Result");
        if(value!=null)
        {
            Result=value;
        }


        if(!Result.equals(""))
        {
            String lines[] = Result.split("\\r?\\n");

            name.setText(lines[0]);
            price.setText(lines[1]);
            quantity.setText(lines[2]);
        }



    }

}
