package com.company.elm.dao.Impl;





import com.company.elm.dao.AdminDao;
import com.company.elm.domain.Admin;
import com.company.elm.utils.JDBCUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private Connection conn =null;
    private PreparedStatement pstmt =null;
    private ResultSet rs =null;

    @Override
    public Admin getAdminByNameByPass(String adminName, String password) {
        Admin admin = null;
        String sql = "select * from admin where adminName = ? and password = ?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()){
                admin = new Admin();
                admin.setAdminId(rs.getInt("adminId"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return admin;
    }

    @Override
    public List<Admin> findAll() {
        ArrayList<Admin> admins = null;
        try{
            String sql = "select * from admin;";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            admins = new ArrayList<>();
            rs = pstmt.executeQuery();
            while (rs.next()){
//                admins.add(new Admin(rs.getInt("adminId"),(rs.getString("adminName")),(rs.getString("password"))));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return admins;
    }

    @Override
    public void save(Admin admin) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into  admin values (null,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,admin.getAdminName());
            pstmt.setString(2,admin.getPassword());

            int count = pstmt.executeUpdate();
            if (count > 0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);

        }
    }



    @Override
    public void update(Admin admin) {

        try {
            conn = JDBCUtils.getConnection();
            String sql = "update admin set password = ? where adminId = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,admin.getPassword());
            pstmt.setInt(2,admin.getAdminId());

            int count = pstmt.executeUpdate();
            if (count > 0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);

        }
    }

    @Override
    public void delete(Integer adminId) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from admin where adminId = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,adminId);

            int count = pstmt.executeUpdate();

            if (count > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);

        }

    }

}