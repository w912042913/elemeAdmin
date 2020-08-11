package neusoft.dao.Impl;

import com.company.elm.dao.AdminDao;
import com.company.elm.domain.Admin;
import com.company.elm.utils.JDBCUtils;

import java.sql.*;
import java.util.List;

/**
 * @author Eric Lee
 * @date 2020/8/7 09:48
 */
public class AdminDaoImpl implements AdminDao {
    private  Connection conn =null;
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
        return null;
    }

    @Override
    public void save(Admin admin) {

    }

    @Override
    public void update(Admin admin) {

    }

    @Override
    public void delete(Integer adminId) {

    }
}
