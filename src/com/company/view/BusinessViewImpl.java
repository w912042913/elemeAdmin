package com.company.view;

import com.company.dao.Impl.BusinessDaoImpl;
import com.company.domain.Business;

import java.util.List;

public class BusinessViewImpl implements BusinessView {
    @Override
    public void listBusinessAll() {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号\t商家名称");
        for (Business b:list) {
            System.out.println(b.getBusinessId()+"\t"+b.getPassword());
        }
    }
}
