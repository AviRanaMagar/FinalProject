package com.example.a.finalproject.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a.finalproject.JobPostDetailActivity;
import com.example.a.finalproject.R;
import com.example.a.finalproject.adapter.JobPostAdapter;
import com.example.a.finalproject.utils.JobPostInfo;

import java.util.ArrayList;

/**
 * Created by A on 8/31/2016.
 */
public class JobPostFragment extends Fragment {

    private Context context;
    private ListView jobPostListView;
    private ArrayList<JobPostInfo> jobPostList = new ArrayList<>();
    private JobPostAdapter jobPostAdapter;
    private TextView jobTitle, companyName, expiryDate;
    String[] items = {"kkfkfkfk", "fdjfdkjf","fdkfjdf"};
    View fragmentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.job_post_fragment,container, false);

        init();

        //jobPostAdapter = new JobPostAdapter(context, jobPostList);
        jobPostListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, items));

        listeners();

        return fragmentView;
    }

    public void init() {
        jobPostListView = (ListView) fragmentView.findViewById(R.id.recyclerView2);
        jobTitle = (TextView) fragmentView.findViewById(R.id.job_title);
        companyName = (TextView) fragmentView.findViewById(R.id.company_name);
        expiryDate = (TextView) fragmentView.findViewById(R.id.expiry_date);
    }

    public void listeners() {
        jobPostListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getActivity(), JobPostDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getActivity().getMenuInflater().inflate(R.menu.home, menu);
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
            Intent i = new Intent(getActivity(), HomePageActivity.class);
            startActivity(i);
            return true;
        }*/

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

    public void onBackPressed() {
        getActivity().onBackPressed();
    }

}
