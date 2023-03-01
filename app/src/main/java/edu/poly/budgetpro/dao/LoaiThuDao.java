package edu.poly.budgetpro.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.poly.budgetpro.entity.LoaiThu;

@Dao
public interface LoaiThuDao {

    @Query("Select * from loaithu")
    LiveData<List<LoaiThu>> finAll();

    @Insert
    void insert(LoaiThu loaiThu);

    @Update
    void update(LoaiThu loaiThu);
}
