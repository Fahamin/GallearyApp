package com.fahamin.gallearyapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fahamin.gallearyapp.GallaryAdapter;
import com.fahamin.gallearyapp.R;
import com.fahamin.gallearyapp.Utility.ItemClickListener;
import com.fahamin.gallearyapp.Utility.Utils;
import com.fahamin.gallearyapp.roomdb.GalaryDatabase;
import com.fahamin.gallearyapp.roomdb.GalrayDao;
import com.fahamin.gallearyapp.databinding.ActivityMainBinding;
import com.fahamin.gallearyapp.model.UnsplashModel;
import com.fahamin.gallearyapp.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    MainActivityViewModel viewModel;
    ActivityMainBinding binding;

    List<UnsplashModel> list;


    GalaryDatabase database;
    GalrayDao dao;
    RecyclerView recyclerView;
    ArrayList<String> filterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        list = new ArrayList<>();
        database = GalaryDatabase.getInstance(this);
        dao = database.galrayDao();
        new Utils(this);

        recyclerView = binding.recyclerViewID;
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

        list = dao.getAllImageFromDb();
        if (list.isEmpty()) {
            checkDataFromServer();
        } else {
            Log.e("dbdata", list.get(0).getUrls().getSmall());
            setAdapterList(list);
        }


    }

    private void checkDataFromServer() {
        viewModel.getListFromViewModel().observe(this, new Observer<List<UnsplashModel>>() {
            @Override
            public void onChanged(List<UnsplashModel> unsplashModels) {
                Log.e("data", unsplashModels.get(0).getUrls().getSmall());
                list = unsplashModels;
                setAdapterList(list);
                dao.insert(unsplashModels);
                Toast.makeText(MainActivity.this, unsplashModels.get(0).getCreatedAt(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setAdapterList(List<UnsplashModel> unsplashModels) {
        GallaryAdapter adapter = new GallaryAdapter(unsplashModels, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void clickListener(int pos) {
        Log.e("itemClick", "" + pos);
        filterList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            filterList.add(list.get(i).getUrls().getFull());
        }

        startActivity(new Intent(this, ImageSilderActivity.class)
                .putExtra("list", filterList)
                .putExtra("pos", pos));

    }
}