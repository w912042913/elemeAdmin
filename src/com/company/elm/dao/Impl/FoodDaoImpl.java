package com.company.elm.dao.Impl;

import com.company.elm.dao.FoodDao;
import com.company.elm.domain.Food;
import com.company.elm.utils.JDBCUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    private Connection conn =null;
    private PreparedStatement pstmt =null;
    private ResultSet rs =null;


    @Override
    public List<Food> findAll(Integer businessId)  {
        ArrayList<Food> foodList = null;
        foodList = new ArrayList<>();
        String sql= "select * from food where businessId=?";

      try {
          conn = JDBCUtils.getConnection();
          pstmt =   conn.prepareStatement(sql);
          rs = pstmt.executeQuery();
          while (rs.next())
          {
              Food food = new Food();
              food.setFoodId(rs.getInt("foodId"));
              food.setFoodName(rs.getString("foodName"));
              food.setFoodExplain(rs.getString("foodExplain"));
              food.setFoodPrice(rs.getDouble("foodPrice"));
              food.setBusinessId(rs.getInt("businessId"));
              foodList.add(food);
      }
         }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }

        return foodList; }

    @Override
    public Food getFoodById(Integer foodId) {

        Food food =null;
        String sql = "select * from food where businessId = ? ";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, foodId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                 food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
      return food;
    }

    @Override
    public int saveFood(Food food) {
        int foodId = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into  food (foodId,foodName,foodExplain,foodPrice,businessId)values (10,?,'食品',12,10003)";
            pstmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,"foodName");

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                foodId = rs.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);

        }
        return foodId;
    }

    @Override
    public int updateFood(Food food) {
        return 0;
    }

    @Override
    public int removeFood(Integer foodId) {
        return 0;
    }


}
