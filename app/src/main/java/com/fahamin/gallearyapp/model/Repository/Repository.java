package com.fahamin.gallearyapp.model.Repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.fahamin.gallearyapp.api.API;
import com.fahamin.gallearyapp.api.ApiUtils;
import com.fahamin.gallearyapp.model.UnsplashModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    API api;
    MutableLiveData<List<UnsplashModel>> data;
    Repository repository;

    public Repository(Application application) {
        if (repository != null) {
            repository = new Repository(application);
        }

        data = new MutableLiveData<>();
        api = ApiUtils.getAPIService();

    }

    public MutableLiveData<List<UnsplashModel>> getAllImageList() {
        getListImgeAll();
        return data;
    }

    void getListImgeAll() {
        Call<List<UnsplashModel>> call = api.getImageList("G16lecQm1ZOzdMfAZpaxuY_0lvOffmA_-AOFNzfeHEQ");

        call.enqueue(new Callback<List<UnsplashModel>>() {
            @Override
            public void onResponse(Call<List<UnsplashModel>> call, Response<List<UnsplashModel>> response) {

                if (response.isSuccessful()) {
                    data.postValue(response.body());
                    Log.e("respons", response.body().toString());

                } else {
                    Log.e("respons", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<UnsplashModel>> call, Throwable t) {
                Log.e("failed", t.getMessage());
            }
        });
    }
}
