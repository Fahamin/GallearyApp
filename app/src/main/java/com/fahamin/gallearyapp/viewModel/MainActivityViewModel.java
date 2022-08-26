package com.fahamin.gallearyapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.fahamin.gallearyapp.model.Repository.Repository;
import com.fahamin.gallearyapp.model.UnsplashModel;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    Repository repository;
    MutableLiveData<List<UnsplashModel>> list;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        repository = new Repository(getApplication());
        list = repository.getAllImageList();

    }

    public MutableLiveData<List<UnsplashModel>> getListFromViewModel() {
        return list;
    }

}
