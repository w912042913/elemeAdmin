package com.company.dao;
import com.company.domain.Admin;


    public interface AdminDao {
       public  Admin getAdminByNameByPass(String adminName, String password);
    }

