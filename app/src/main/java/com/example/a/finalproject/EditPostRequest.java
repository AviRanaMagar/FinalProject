package com.example.a.finalproject;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.a.finalproject.data.DataHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by A on 6/19/2016.
 */
public class EditPostRequest extends StringRequest {

//    private static final String REGISTER_REQUEST_URL="http://192.168.1.6/local_volley/js_edit_profile.php";
//    private static final String REGISTER_REQUEST_URL="http://10.0.3.2/local_volley/register.php";

    private Map<String,String> params;

    public EditPostRequest(String job_title, String organization, String category, String posted_date, String job_type, String job_level, String salary,
                           String experience, String education, String vacancy_no, String location, String expire_date, String edu_criteria,
                           String job_spec, String job_desc, Response.Listener<String> listener){
        super(Method.POST, DataHolder.Job_Post_URL,listener,null);

        params=new HashMap<>();
        params.put("JOB_TITLE",job_title);
        params.put("ORGANIZATION",organization);
        params.put("CATEGORY",category);
        params.put("POSTED_DATE",posted_date);
        params.put("JOB_TYPE",job_type);
        params.put("JOB_LEVEL",job_level);
        params.put("SALARY",salary);
        params.put("EXPERIENCE",experience);
        params.put("EDUCATION",education);
        params.put("VACANCY_NO",vacancy_no);
        params.put("LOCATION",location);
        params.put("EXPIRE_DATE",expire_date);
        params.put("EDU_CRITERIA",edu_criteria);
        params.put("JOB_SPEC",job_spec);
        params.put("JOB_DESC",job_desc);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
