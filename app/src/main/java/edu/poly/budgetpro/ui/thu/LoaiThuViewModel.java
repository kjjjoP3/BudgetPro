package edu.poly.budgetpro.ui.thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.poly.budgetpro.dao.LoaiThuDao;
import edu.poly.budgetpro.entity.LoaiThu;
import edu.poly.budgetpro.repository.LoaiThuRepository;

public class LoaiThuViewModel extends AndroidViewModel {
    private LoaiThuRepository mLoaiThuRepository;
    private LiveData<List<LoaiThu>> mAllLoaiThu;
    public LoaiThuViewModel(@NonNull Application application) {
        super(application);
        mLoaiThuRepository = new LoaiThuRepository(application);
        mAllLoaiThu = mLoaiThuRepository.getAllLoaiThu();
    }

    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mAllLoaiThu;
    }

    public void insert(LoaiThu loaiThu){
        mLoaiThuRepository.insert(loaiThu);
    }
}