package com.company.elm.view.Impl;

import com.company.elm.dao.Impl.FoodDaoImpl;
import com.company.elm.domain.Food;
import com.company.elm.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    private Scanner input = new Scanner(System.in);
    @Override
    public void showFoodList(Integer businessId) {
        FoodDaoImpl Dao = new FoodDaoImpl();
        List<Food> foodList = Dao.findAll(businessId);
        System.out.println("食品编号" + "\t" +"食品名称");
        for (Food food:foodList) {
            System.out.println(food.getFoodId()+"\t"+food.getFoodName());
        }
    }

    @Override
    public void saveFood(Integer businessId) {
        Food food = new Food();
        System.out.println("请输入商家的名字：");
        String FoodName  = input.next();
        FoodDaoImpl Dao = new FoodDaoImpl();

    }

    @Override
    public void updateFood(Integer businessId) {

    }

    @Override
    public void removeFood(Integer businessId) {

    }
}
