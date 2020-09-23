package com.example.miaojiaohui2.ui.company;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.miaojiaohui2.db.CompanyEntity;
import com.example.miaojiaohui2.db.MiaoDatabase;

import java.util.List;

public class CompanyViewModel extends AndroidViewModel {

    private static MiaoDatabase mDatabase;
    //private MutableLiveData<String> mText;
    //private MiaoDatabase mDatabase;
    private LiveData<List<CompanyEntity>> mcompanyList;

    public CompanyViewModel(@NonNull Application application) {
       // mText = new MutableLiveData<>();
       // mText.setValue("This is home fragment");
        super(application);
        mDatabase = MiaoDatabase.getInstance(application);
        mcompanyList = mDatabase.companyDao().getCompanyList();
    }

    public LiveData<List<CompanyEntity>> getLiveDataCompany()
    {

        return mcompanyList;
    }

    public static  CompanyEntity loadCompanybyid(int aid){
        return mDatabase.companyDao().loadCompanyById(aid);
    }

    public static void insertCompanyToDB(CompanyEntity companyEntity){
        mDatabase.companyDao().insertCompany(companyEntity);
    }

    public static void updateCompanyToDB(CompanyEntity companyEntity){
        mDatabase.companyDao().updateCompany(companyEntity);
    }

    public static LiveData<List<CompanyEntity>> queryCompanyFromDB(){
        return mDatabase.companyDao().getCompanyList();
    }

    public static int recordNumber(int aid){
        return mDatabase.companyDao().is_exist(aid);
    }

//    public LiveData<String> getText() {
//        return mText;
//    }
}