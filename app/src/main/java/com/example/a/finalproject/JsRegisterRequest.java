package com.example.a.finalproject;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.a.finalproject.data.DataHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by A on 6/19/2016.
 */
public class JsRegisterRequest extends StringRequest {

//    private static final String REGISTER_REQUEST_URL="http://192.168.1.6/local_volley/js_edit_profile.php";
//    private static final String REGISTER_REQUEST_URL="http://10.0.3.2/local_volley/register.php";

    private Map<String,String> params;


    public JsRegisterRequest(String name, String nationality, String dob, String mobile, String gender, String address, String email,
                             String username, String passwd, String p_funt_ar,Response.Listener<String> listener){
        super(Method.POST, DataHolder.REGISTER_REQUEST_URL,listener,null);

        params=new HashMap<>();
        params.put("NAME",name);
        params.put("NATIONALITY",nationality);
        params.put("DOB",dob);
        params.put("MOBILE",mobile);
        params.put("GENDER",gender);
        params.put("ADDRESS",address);
        params.put("EMAIL",email);
        params.put("USERNAME",username);
        params.put("PASSWORD",passwd);
        params.put("FUNT_AREA",p_funt_ar);

    }


    public JsRegisterRequest(String name, String nationality, String dob, String mobile, String gender, String address, String email,
                             String username, String passwd, String p_funt_ar, String obj, String exp, String latest_degree,
                             String degree_name, String passed_yr, String percent, String institution, String training, Response.Listener<String> listener){
        super(Method.POST, DataHolder.REGISTER_REQUEST_URL2,listener,null);

        params=new HashMap<>();
        params.put("NAME",name);
        params.put("NATIONALITY",nationality);
        params.put("DOB",dob);
        params.put("MOBILE",mobile);
        params.put("GENDER",gender);
        params.put("ADDRESS",address);
        params.put("EMAIL",email);
        params.put("USERNAME",username);
        params.put("PASSWORD",passwd);
        params.put("FUNT_AREA",p_funt_ar);
        params.put("OBJ",obj);
        params.put("EXP",exp);
        params.put("LATEST_DEGREE",latest_degree);
        params.put("DEGREE_NAME",degree_name);
        params.put("PASSED_YR",passed_yr);
        params.put("PERCENT",percent);
        params.put("INSTITUTION",institution);
        params.put("TRAINING",training);

    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
