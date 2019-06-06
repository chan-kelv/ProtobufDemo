package com.mastercard.nudata.protodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.protobuf.ByteString;
import com.mastercard.protobuf.UserProto;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_generate_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProto.Person person = User.generatePerson();
                ByteString personByte = User.generateByte(person);
                Log.d("User", Arrays.toString(personByte.toByteArray()));
            }
        });
    }
}
