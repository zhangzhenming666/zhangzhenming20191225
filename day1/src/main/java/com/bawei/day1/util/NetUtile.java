package com.bawei.day1.util;

import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.day1.App;
import com.bawei.day1.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.Map;

/**
 * 时间：2019/12/26
 * 作者：张振明
 * 类的作用：
 */
public class NetUtile {

    private static NetUtile netUtile;
    private final RequestQueue requestQueue;

    private NetUtile() {
        requestQueue = Volley.newRequestQueue(App.app);
    }

    public static NetUtile getInstance() {
        if (netUtile == null){
            synchronized (NetUtile.class){
                if (netUtile == null){
                    netUtile = new NetUtile();
                }
            }
        }
        return netUtile;
    }

    public void getJsonGet(String getUrl,final MyCallBack myCallBack){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, getUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallBack.ongetJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.onError(error);
            }
        });
        requestQueue.add(stringRequest);
    }

    public void getJsonPost(String postUrl, final Map<String,String> map, final MyCallBack myCallBack){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, postUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallBack.ongetJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.onError(error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void getPhoto(String photoUrl, ImageView imageView){
        Glide.with(imageView)
                .load(photoUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(25)))
                .into(imageView);
    }

    public interface MyCallBack{
        void ongetJson(String json);

        void onError(Throwable throwable);
    }
}
