package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double Currency_Convert,Num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text = (EditText) findViewById(R.id.editTextTextPersonName);
        final RadioButton Euro = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton MexicanPeso = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton CanadianDollars = (RadioButton) findViewById(R.id.radioButton3);
        final TextView result = (TextView) findViewById(R.id.textView2) ;
        Button convert = (Button) findViewById(R.id.button);
        final DecimalFormat tenth= new DecimalFormat("#.#");

        Toast toast = new Toast(MainActivity.this);
        Toast.makeText(MainActivity.this, "alert message", Toast.LENGTH_LONG).show();
        toast.setText("toast Text");

        convert.setOnClickListener(new View.OnClickListener(){
                @Override
        public void onClick(View View){
                    Num = Double.parseDouble(text.getText().toString());

                    if(Euro.isChecked()) {
                        if ((Num < 100000)) {
                            Currency_Convert = Num * 1.16;
                            result.setText(Num + "US= " + tenth.format(Currency_Convert) + "Euro");
                        } else
                            Toast.makeText(MainActivity.this, "US Dollar input should be < $100,00", Toast.LENGTH_LONG).show();
                    }


                    if(MexicanPeso.isChecked()) {
                        if ((Num < 100000)) {
                            Currency_Convert = Num * 0.05;
                            result.setText(Num + "US = " + tenth.format(Currency_Convert) + "Mexican");
                        } else
                            Toast.makeText(MainActivity.this, "US yasdasdfasdf Dollar input should be < $100,000", Toast.LENGTH_LONG).show();

                    }

                    if(CanadianDollars.isChecked()) {
                        if ((Num < 100000)) {
                            Currency_Convert = Num * 0.79;
                            result.setText(Num + "US = " + tenth.format(Currency_Convert) + "Canadian");
                        } else
                            Toast.makeText(MainActivity.this, "US Dollar asdfasdfasdafasdf input should be < $100,000", Toast.LENGTH_LONG).show();

                    }


        }
    });

    }
}