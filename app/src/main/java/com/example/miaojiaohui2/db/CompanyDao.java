package com.example.miaojiaohui2.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CompanyDao {
    @Query("SELECT * FROM CompanyEntity")
    LiveData<List<CompanyEntity>> getCompanyList();

    @Query("SELECT * FROM CompanyEntity WHERE aid IN (:aids)")
    LiveData<List<CompanyEntity>> loadAllByIds(int[] aids);

    @Query("SELECT * FROM CompanyEntity WHERE CompanyEntity.aid=:aid")
    CompanyEntity loadCompanyById(int aid);

    @Query("SELECT COUNT(*) FROM CompanyEntity WHERE CompanyEntity.aid=:aid")
    int is_exist(int aid);

    @Insert
    void insertCompany(CompanyEntity companyEntity);

    @Update
    void updateCompany(CompanyEntity companyEntity);

    @Delete
    void deleteCompany(CompanyEntity companyEntity);
}
