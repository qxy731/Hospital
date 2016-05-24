package com.ydisoft.hospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HospitalRegisterActivity extends AppCompatActivity {

    private TextView hospitalRegisterEmailClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_register);
        hospitalRegisterEmailClick =(TextView)findViewById(R.id.txt_hospital_register_email);
        hospitalRegisterEmailClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(HospitalRegisterActivity.this, HospitalRegisterEmailActivity.class);
                startActivity(intent);
            }
        });
    }
}
