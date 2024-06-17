package com.example.flash_morse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    private FlashClass flashClass;
    private SoundClass soundClass;
    MediaPlayer tire,tochka;
    ImageButton button_enScript;
    char[] english =  {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ',', '.', '?', ':', '=', '-', '(', ')', '"', '/', '@'};
    String[] morse =  {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".--", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "–-..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "-..--", ".-.-.-", "..--..", "---...", "-...-", "-....-", "-.--.", "-.--.-",
            ".-..-.", "-..-.", ".--.-."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    public void init(){
        editText = findViewById(R.id.editTextText);
        button_enScript = findViewById(R.id.imageButton2);
        flashClass = new FlashClass(this);
        soundClass = new SoundClass(this);
        tire = MediaPlayer.create(this,R.raw.tire);
        tochka = MediaPlayer.create(this, R.raw.tochka);
    }
    public void onClick2(View view){
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
    public void Enscript_Start(View view){
        String str = editText.getText().toString();
        String lower = str.toLowerCase();
        char[] str_input = lower.toCharArray();
        String sum = "";
        for(int i = 0; i < str_input.length; i++){
            for (int j = 0; j < english.length; j++){
                if (english[j] == str_input[i]){
                    sum = sum + morse[j] + " ";}
            }
        }
        ProgressDialog progressDialog = ProgressDialog.show(this, "dialog title",
                "dialog message", false);
        for(int k = 0; k < sum.length(); k++) {
            char currentChar = sum.charAt(k);
            if (currentChar == '.') {
                flashClass.On();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flashClass.Off();
            }
            else if (currentChar == '-') {
                flashClass.On();
                try{
                    Thread.sleep(500);}
                catch (InterruptedException e){
                    e.printStackTrace();}
                flashClass.Off();
            }
            else if (currentChar == ' ') {
                try {
                    Thread.sleep(500);}
                catch (InterruptedException e) {
                    e.printStackTrace();}
            }
        }
        editText.setText("Complied!");
        progressDialog.dismiss();
    }
    public void Masha(View view){
        String str = editText.getText().toString();
        String lower = str.toLowerCase();
        char[] str_input = lower.toCharArray();
        String sum = "";
        for(int i = 0; i < str_input.length; i++){
            for (int j = 0; j < english.length; j++){
                if (english[j] == str_input[i]){
                    sum = sum + morse[j] + " ";}
            }
        }
        ProgressDialog progressDialog = ProgressDialog.show(this, "dialog title",
                "dialog message", false);
        for(int k = 0; k < sum.length(); k++) {
            char currentChar = sum.charAt(k);
            if (currentChar == '.') {
                soundClass.SoundPlay(tire);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (currentChar == '-') {
                soundClass.SoundPlay(tochka);
                try{
                    Thread.sleep(500);}
                catch (InterruptedException e){
                    e.printStackTrace();}
            }
            else if (currentChar == ' ') {
                try {
                    Thread.sleep(500);}
                catch (InterruptedException e) {
                    e.printStackTrace();}
            }
        }
        editText.setText("Complied!");
        progressDialog.dismiss();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
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