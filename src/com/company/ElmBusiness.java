package com.company;

import com.company.domain.Admin;
import com.company.domain.Business;
import com.company.view.AdminView;
import com.company.view.BusinessView;
import com.company.view.Impl.AdminViewImpl;
import com.company.view.Impl.BusinessViewImpl;

import java.util.Scanner;

public class ElmBusiness {
    public static void main(String[] args) {
   work();
    }
    public static  void  work(){
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------");
        System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
        System.out.println("-----------------------------------------------------------");


        // 调用商家登录
        BusinessView  businessView1 = new BusinessViewImpl();
        Business login = businessView1.login();
        BusinessView businessView = new BusinessViewImpl();
        Business business = businessView.login();
        if (business!=null){
            int menu = 0;
            System.out.println("~欢迎来到饿了么商家管理系统~");
            while (menu!= 5){

                // 创建一个菜单
                System.out.println("========= 一级菜单1.查看商家信息=2.修改商家信息=3.更新密码=4.所属商品管理=5.退出系统 =========");
                System.out.println("请选择相应的菜单编号");
                menu = input.nextInt();

                switch (menu){
                    case 1:
                        businessView.listBusinessAll();
                        break;
                    case 2:
                        businessView.listBusinessBySearch();
                        break;
                    case 3:
                        businessView.saveBusiness();
                        break;
                    case 4:
                        businessView.deleteBusiness();
                        break;
                    case 5:
                        System.out.println("========= 欢迎下次光临饿了么系统 =========");
                        break;
                    default:
                        System.out.println("没有这个菜单项");
                        break;
                }

            }




        }else {
            System.out.println("账号或密码有误请重新输入");
        }

    }
}