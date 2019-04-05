package com.gsanthosh91.payirsampleapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final int PICK_PAYIR_METHOD = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText amountEdt = findViewById(R.id.amount);
        Button payBtn = findViewById(R.id.pay);

        payBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!amountEdt.getText().toString().isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, PayIrWebActivity.class);
                    intent.putExtra("amount", amountEdt.getText().toString());
                    startActivityForResult(intent, PICK_PAYIR_METHOD);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter amount", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_PAYIR_METHOD && resultCode == Activity.RESULT_OK && data != null) {
            String token = data.getStringExtra("token");
            int status = data.getIntExtra("status", 0);

            Toast.makeText(MainActivity.this, "Status " + status, Toast.LENGTH_SHORT).show();
        }
    }
}
