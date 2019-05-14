package jlexdev.com.tareitas.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import jlexdev.com.tareitas.db.entity.Tareita;

@Dao
public interface TareitaDao {

    @Insert
    void insert(Tareita tareita);

    @Update
    void update(Tareita tareita);

    @Delete
    void delete(Tareita tareita);

    @Query("DELETE FROM tareita_table")
    void deleteAllTareitas();

    @Query("SELECT * FROM tareita_table") // ORDER BY id DESC" || ORDER BY tareita ASC
    LiveData<List<Tareita>> getAllTareitas();
}
