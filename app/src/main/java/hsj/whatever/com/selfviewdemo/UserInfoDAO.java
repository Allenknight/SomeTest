package hsj.whatever.com.selfviewdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by AllenHan on 2018/3/14.
 */

public class UserInfoDAO {
    private Context context;
    private ReadWriteLock lock;
    public UserInfoDAO(Context context, ReadWriteLock lock){
        this.context = context;
        this.lock = lock;
    }
    public SQLiteDatabase getConnection(){
        SQLiteDatabase sqLiteDatabase = null;
        try {
//            sqLiteDatabase = new DataBaseHelper(context).getWritableDatabase();
        }catch (Exception e){

        }
        return sqLiteDatabase;
    }
    public void insert(String userInfo){
        lock.writeLock().lock();
        SQLiteDatabase db = null;
        try {
            ContentValues values = new ContentValues();
            values.put("name", "whatever");
            values.put("age", "whatever");
            db = getConnection();
            if(db != null && db.isOpen()){
                db.insert("userInfo", null, values);
            }
        }catch (Exception e){

        }finally {
            if(db != null && db.isOpen()){
                db.close();
            }
            lock.writeLock().unlock();
        }
    }

    public List<String> query(){
        List<String> list = new ArrayList<>();
        lock.readLock().lock();
        SQLiteDatabase db = null;
        try {
            db = getConnection();
            if(db != null && db.isOpen()){
                Cursor c = db.rawQuery("SELECT * FROM userInfo", null);
                String info;
                while (c.moveToNext()){
                    info = new String();
                    info = c.getString(c.getColumnIndex("name"));
                    list.add(info);
                }
            }
        }catch (Exception e){

        }finally {
            if(db != null && db.isOpen()){
                db.close();
            }
            lock.readLock().unlock();
        }
        return list;
    }
}
