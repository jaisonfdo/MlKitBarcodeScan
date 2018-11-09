package com.droidmentor.mlkitbarcodescan.LocalData;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaison.
 */

public class DBHandler
{
    AccountDB accountDB;
    private static DBHandler instance = null;

    String TAG = "DBHandler";

    public DBHandler(Context context) {
        accountDB = new AccountDB(context);
        accountDB.getWritableDatabase();
    }

    public static DBHandler getInstance(Context context) {
        if (instance == null) {
            instance = new DBHandler(context);
        }
        return instance;
    }

    public AccountDB getdatabase() {
        Log.d(TAG, "getdatabase: ");
        return accountDB;
    }

    // Insert Function

    public int insertAccountDetails(ContactDetail accountDetails) {
        accountDB.getAccountREDao().create(accountDetails);
        Log.d(TAG, "after creation: "+accountDetails.getId());
        return accountDetails.getId();
    }

    // Get All Active accounts list

    public List<ContactDetail> getAccountsList() {

        List<ContactDetail> contactDetailList = new ArrayList<>();
        try {
            RuntimeExceptionDao<ContactDetail, Integer> accountREDao = accountDB.getAccountREDao();
            QueryBuilder<ContactDetail, Integer> qb = accountREDao.queryBuilder();
            qb.orderBy("id",false);
            PreparedQuery<ContactDetail> pq = qb.prepare();

            contactDetailList = accountREDao.query(pq);

            if (!contactDetailList.isEmpty())
                return contactDetailList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactDetailList;
    }

    // Update details in the Account table

    public void updateAccountDetails(int accountID,ContactDetail accountDetails) {
        RuntimeExceptionDao<ContactDetail, Integer> accountREDao = accountDB.getAccountREDao();
        UpdateBuilder<ContactDetail, Integer> updateBuilder = accountREDao.updateBuilder();
        try {
            updateBuilder.where().eq("id", accountID);
            updateBuilder.updateColumnValue("name", accountDetails.getName());
            updateBuilder.updateColumnValue("address", accountDetails.getAddress());
            updateBuilder.updateColumnValue("emailID", accountDetails.getEmailID());
            updateBuilder.updateColumnValue("phoneNumber", accountDetails.getPhoneNumber());
            updateBuilder.updateColumnValue("webLink", accountDetails.getWebLink());
            updateBuilder.updateColumnValue("orgName", accountDetails.getOrgName());
            updateBuilder.update();
            Log.d(TAG, "updateAccountDetails: ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete account details from the records if exists

    public void deleteAccountDetails(int accountID)
    {
        RuntimeExceptionDao<ContactDetail, Integer> accountREDao = accountDB.getAccountREDao();
        accountREDao.deleteById(accountID);
    }

    public boolean isAccountAlreadyExist(String name, String phoneNumber)
    {
        List<ContactDetail> contactDetailList;
        try {
            RuntimeExceptionDao<ContactDetail, Integer> accountREDao = accountDB.getAccountREDao();
            QueryBuilder<ContactDetail, Integer> qb = accountREDao.queryBuilder();

            Where<ContactDetail, Integer> where = qb.where();
            where.eq("name", name);
            where.and();
            where.eq("phoneNumber", phoneNumber);

            PreparedQuery<ContactDetail> pq = qb.prepare();

            contactDetailList = accountREDao.query(pq);

            if (!contactDetailList.isEmpty())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
