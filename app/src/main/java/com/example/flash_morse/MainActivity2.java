package com.example.flash_morse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    private FlashClass flashClass;
    private SoundClass soundClass;
    MediaPlayer tochka, tire;
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
                soundClass.setTochka();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flashClass.Off();
            }
            else if (currentChar == '-') {
                flashClass.On();
                soundClass.setTire();
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
}