package com.example.a.finalproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a.finalproject.R;
import com.example.a.finalproject.utils.JobPostInfo;

import java.util.ArrayList;

/**
 * Created by A on 8/31/2016.
 */
public class JobPostAdapter extends BaseAdapter {

    Context context;
    private LayoutInflater inflater;
    private ArrayList<JobPostInfo> jobPostItemList = new ArrayList<JobPostInfo>();

    public JobPostAdapter(ArrayList<JobPostInfo> jobPostItemList, Context context) {
        this.context = context;

        this.jobPostItemList = jobPostItemList;
    }

    @Override
    public int getCount() {
        return jobPostItemList.size();
    }

    @Override
    public JobPostInfo getItem(int position) {
        return jobPostItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder;
        inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null) {
            view = inflater.inflate(R.layout.job_post_item_layout, viewGroup, false);
            holder = new Holder();
            holder.tvJobTitle = (TextView) view.findViewById(R.id.job_title);
            holder.tvCompanyName = (TextView) view.findViewById(R.id.company_name);
            holder.tvExpiryDate = (TextView) view.findViewById(R.id.expiry_date);
            view.setTag(holder);
        }
        else {
            holder = (Holder) view.getTag();
        }
        JobPostInfo jobPostInfo = getItem(position);
        holder.tvJobTitle.setText(jobPostInfo.getJobTitle());
        holder.tvCompanyName.setText(jobPostInfo.getCompanyName());
        holder.tvExpiryDate.setText(jobPostInfo.getExpiryDate());

        return view;
    }

    public class Holder {
        public TextView tvJobTitle, tvCompanyName, tvExpiryDate;
    }

}
