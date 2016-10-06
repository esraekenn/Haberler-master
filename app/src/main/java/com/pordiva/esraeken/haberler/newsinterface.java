package com.pordiva.esraeken.haberler;

import com.pordiva.esraeken.haberler.model.Response;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by esraeken on 05/09/16.
 */
public interface newsinterface
{
    @GET("/stories.json")
    void getNewsList(@Query("paging") int paging, @Query("category") int categoryName, Callback<Response> response);
}
