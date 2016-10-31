package com.ottodk.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditText;
    private Button mButton;
    private int mRandom, mEditTextNumber;
    // private boolean mBool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mRandom = generateNumber();
        makeToast(mRandom + "");

        mButton = (Button) findViewById(R.id.guess);
        mButton.setOnClickListener(this);

    }

    /**
     * @return
     */
    private int generateNumber() {
        Random random = new Random();
        return random.nextInt(20);
    }

    private void makeToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        mEditTextNumber = Integer.parseInt(mEditText.getText().toString());
        if (mEditTextNumber == mRandom) {
            makeToast("You guest right");
            mRandom = generateNumber();
        } else if (mRandom<mEditTextNumber) {
            makeToast("Your number is less then this");
        } else if(mRandom>mEditTextNumber){
            makeToast("Your number is more then this");
        }


    }
}
