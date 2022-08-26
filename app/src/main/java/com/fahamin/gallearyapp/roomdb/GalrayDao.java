package com.fahamin.gallearyapp.roomdb;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import com.fahamin.gallearyapp.model.UnsplashModel;
import com.fahamin.gallearyapp.roomdb.TypeConverters.ModelTypeConverters;

import java.util.List;

@TypeConverters(ModelTypeConverters.class)
@Dao
public interface GalrayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(List<UnsplashModel> list);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertSingle(UnsplashModel models);


    @Query("Select * From UnsplashModel")
    public List<UnsplashModel> getAllImageFromDb();


    @Query("SELECT *  FROM UnsplashModel WHERE id =:id ")
    public UnsplashModel getSingleOutlet(int id);

    @Update
    public void update(UnsplashModel unsplashModel);

    @Delete
    public void delete(UnsplashModel unsplashModel);


}
