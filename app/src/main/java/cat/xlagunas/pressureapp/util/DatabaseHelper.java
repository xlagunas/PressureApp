package cat.xlagunas.pressureapp.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import cat.xlagunas.pressureapp.model.Reading;
import cat.xlagunas.pressureapp.model.User;

/**
 * Created by xlagunas on 4/09/15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "pressure.db";

    private static final int VERSION = 2;

    private Dao<User, Long> userDao = null;
    private Dao<Reading, Long> readingDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Reading.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.dropTable(connectionSource, Reading.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
        }
    }

    public Dao<User, Long> getUserDao() throws  SQLException {
        if (userDao == null){
            userDao = getDao(User.class);
        }

        return userDao;
    }

    public Dao<Reading, Long> getReadingDao() throws SQLException {
        if (readingDao == null) {
            readingDao = getDao(Reading.class);
        }

        return readingDao;
    }

    @Override
    public void close() {
        super.close();
        userDao = null;
        readingDao = null;
    }
}
