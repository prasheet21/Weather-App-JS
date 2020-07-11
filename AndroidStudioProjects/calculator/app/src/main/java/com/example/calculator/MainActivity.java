package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView view1 , view2 , ansView ;
    Button sum , min , pro , div , clr ;
    EditText first , second ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        view1 = (TextView) findViewById(R.id.t1) ;
        view2 = (TextView) findViewById(R.id.t2) ;
        first = (EditText)findViewById(R.id.val1) ;
        second = (EditText)findViewById(R.id.val2) ;
        sum = (Button)findViewById(R.id.add);
        min = (Button)findViewById(R.id.sub);
        pro = (Button)findViewById(R.id.mul);
        div = (Button)findViewById(R.id.div);
        clr = (Button)findViewById(R.id.clear) ;
        ansView = (TextView)findViewById(R.id.answer) ;
        ansView.setTextColor(Color.BLUE);
        ansView.setTextSize((float) 30.4d);
    }

    public void doAdd(View view)
    {

        if(first.getText().length() == 0)
            first.setError("Field cannot be left blank.");

        else if(second.getText().length() == 0)
            second.setError("Field cannot be left blank") ;
        else
        {
            String partVar1 = first.getText().toString() ;
            float var1 = Float.parseFloat(partVar1) ;
            String partVar2 = second.getText().toString() ;
            float var2 = Float.parseFloat(partVar2) ;
            try{ ansView.setText("Answer is : " +(var1 + var2));}
            catch (Exception e){Toast.makeText(this , "Value is non-numeric" , Toast.LENGTH_SHORT).show() ;}

        }

    }

    public void doSub(View view)
    {

        if(first.getText().length() == 0)
            first.setError("Field cannot be left blank.");

        else if(second.getText().length() == 0)
            second.setError("Field cannot be left blank") ;
        else {
            String partVar1 = first.getText().toString();
            float var1 = Float.parseFloat(partVar1);
            String partVar2 = second.getText().toString();
            float var2 = Float.parseFloat(partVar2);
            try{ansView.setText("Answer is : " + (var1 - var2));}
            catch (Exception e){Toast.makeText(this , "Value is non-numeric" , Toast.LENGTH_SHORT).show();}
        }
    }

    public void doMul(View view)
    {
        if(first.getText().length() == 0)
            first.setError("Field cannot be left blank.");

        else if(second.getText().length() == 0)
            second.setError("Field cannot be left blank") ;
        else {
            String partVar1 = first.getText().toString();
            float var1 = Float.parseFloat(partVar1);
            String partVar2 = second.getText().toString();
            float var2 = Float.parseFloat(partVar2);
            try{ansView.setText("Answer is : " + (var1 * var2));}
            catch (Exception e){Toast.makeText(this , "Value is non-numeric" , Toast.LENGTH_SHORT).show();}
        }
    }

    public void doDiv(View view)
    {
        if(first.getText().length() == 0)
            first.setError("Field cannot be left blank.");

        else if(second.getText().length() == 0)
            second.setError("Field cannot be left blank") ;
        else {
            String partVar1 = first.getText().toString();
            float var1 = Float.parseFloat(partVar1);
            String partVar2 = second.getText().toString();
            float var2 = Float.parseFloat(partVar2);
            try{ansView.setText("Answer is : " + (var1 / var2));}
            catch (Exception e){Toast.makeText(this , "Value is non-numeric" , Toast.LENGTH_SHORT).show();}
        }
    }

    public void onClear(View view)
    {
        first.setText("");
        second.setText("");
        ansView.setText("");
        Toast.makeText(this , "Clear Pressed" , Toast.LENGTH_SHORT).show() ;
    }
}
