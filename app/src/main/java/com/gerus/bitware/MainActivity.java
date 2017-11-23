package com.gerus.bitware;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.name)
    AppCompatEditText name;
    @BindView(R.id.firstName)
    AppCompatEditText firstName;
    @BindView(R.id.lastName)
    AppCompatEditText lastName;
    @BindView(R.id.age)
    AppCompatEditText age;
    @BindView(R.id.gender)
    AppCompatEditText gender;
    @BindView(R.id.weight)
    AppCompatEditText weight;
    @BindView(R.id.height)
    AppCompatEditText height;
    @BindView(R.id.submit)
    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


}
