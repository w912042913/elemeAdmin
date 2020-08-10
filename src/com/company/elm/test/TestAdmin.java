package com.company.elm.test;

import com.company.elm.dao.AdminDao;
import com.company.elm.dao.Impl.AdminDaoImpl;
import com.company.elm.domain.Admin;


public class TestAdmin {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDaoImpl();
        Admin admin = adminDao.getAdminByNameByPass("王磊", "123");
        System.out.println(admin);
    }
}