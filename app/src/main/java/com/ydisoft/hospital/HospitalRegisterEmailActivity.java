package com.ydisoft.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HospitalRegisterEmailActivity extends AppCompatActivity {

    private TextView hospitalRegisterMobileClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_register_email);
        hospitalRegisterMobileClick =(TextView)findViewById(R.id.txt_hospital_register_by_mobile);
        hospitalRegisterMobileClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(HospitalRegisterEmailActivity.this, HospitalRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
