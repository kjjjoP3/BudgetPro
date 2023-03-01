package edu.poly.budgetpro.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.poly.budgetpro.dao.AppDataBase;
import edu.poly.budgetpro.dao.LoaiThuDao;
import edu.poly.budgetpro.entity.LoaiThu;

public class LoaiThuRepository {
    private LoaiThuDao mLoaiThuDao;
    private LiveData<List<LoaiThu>> mAllLoaiThu;

    public LoaiThuRepository(Application application) {
        this.mLoaiThuDao = AppDataBase.getDatabase(application).loaiThuDao();
        mAllLoaiThu = mLoaiThuDao.finAll();
    }

    public LiveData<List<LoaiThu>> getAllLoaiThu(){
        return  mAllLoaiThu;
    }

    public void insert(LoaiThu loaiThu){
        new InsertAsynTask(mLoaiThuDao).execute(loaiThu);
    }

    class InsertAsynTask extends AsyncTask<LoaiThu, Void, Void>{
        private  LoaiThuDao mLoaiThuDao;
        public InsertAsynTask(LoaiThuDao loaiThuDao){
                this.mLoaiThuDao = loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDao.insert(loaiThus[0]);
            return null;
        }
    }
}
