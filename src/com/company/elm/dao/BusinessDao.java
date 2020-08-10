package com.company.elm.dao;

import com.company.elm.domain.Business;

import java.util.List;

public interface BusinessDao {
    // 显示所有商家列表 可选输入businessName和businessAddress
    public List<Business> listBusiness(String businessName,String businessAddress );
    public int saveBusiness(String businessName);
    public Business getBusinessByNameByPass(Integer businessId, String password);
    public int DeleteBusiness(int businessId);
    public Business getBusinessByBusinessId( int businessId);
    public int updateBusiness( Business business);
}

