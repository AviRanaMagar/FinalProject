package com.example.a.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a.finalproject.adapter.JobPostAdapter;
import com.example.a.finalproject.utils.JobPostInfo;

import java.util.ArrayList;

/**
 * Created by A on 8/31/2016.
 */
public class JobPostActivity extends AppCompatActivity{



    private ListView jobPostListView;
    private ArrayList<JobPostInfo> jobPostList = new ArrayList<>();
    private JobPostAdapter jobPostAdapter;
    private TextView jobTitle, companyName, expiryDate;
    String[] items = {"kkfkfkfk", "fdjfdkjf","fdkfjdf"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_post_fragment);

        init();

        //jobPostAdapter = new JobPostAdapter(context, jobPostList);
        jobPostListView.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, items));

        listeners();
    }

    public void init() {
        jobPostListView = (ListView) findViewById(R.id.recyclerView2);
        jobTitle = (TextView) findViewById(R.id.job_title);
        companyName = (TextView) findViewById(R.id.company_name);
        expiryDate = (TextView) findViewById(R.id.expiry_date);
    }

    public void listeners() {
        jobPostListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(JobPostActivity.this, JobPostDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.login) {
            Intent i = new Intent(this, LoginPageActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
