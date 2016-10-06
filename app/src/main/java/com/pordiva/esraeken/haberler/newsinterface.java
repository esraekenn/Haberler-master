package com.pordiva.esraeken.haberler;

import com.pordiva.esraeken.haberler.model.Response;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by esraeken on 05/09/16.
 */
public interface newsinterface
{
    @GET("/{paging}")
    void getNewsList(@Path("paging") int paging, Callback<Response> response);
}
