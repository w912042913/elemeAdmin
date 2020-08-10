package com.company.elm.dao;
import com.company.elm.domain.Admin;


    public interface AdminDao {
       public  Admin getAdminByNameByPass(String adminName, String password);
    }

