package com.company.test;

import com.company.dao.Impl.BusinessDaoImpl;

public class TestBusiness {
    public static void main(String[] args) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.listBusiness("饺子", "沈阳");

    }
}