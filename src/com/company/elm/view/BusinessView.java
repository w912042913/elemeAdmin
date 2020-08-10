package com.company.elm.view;

import com.company.elm.domain.Business;

public interface BusinessView {
    public void listBusinessAll();
    public void listBusinessBySearch();
    public void saveBusiness();
        public void deleteBusiness();
    // 添加一个商家登录验证的方法
    public Business login();
    // 显示商家信息
    public void showBusinessInfo( Integer businessId);
    // 修改商家信息
    public void updateBusinessInfo(Integer businessId);
}