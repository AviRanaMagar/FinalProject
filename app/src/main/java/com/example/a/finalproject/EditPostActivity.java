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

public class EditPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_post_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void postJob(View view){
        final EditText job_title =(EditText)findViewById(R.id.et_p_jobtitle);
        final EditText organization =(EditText)findViewById(R.id.et_p_org);
        final EditText category =(EditText)findViewById(R.id.et_p_category);
        final EditText posted_date =(EditText)findViewById(R.id.et_p_postdate);
        final EditText job_type =(EditText)findViewById(R.id.et_p_jobtype);
        final EditText job_level =(EditText)findViewById(R.id.et_p_joblevel);
        final EditText salary =(EditText)findViewById(R.id.et_p_salary);
        final EditText experience =(EditText)findViewById(R.id.et_p_exp);
        final EditText education =(EditText)findViewById(R.id.et_p_edu);
        final EditText vacancy_no =(EditText)findViewById(R.id.et_p_vacancy_no);
        final EditText location =(EditText)findViewById(R.id.et_p_loc);
        final EditText expire_date =(EditText)findViewById(R.id.et_p_expiredate);
        final EditText edu_criteria =(EditText)findViewById(R.id.et_p_edu_criteria);
        final EditText job_spec =(EditText)findViewById(R.id.et_p_job_spec);
        final EditText job_desc =(EditText)findViewById(R.id.et_p_job_desc);


        final String Job_title = job_title.getText().toString();
        final String Organization = organization.getText().toString();
        final String Category = category.getText().toString();
        final String Posted_date = posted_date.getText().toString();
        final String Job_type = job_type.getText().toString();
        final String Job_level = job_level.getText().toString();
        final String Salary = salary.getText().toString();
        final String Experience = experience.getText().toString();
        final String Education = education.getText().toString();
        final String Vacancy_no = vacancy_no.getText().toString();
        final String Location = location.getText().toString();
        final String Expire_date = expire_date.getText().toString();
        final String Edu_criteria = edu_criteria.getText().toString();
        final String Job_spec = job_spec.getText().toString();
        final String Job_desc = job_desc.getText().toString();

            Response.Listener<String> responseListner = new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);

                        Boolean success = jsonObject.getBoolean("success");

                        if (success) {
                            startActivity(new Intent(EditPostActivity.this, JobPostActivity.class));
                            Toast.makeText(getApplicationContext(), "Successfully Posted", Toast.LENGTH_LONG).show();

                        } else if (!success) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(EditPostActivity.this);
                            builder.setMessage("Username Already Exists!!!")
                                    .setNegativeButton("Retry", null)
                                    .create().show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(EditPostActivity.this);
                            builder.setMessage("Not successful")
                                    .setNegativeButton("Retry", null)
                                    .create().show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };


            EditPostRequest editPostRequest = new EditPostRequest(Job_title,Organization,Category,Posted_date,Job_type,
                    Job_level,Salary,Experience,Education,Vacancy_no, Location, Expire_date, Edu_criteria, Job_spec, Job_desc, responseListner);
            RequestQueue queue = Volley.newRequestQueue(EditPostActivity.this);
            queue.add(editPostRequest);

        }

    }


