package com.example.flash_morse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void openInfo(View view){
        showInfo("Welcome to the Morse Flashlight!\n" +
                "Morse code is a method of sign coding in which letters of the alphabet, numbers,\n" +
                "punctuation marks and other symbols are represented as sequences of short and long signals called dots and dashes.\n" +
                "This application is designed to encode ordinary words into Morse code through the flash or speaker of your phone, \n" +
                "as well as decrypt messages from another user Julia.\n" +
                "Have a good use!");
    }
    public void showInfo(String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Description")
                .setCancelable(false)
                .setMessage(text)
                .setPositiveButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}