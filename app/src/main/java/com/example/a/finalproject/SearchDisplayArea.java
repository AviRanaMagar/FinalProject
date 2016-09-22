package com.example.a.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.a.finalproject.adapter.JobPostAdapter;
import com.example.a.finalproject.utils.JobPostInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchDisplayArea extends AppCompatActivity {
    public ListView recyclerView;
    String title, organization, expiry_date;
    int id;

    ArrayList<JobPostInfo> list=new ArrayList<JobPostInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_post_fragment);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        recyclerView=(ListView) findViewById(R.id.recyclerView2);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }

    public void Home(View view){
        startActivity(new Intent(SearchDisplayArea.this, HomeActivity.class));
    }

    public void getData() {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);

            }
        };

        Config2 getData = new Config2(responseListener);
        RequestQueue queue = Volley.newRequestQueue(SearchDisplayArea.this);
        queue.add(getData);
    }


    private void showJSON(String response) {

        try {

            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config2.JSON_ARRAY);
            for (int i = 0; i < result.length(); i++) {

                JSONObject collegeData = result.getJSONObject(i);

                title = collegeData.getString(Config2.KEY_TITLE);
                organization = collegeData.getString(Config2.KEY_ORGANIZATION);
                expiry_date = collegeData.getString(Config2.KEY_EXP);

                JobPostInfo information=new JobPostInfo(title, organization, expiry_date);
                list.add(information);

                JobPostAdapter informationAdapter = new JobPostAdapter(list,this);
                recyclerView.setAdapter(informationAdapter);


//                Toast.makeText(SearchDisplayArea.this, "Title: "+title+"Organization: "+organization+ "Expiry_date: " + expiry_date,Toast.LENGTH_SHORT).show();

            }




        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/
        if (id == R.id.edit_profile) {
            Intent i = new Intent(SearchDisplayArea.this, JsEditProfileActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
