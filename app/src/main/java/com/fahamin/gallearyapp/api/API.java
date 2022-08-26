package com.fahamin.gallearyapp.api;


import com.fahamin.gallearyapp.model.UnsplashModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("photos")
    Call<List<UnsplashModel>> getImageList(@Query("client_id") String cid);

    //user page section
    @GET("photos")
    Call<List<UnsplashModel>> getImageListWithPage(@Query("client_id") String cid,@Query("page")  int page,@Query("per_page") int perPage);

    //can search section
    @GET("search/photos")
    Call<List<UnsplashModel>> searchImage(@Query("client_id") String cid,@Query("query")  String name);


}
