package com.bawei.zhangzhenming20191225.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.zhangzhenming20191225.App;
import com.bawei.zhangzhenming20191225.R;
import com.bawei.zhangzhenming20191225.model.bean.Bean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.Map;

/**
 * 时间：2019/12/25
 * 作者：张振明
 * 类的作用：
 */
public class NetUtil {
    private static NetUtil netUtil;
    private final RequestQueue requestQueue;

    private NetUtil() {
        requestQueue = Volley.newRequestQueue(App.app);
    }

    public static NetUtil getInstance() {
        if (netUtil == null) {
            synchronized (NetUtil.class) {
                if (netUtil == null) {
                    netUtil = new NetUtil();
                }
            }
        }
        return netUtil;
    }

    public void getJsonGet(String htt, final MyCallback myCallback) {
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, htt, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallback.getJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallback.Eroor(error);
            }
        });
        requestQueue.add(stringRequest);
    }

    public void getPhoto(String utll, final Map<String, String> map, final MyCallback myCallback) {
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, utll, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallback.getJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallback.Eroor(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    public boolean hasNet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isWifi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMobile(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        } else {
            return false;
        }
    }

    public void getPhoto(String photoUil, ImageView imageView) {
        Glide.with(imageView)
                .load(photoUil)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }

    public interface MyCallback {
        void getJson(String json);

        void Eroor(Throwable throwable);
    }
}
