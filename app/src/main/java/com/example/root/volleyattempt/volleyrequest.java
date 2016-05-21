package com.example.root.volleyattempt;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Objects;

/**
 * Created by root on 21/5/16.
 */
public class volleyrequest {
    public static volleyrequest mInstance;
    public  static RequestQueue mRequestQueue;
    public static final String TAG = "DEFAULT";


    public volleyrequest(){
        mInstance=this;
        System.out.println("onCreate onCreate called for volleyrequest");
    }

   /* @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate onCreate called for volleyrequest");
        mInstance = this;
    }*/
    public static synchronized volleyrequest getInstance(){
        System.out.println("mInstance"+String.valueOf(mInstance));
//            mInstance = this;
        return mInstance;
    }
    public RequestQueue getRequestQueue(Context c){
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(c);
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQue(Request<T> request, Context c,String tag){
        request.setTag(TextUtils.isEmpty(tag) ? TAG:tag);
        getRequestQueue(c).add(request);
    }
    public <T> void addToRequestQue(Request<T> request,Context c){
        request.setTag(TAG);
        getRequestQueue(c).add(request);
    }
    public void CancelAlllRequest(Objects tag){
        if(mRequestQueue != null){
            mRequestQueue.cancelAll(tag);
        }
    }
}