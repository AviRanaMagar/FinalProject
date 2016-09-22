package com.example.a.finalproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class EmpRegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_register_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void empRegister(View view){
        final EditText name =(EditText)findViewById(R.id.et_org_name);
        final EditText type =(EditText)findViewById(R.id.et_org_type);
        final EditText ownership =(EditText)findViewById(R.id.et_ownership);
        final EditText head =(EditText)findViewById(R.id.et_org_head);
        final EditText designation =(EditText)findViewById(R.id.et_designation);
        final EditText address =(EditText)findViewById(R.id.et_o_address);
        final EditText phone =(EditText)findViewById(R.id.et_e_phone);
        final EditText email =(EditText)findViewById(R.id.et_e_email);
        final EditText website =(EditText)findViewById(R.id.et_website);
        final EditText username =(EditText)findViewById(R.id.et_e_username);
        final EditText password =(EditText)findViewById(R.id.et_e_password);


        final String OName = name.getText().toString();
        final String OType = type.getText().toString();
        final String Ownership = ownership.getText().toString();
        final String OHead = head.getText().toString();
        final String Designation = designation.getText().toString();
        final String OAddress = address.getText().toString();
        final String OPhone = phone.getText().toString();
        final String OEmail = email.getText().toString();
        final String Website = website.getText().toString();
        final String Username = username.getText().toString();
        final String Password = password.getText().toString();

            Response.Listener<String> responseListner = new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);

                        Boolean success = jsonObject.getBoolean("success");

                        if (success) {
                            startActivity(new Intent(EmpRegisterActivity.this, LoginPageActivity.class));
                            Toast.makeText(getApplicationContext(), "Registration Successful, " +
                                    "Please Login", Toast.LENGTH_LONG).show();

                        } else if (!success) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(EmpRegisterActivity.this);
                            builder.setMessage("Username Already Exists!!!")
                                    .setNegativeButton("Retry", null)
                                    .create().show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(EmpRegisterActivity.this);
                            builder.setMessage("Registration Failed")
                                    .setNegativeButton("Retry", null)
                                    .create().show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };


            EmpRegisterRequest registerRequest = new EmpRegisterRequest(OName,OType,Ownership,OHead,Designation,
                    OAddress,OPhone,OEmail,Website,Username,Password,responseListner);
            RequestQueue queue = Volley.newRequestQueue(EmpRegisterActivity.this);
            queue.add(registerRequest);

        }

    }


