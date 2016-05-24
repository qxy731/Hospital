package com.ydisoft.hospital;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.ydisoft.hospital.util.CommonResult;
import com.ydisoft.hospital.util.Constants;
import com.ydisoft.hospital.util.HttpUtils;
import com.ydisoft.hospital.util.ValidtionUtil;

import java.util.HashMap;
import java.util.Map;

public class CommonLoginActivity extends AppCompatActivity {

    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnSignIn;
    private TextView txtForgetPassword;
    private TextView txtUserRegister;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_login);
        dialog = new ProgressDialog(this);
        dialog.setTitle("提示");
        dialog.setMessage("正在登录，请稍候...");
        txtUsername = (EditText)findViewById(R.id.txt_username);
        txtPassword = (EditText)findViewById(R.id.txt_password);
        btnSignIn = (Button)findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //btnSignIn.setBackgroundColor(808080);
                attemptLogin();
            }
        });
        txtForgetPassword = (TextView)findViewById(R.id.txt_forgot_password);
        txtForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(CommonLoginActivity.this, CommonForgotPassowdActivity.class);
                startActivity(intent);
            }
        });
        txtUserRegister = (TextView)findViewById(R.id.txt_user_register);
        txtUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(CommonLoginActivity.this, CommonRegisterPreviewActivity.class);
                startActivity(intent);
            }
        });
    }

    class LoginAsyncTask extends AsyncTask<Map<String,String>,Void,CommonResult>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected  CommonResult doInBackground(Map<String,String>... params){
            Map<String,String> map = params[0];
            String url = map.get("path").toString();
            Map<String,Object> params2 = new HashMap<String,Object>();
            params2.put("username",map.get("username"));
            params2.put("password",map.get("password"));
            //CommonResult result = HttpUtils.doPostMethod(url,params2);
            CommonResult result = new CommonResult();
            result.setCode(CommonResult.CODE_NORMAL);
            result.setMessage("操作成功");
            return result;
        }

        @Override
        protected void onPostExecute(CommonResult s) {
            super.onPostExecute(s);
            dialog.dismiss();
        }
    }

    private void attemptLogin(){
        String username = txtUsername.getText().toString().trim();
        System.out.println(username);
        if(ValidtionUtil.validMobile(username)){//验证用户名，判断是否手机号

        }else if(ValidtionUtil.validEmail(username)){//验证用户名，判断是否邮箱

        }else{
            Toast.makeText(CommonLoginActivity.this,"手机号或邮箱格式不对，请重新登录。",Toast.LENGTH_SHORT).show();
            return;
        }
        //验证密码长度是否够
        String password = txtPassword.getText().toString().trim();
        System.out.println("-->>"+password);
        if(ValidtionUtil.validStringLength(password)){//验证密码长度是否够

        }else{
            Toast.makeText(CommonLoginActivity.this,"用户密码长度不够，请重新登录。",Toast.LENGTH_SHORT).show();
            return;
        }
        //获取用户名，密码，验证登录用户是否存在
        String path= Constants.WEB_ROOT+"/user/attemptLogin";
        Map params = new HashMap();
        params.put("username",username);
        params.put("password",password);
        params.put("path",path); params.put("path",path);
        try {
            CommonResult commonResult = (CommonResult) new LoginAsyncTask().execute(params).get();
            if(commonResult!=null) {
                System.out.print("-->>" + commonResult);
                if (commonResult.getCode() == CommonResult.CODE_NORMAL) {
                    //登录成功，跳转主页面
                    Intent intent = new Intent();
                    if(username.equals("JAVA")) {
                        intent.setClass(CommonLoginActivity.this, EngineerMainActivity.class);
                    }else{
                        intent.setClass(CommonLoginActivity.this, HospitalMainActivity.class);
                    }
                    startActivity(intent);
                } else {
                    String message = commonResult.getMessage();
                    Toast.makeText(CommonLoginActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(CommonLoginActivity.this, "此用户不存在", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.e(CommonLoginActivity.class.getName(),e.getMessage());
        }
    }


}