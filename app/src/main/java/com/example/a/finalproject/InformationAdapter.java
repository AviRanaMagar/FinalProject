package com.example.a.finalproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a.finalproject.utils.JobPostInfo;

import java.util.ArrayList;

/**
 * Created by A on 6/20/2016.
 */
public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InformationViewHolder> {

    ArrayList<JobPostInfo> informations=new ArrayList<JobPostInfo>();

    Context ctx;
    public InformationAdapter(ArrayList<JobPostInfo> informations, Context ctx){
        this.ctx=ctx;
        this.informations=informations;
    }


    @Override
    public InformationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.job_post_item_layout,parent,false);
        InformationViewHolder informationViewHolder=new InformationViewHolder(view,ctx,informations);
        return informationViewHolder;

    }

    @Override
    public void onBindViewHolder(InformationViewHolder holder, int position) {

        JobPostInfo info=informations.get(position);
        holder.title.setText(info.getJobTitle());
        holder.organization.setText(info.getCompanyName());
        holder.expiry_date.setText(info.getExpiryDate());

    }

    @Override
    public int getItemCount() {
        return informations.size();
    }

    public static class InformationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView title;
        public TextView organization;
        public TextView expiry_date;
        ArrayList<JobPostInfo> informations=new ArrayList<JobPostInfo>();
        Context ctx;

        public InformationViewHolder(View itemView, Context ctx, ArrayList<JobPostInfo> informations) {
            super(itemView);

            this.ctx=ctx;
            this.informations=informations;
            itemView.setOnClickListener(this);
            title=(TextView)itemView.findViewById(R.id.job_title);
            organization=(TextView)itemView.findViewById(R.id.company_name);
            expiry_date=(TextView)itemView.findViewById(R.id.expiry_date);
        }

        @Override
        public void onClick(View v) {
//
//        int position=getAdapterPosition();
//        JobPostInfo information=this.informations.get(position);
//        Intent intent=new Intent(this.ctx,Details.class);
//        intent.putExtra("Title",information.getJobTitle());
//        intent.putExtra("Organization",information.getCompanyName());
//        intent.putExtra("Expiry_date",information.getExpiryDate());
//        this.ctx.startActivity(intent);

        }
    }
}
