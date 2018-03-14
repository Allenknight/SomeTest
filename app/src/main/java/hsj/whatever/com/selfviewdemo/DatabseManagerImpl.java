package hsj.whatever.com.selfviewdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

/**
 * Created by AllenHan on 2018/3/14.
 */

public class DatabseManagerImpl implements DatabaseManager{
    private static final String DBNAME = "test_db";
    private SQLiteOpenHelper helper;
    private SQLiteDatabase db;
    private Context mContext;
//    private DaoSession daoSession;

    @Override
    public void startup(Context context) {
        this.mContext = context;
        if(true){
//            SQLiteQueryBuilder.appendColumns();
        }
        getOpenHelper();
        db = helper.getWritableDatabase();
//        DaoMaster daoMaster = new DaoMaster(db);
//        daoSession = daoMaster.newSesion();
    }

    @Override
    public void shutdown() {
//        if(daoSession != null){
//            daoSession.clear();
//        }
//        if(db != null && db.isOpen()){
//            db.close();
//        }
    }

    private void getOpenHelper(){
        if(helper != null){
            return;
        }
//        if(false){
//            helper = new DaoMaster.DevOpenHelper(mContext, DBNAME, null);
//        }else{
//            helper = new ReleaseOpenHelper(mContext, DBNAME, null);
//        }
    }

    @Override
    public boolean checkDBStatus() {
        if(db == null || !db.isOpen()){
            getOpenHelper();
            db = helper.getWritableDatabase();
        }
        if(db.isOpen()){
            return true;
        }else{
            if(true){
                Log.e("adf", "a");
            }
            return false;
        }
//        return false;
    }

//    @Override
//    public DaoSession getDaoSession() {
//        if(!checkDBStatus()){
//            return null;
//        }
//        if(daoSession == null){
//            DaoMaster daoMaster = new DaoMaster(db);
//            daoSession = daoMaster.newSession();
//        }
//        return daoSession;
//    }
}

