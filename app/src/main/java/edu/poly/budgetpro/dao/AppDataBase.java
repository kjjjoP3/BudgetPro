package edu.poly.budgetpro.dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import edu.poly.budgetpro.entity.LoaiThu;

@Database(entities = {LoaiThu.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {

    public abstract LoaiThuDao loaiThuDao();

    public static AppDataBase INSTANCE;

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateData(INSTANCE).execute();
        }
    };



    public static  AppDataBase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDataBase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,
                                "personal_db")
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();
            }
        }
        return INSTANCE;
    }

    public static  class PopulateData extends AsyncTask<Void, Void, Void> {
        private  LoaiThuDao loaiThuDao;

        public PopulateData(AppDataBase db) {
            loaiThuDao = db.loaiThuDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String [] loaiThus = new String[]{"Luong","Thuong","Co Phieu"};
            for (String it: loaiThus) {
                LoaiThu lt = new LoaiThu();
                lt.ten = it;
                loaiThuDao.insert(lt);
            }
            return null;
        }
    }

}
