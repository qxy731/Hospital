package com.ydisoft.hospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CommonRegisterPreviewActivity extends AppCompatActivity {

    private Button btn_hospital_button;
    private Button btn_engineer_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_register_preview);
        btn_hospital_button = (Button)findViewById(R.id.btn_hospital_button);
        btn_hospital_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(CommonRegisterPreviewActivity.this, HospitalRegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_engineer_button = (Button)findViewById(R.id.btn_engineer_button);
        btn_engineer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(CommonRegisterPreviewActivity.this, EngineerRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
