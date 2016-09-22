package com.example.a.finalproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by A on 8/31/2016.
 */
public class LoginPageActivity extends AppCompatActivity{

    EditText login_username, login_password;
    TextView Register;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        login_username = (EditText)findViewById(R.id.login_username);
        login_password = (EditText) findViewById(R.id.login_password);

        Register = (TextView) findViewById(R.id.register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerDialog(LoginPageActivity.this);
            }
        });
    }


    public void btn_login(View view){

        if (login_username.getText().toString().isEmpty() || login_password.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "Enter Both Username and Password", Toast.LENGTH_LONG).show();
        } else {
            final String username = login_username.getText().toString();
            final String password = login_password.getText().toString();

            Response.Listener<String> responseListner = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        boolean success = jsonObject.getBoolean("success");
                        if (success) {

                            int jid1 = jsonObject.getInt("jid");
                            String name = jsonObject.getString("name");
                            String nationality = jsonObject.getString("nationality");
                            String dob = jsonObject.getString("dob");
                            String mobile = jsonObject.getString("mobile");
                            String gender = jsonObject.getString("gender");
                            String address = jsonObject.getString("address");
                            String email = jsonObject.getString("email");
                            String p_funt_ar = jsonObject.getString("p_funt_ar");
                            String obj = jsonObject.getString("obj");
                            String exp = jsonObject.getString("exp");
                            String  latest_degree = jsonObject.getString("latest_degree");
                            String degree_name = jsonObject.getString("degree_name");
                            String passed_yr = jsonObject.getString("passed_yr");
                            String percent = jsonObject.getString("percent");
                            String institute = jsonObject.getString("institute");
                            String training = jsonObject.getString("training");

                            String jid = Integer.toString(jid1);

                            SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.putInt("id",id);

                            editor.putString("jid",jid);
                            editor.putString("name",name);
                            editor.putString("nationality", nationality);
                            editor.putString("dob", dob);
                            editor.putString("mobile", mobile);
                            editor.putString("gender", gender);
                            editor.putString("address", address);
                            editor.putString("email", email);
                            editor.putString("p_funt_ar", p_funt_ar);
                            editor.putString("obj", obj);
                            editor.putString("exp", exp);
                            editor.putString("latest_degree", latest_degree);
                            editor.putString("degree_name",degree_name);
                            editor.putString("passed_yr", passed_yr);
                            editor.putString("percent", percent);
                            editor.putString("institute", institute);
                            editor.putString("training",training);

                            editor.apply();

                            Intent intent = new Intent(LoginPageActivity.this, HomeActivity.class);

                            LoginPageActivity.this.startActivity(intent);
                            Toast.makeText(getApplicationContext(),"Welcome to Job Search",Toast.LENGTH_LONG).show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginPageActivity.this);
                            builder.setMessage("Login Failed")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            };

            LoginRequest loginRequest = new LoginRequest(username, password, responseListner);
            RequestQueue queue = Volley.newRequestQueue(LoginPageActivity.this);
            queue.add(loginRequest);
        }

    }

    public void registerDialog(Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setTitle("Register");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setItems(R.array.register_menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        startActivity(new Intent(LoginPageActivity.this, JsRegisterActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(LoginPageActivity.this, EmpRegisterActivity.class));
                        break;
                }
            }
        }).setNegativeButton("cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
