package com.tutoriales.simplemvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber,etExponent;
    private Button btnCalculate;
    private TextView tvResult;
    private NumberViewModel numberViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setView(){
        try{
            etNumber = findViewById(R.id.etNumber);
            etExponent = findViewById(R.id.etExponent);
            btnCalculate = findViewById(R.id.btnCalculate);
            tvResult = findViewById(R.id.tvResult);
            numberViewModel = new ViewModelProvider(this).get(NumberViewModel.class);

            final Observer<Double> observer = new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    tvResult.setText(String.valueOf(aDouble));
                }
            };

            numberViewModel.getResult().observe(this,observer);

            btnCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double number=Integer.parseInt(etNumber.getText().toString());
                    double exponent=Integer.parseInt(etExponent.getText().toString());
                    numberViewModel.Elevate(number,exponent);

                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}