package com.example.skorp.silnia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigInteger number = new BigInteger(editText.getText().toString());
                BigInteger factoried = factoried(number);
                String result = String.format("Factorial of %d is equal to %d", number, factoried);
                textView.setText(result);
            }
        });
    }

    private BigInteger factoried(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) == -1){
            return BigInteger.ONE;
        } else {
            return n.multiply(factoried(n.subtract(BigInteger.ONE)));
        }
    }
}
