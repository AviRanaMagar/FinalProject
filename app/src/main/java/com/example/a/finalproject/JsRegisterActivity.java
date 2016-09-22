package com.example.a.finalproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class JsRegisterActivity extends AppCompatActivity {

    static String gender = "";
    public void gender(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.female:
                if (checked)
                    gender = "Female";
                break;
            case R.id.male:
                if (checked)
                    gender = "Male";
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joobseeker_register_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void jRegister(View view){
        final EditText name =(EditText)findViewById(R.id.et_name);
        final EditText nationality =(EditText)findViewById(R.id.et_nationality);
        final EditText dob =(EditText)findViewById(R.id.et_dob);
        final EditText mobile =(EditText)findViewById(R.id.et_mobile);
        final EditText email =(EditText)findViewById(R.id.et_email);
        final EditText address =(EditText)findViewById(R.id.et_address);
        final EditText username =(EditText)findViewById(R.id.et_username);
        final EditText password =(EditText)findViewById(R.id.et_password);
        final EditText p_funct_ar =(EditText)findViewById(R.id.et_functional_area);


        final String Name = name.getText().toString();
        final String Nationality = nationality.getText().toString();
        final String DOB = dob.getText().toString();
        final String Mobile = mobile.getText().toString();
        final String Email = email.getText().toString();
        final String Address = address.getText().toString();
        final String Username = username.getText().toString();
        final String Password = password.getText().toString();
        final String P_funct_ar = p_funct_ar.getText().toString();
        final String Obj = "";
        final String Exp = "";
        final String Latest_degree = "";
        final String Degree_name = "";
        final String Passed_yr = "";
        final String Percent = "";
        final String Institution = "";
        final String Training = "";

//        boolean a=fname.isEmpty();
//        boolean b=fname.matches("[a-zA-Z]+");
//        boolean c=lname.isEmpty();
//        boolean d=lname.matches("[a-zA-Z]+");
//        boolean e=username.matches("[a-zA-Z]+([0-9])*");
//        boolean f=password.length()<6;
//        boolean g=contact.isEmpty();
//        boolean h=email.isEmpty();
//        boolean i=email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//
//        if (a) {
//            F_name.requestFocus();
//            F_name.setError("* Required");
//        } else if (!b) {
//            F_name.requestFocus();
//            F_name.setError("Enter Only Alphabetical Characters");
//        } else if (c) {
//            L_name.requestFocus();
//            L_name.setError("* Required");
//        } else if (!d) {
//            L_name.requestFocus();
//            L_name.setError("Enter Only Alphabetical Characters");
//        } else if (!e) {
//            Username.requestFocus();
//            Username.setError("Invalid Username");
//        } else if (f) {
//            Password.requestFocus();
//            Password.setError("Enter atleast 6 characters");
//        } else if (g) {
//            Contact.requestFocus();
//            Contact.setError("* Required");
//        } else if (h) {
//            Email.requestFocus();
//            Email.setError("* Required");
//        } else if (!i) {
//            Email.requestFocus();
//            Email.setError("Invalid Email id");
//        }

//        else {
            Response.Listener<String> responseListner = new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);

                        Boolean success = jsonObject.getBoolean("success");

                        if (success) {
                            startActivity(new Intent(JsRegisterActivity.this, LoginPageActivity.class));
                            Toast.makeText(getApplicationContext(), "Registration Successful, " +
                                    "Please Login", Toast.LENGTH_LONG).show();

                        } else if (!success) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(JsRegisterActivity.this);
                            builder.setMessage("Username Already Exists!!!")
                                    .setNegativeButton("Retry", null)
                                    .create().show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(JsRegisterActivity.this);
                            builder.setMessage("Registration Failed")
                                    .setNegativeButton("Retry", null)
                                    .create().show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };


            JsRegisterRequest registerRequest = new JsRegisterRequest(Name,Nationality,DOB,Mobile,gender,
                    Email,Address,Username,Password,P_funct_ar, responseListner);
            RequestQueue queue = Volley.newRequestQueue(JsRegisterActivity.this);
            queue.add(registerRequest);

        }

    }


