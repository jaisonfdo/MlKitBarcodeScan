package com.droidmentor.mlkitbarcodescan.LocalData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Jaison.
 */
public class AccountDB extends OrmLiteSqliteOpenHelper
{

    String TAG="AccountDB";

    private static final String DATABASE_NAME = "AccountDB";
    private static final int DATABASE_VERSION = 1;

    private RuntimeExceptionDao<ContactDetail, Integer> accountRuntimeDao = null;

    public AccountDB(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "Constructor: ");
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {

            TableUtils.createTable(connectionSource, ContactDetail.class);
            Log.d(TAG, "onCreate: success");

        } catch (SQLException e) {
            e.printStackTrace();
            Log.d(TAG, "onCreate: fails");

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion)
    {
        Log.d(TAG, "onUpgrade");
    }

    // DAO for table

    public RuntimeExceptionDao<ContactDetail, Integer> getAccountREDao() {
        if (accountRuntimeDao == null) {
            accountRuntimeDao = getRuntimeExceptionDao(ContactDetail.class);
        }
        return accountRuntimeDao;
    }

    // Clear data from all tables

    public void clearAlltables()
    {
        try {
            TableUtils.clearTable(getConnectionSource(), ContactDetail.class);
            Log.d(TAG, "onCLear: success");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d(TAG, "onCLear: fails");
        }
    }

}
