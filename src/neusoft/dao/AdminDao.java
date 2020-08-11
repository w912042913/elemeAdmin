package neusoft.dao;

import com.company.elm.domain.Admin;

public interface AdminDao {
    public Admin getAdminByNameByPass(String adminName, String password);
}
