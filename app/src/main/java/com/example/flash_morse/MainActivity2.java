package com.example.flash_morse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private Button button_1;
    private Button button_3 = findViewById(R.id.button3);
    private EditText editText = findViewById(R.id.editTextText2);

    //private Button button_2;


    private FlashClass flashClass;
    private char[] english =  {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ',', '.', '?'};
    private String[] morse =  {".-", "-...", "-.-.", "-..", ".", "..-.", "–.", "....", "..",
            ".—", "-.-", ".-..", "–", "-.", "—", ".—.", "–.-", ".-.",
            "...", "-", "..-", "...-", ".–", "-..-", "-.–", "–..", ".—-",
            "..—", "...–", "....-", ".....", "-....", "–...", "—..", "—-.",
            "—–", "–..–", ".-.-.-", "..–.."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
    }
    public void openActivity3(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
    private void init(){
        button_1 = findViewById(R.id.button2);
        flashClass = new FlashClass(this);
    }

    public void onClickFlash(View view){


        /*if (flashClass.isFlash_status()){
            flashClass.Off();
        }
        else{
            flashClass.On();
        }*/


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