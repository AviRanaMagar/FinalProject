package com.example.a.finalproject;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.a.finalproject.data.DataHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by A on 6/19/2016.
 */
public class EmpRegisterRequest extends StringRequest {

//    private static final String REGISTER_REQUEST_URL="http://192.168.1.6/local_volley/emp_register.php";
//    private static final String REGISTER_REQUEST_URL="http://10.0.3.2/local_volley/register.php";

    private Map<String,String> params;

    public EmpRegisterRequest(String name, String type, String ownership, String org_head, String degisnation, String address,
                              String phone,String email, String website, String username, String password, Response.Listener<String> listener){
        super(Method.POST, DataHolder.REGISTER_REQUEST_URL,listener,null);

        params=new HashMap<>();
        params.put("ONAME",name);
        params.put("OTYPE",type);
        params.put("OWNERSHIP",ownership);
        params.put("OHEAD",org_head);
        params.put("DESIGNATION",degisnation);
        params.put("OADDRESS",address);
        params.put("OPHONE",phone);
        params.put("OEMAIL",email);
        params.put("WEBSITE",website);
        params.put("USERNAME",username);
        params.put("PASSWORD",password);

    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
