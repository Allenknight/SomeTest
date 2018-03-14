package hsj.whatever.com.selfviewdemo;

import android.content.Context;

public interface DatabaseManager{

    /**
     * 获取数据库连接
     * @param context
     */
    void startup(Context context);

    /**
     * 关闭数据库
     */
    void shutdown();

    /**
     * 检查数据库状态是否可用
     * @return
     */
    boolean checkDBStatus();

//    /**
//     * 获取greenDAO管理类
//     * @return
//     */
//    DaoSession getDaoSession();

}
