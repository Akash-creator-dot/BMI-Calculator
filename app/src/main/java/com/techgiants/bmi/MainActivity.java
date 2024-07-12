package com.techgiants.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtHeightIn,edtHeightFt,edtWeight;
        Button bntCalculate;
        TextView textResult;
        LinearLayout llmain;
        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        bntCalculate = findViewById(R.id.bntCalculate);
        textResult=findViewById(R.id.textResult);
        llmain=findViewById(R.id.llmain);
        bntCalculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
            int wt=Integer.parseInt(edtWeight.getText().toString());
            int htF=Integer.parseInt(edtHeightFt.getText().toString());
            int htI=Integer.parseInt(edtHeightIn.getText().toString());
            int totalIn=htF*12+htI;
            double mtr=totalIn*0.0254;
            double bmi=wt/(mtr*mtr);
            if(bmi>25){
                textResult.setText("You're OverWeight");
                llmain.setBackgroundColor(getResources().getColor(R.color.OverWeight));
            }else if(bmi<18){
                textResult.setText("You're UnderWeight");
                llmain.setBackgroundColor(getResources().getColor(R.color.UnderWeight));
            }else{
                textResult.setText("You're Healthy");
                llmain.setBackgroundColor(getResources().getColor(R.color.Healthy));
            }
            }
        });
    }
}