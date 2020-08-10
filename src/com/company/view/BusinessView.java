package com.company.view;

import com.company.domain.Business;

public interface BusinessView {
    public void listBusinessAll();
    public void listBusinessBySearch();
    public void saveBusiness();
    public void deleteBusiness();
    // 添加一个商家登录验证的方法
    public Business login();

}