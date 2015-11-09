package me.donkey.dao;

import me.donkey.entity.Admin;
import me.donkey.entity.Customer;

import java.util.List;

public interface AdminDao {
    public List<Admin> getAllAdmin();
    public boolean addAdmin( Admin admin );

    public Admin getAdminById( int id );

    public Admin getAdminByLoginId( String loginId );

    public boolean verify( String loginId, String password );
    public boolean updateAdmin( Admin admin );
    public boolean deleteAdminById( int id );

    public boolean deleteAdminByLoginId( String loginId );
}
