package com.example.a.finalproject;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by A on 6/19/2016.
 */
public class Config2 extends StringRequest{

    public static final String DATA_URL = "http://10.0.3.2/local_volley/getData.php";
//        public static final String DATA_URL="http://192.168.1.6/local_volley/getData.php";


    public static final String KEY_TITLE = "Title";
    public static final String KEY_ORGANIZATION = "Organization";
    public static final String KEY_EXP = "Expiry_date";
    public static final String JSON_ARRAY = "result";


    private Map<String, String> params;

    public Config2(Response.Listener<String> Listener){
        super(Method.POST,DATA_URL, Listener, null);


    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }

}
