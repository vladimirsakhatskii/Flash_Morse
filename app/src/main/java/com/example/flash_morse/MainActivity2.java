package com.example.flash_morse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    private FlashClass flashClass;
    Button button_enScript;
    char[] english =  {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ',', '.', '?'};
    String[] morse =  {".-", "-...", "-.-.", "-..", ".", "..-.", "-.", "....", "..",
            ".-", "-.-", ".-..", "-", "-.", "-", ".-.", "-.-", ".-.",
            "...", "-", "..-", "...-", ".-", "-..-", "-.-", "–..", ".--",
            "..-", "...-", "....-", ".....", "-....", "-...", "-..", "--.",
            "--", "-..-", ".-.-.-", "..-.."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    public void init(){
        editText = findViewById(R.id.editTextText);
        button_enScript = findViewById(R.id.button2);
        flashClass = new FlashClass(this);
    }
    public void Enscript_Start(View view){
        String str = editText.getText().toString();
        char[] str_input = str.toCharArray();
        String sum = "";
        for(int i = 0; i < str_input.length; i++){
            for (int j = 0; j < english.length; j++){
                if (english[j] == str_input[i]){
                    sum = sum + morse[j] + " ";}
            }
        }
        for(int k = 0; k < sum.length(); k++) {
            char currentChar = sum.charAt(k);
            if (currentChar == '.') {
                flashClass.On();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flashClass.Off();
            }
            else if (currentChar == '-') {
                flashClass.On();
                try{
                    Thread.sleep(1000);}
                catch (InterruptedException e){
                    e.printStackTrace();}
                flashClass.Off();
            }
            else if (currentChar == ' ') {
                try {
                    Thread.sleep(1000);}
                catch (InterruptedException e) {
                    e.printStackTrace();}
            }
        }
    }
}