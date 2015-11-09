package me.donkey.dao.impl;

import me.donkey.dao.AdminDao;
import me.donkey.dao.CustomerDao;
import me.donkey.entity.Admin;
import me.donkey.entity.Customer;
import me.donkey.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

	DBUtil db = new DBUtil();
	List<String> arguments;
	String sql;
	ResultSet resultSet;
	Admin admin;

	@Override
	public List<Admin> getAllAdmin() {
		sql = "select * from admin";
		resultSet = db.executeQuery(sql, null);
		List<Admin> admins = new ArrayList();

		try {
			while (resultSet.next()) {
				admin = new Admin();
				admin.setId(Integer.parseInt(resultSet.getString("id")));
				admin.setLoginId(resultSet.getString("loginId"));
				admin.setPassword(resultSet.getString("password"));
				admin.setName(resultSet.getString("name"));
				admins.add(admin);
			}
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		return admins;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		arguments = new ArrayList();
		sql = "insert into customer(loginId,password,name) values(?,?,?)";
		arguments.add(admin.getLoginId());
		arguments.add(admin.getPassword());
		arguments.add(admin.getName());
		return (db.query(sql, arguments) == 0) ? false : true;

	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		sql = "select * from admin where id = " + id;
		resultSet = db.executeQuery(sql, null);
		try {
			if (resultSet.next()) {
				admin = new Admin();
				admin.setId(resultSet.getInt("id"));
				admin.setLoginId(resultSet.getString("loginId"));
				admin.setPassword(resultSet.getString("password"));
				admin.setName(resultSet.getString("name"));
			}
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Admin getAdminByLoginId(String loginId) {
		sql = "select * from admin where loginId = ? ";
		arguments = new ArrayList();
		arguments.add(loginId);
		resultSet = db.executeQuery(sql, arguments);
		try {
			if (resultSet.next()) {
				admin = new Admin();
				admin.setId(resultSet.getInt("id"));
				admin.setLoginId(resultSet.getString("loginId"));
				admin.setPassword(resultSet.getString("password"));
				admin.setName(resultSet.getString("name"));
			}
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean verify(String loginId, String password) {
		sql = "select * from customer where loginId = ? and password=?";
		arguments = new ArrayList();
		arguments.add(loginId);
		arguments.add(password);
		System.out.println(arguments.toString());
		try {
			if (db.executeQuery(sql, arguments).next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		sql = "update customer set loginId = ?,password = ? ,name = ? ,age=?,address = ?,phone=? where id=?";
		System.out.println(sql);
		arguments = new ArrayList();
		arguments.add(admin.getLoginId());
		arguments.add(admin.getPassword());
		arguments.add(admin.getName());
		arguments.add(String.valueOf(admin.getId()));
		return (db.query(sql, arguments) == 0) ? false : true;
	}

	@Override
	public boolean deleteAdminById(int id) {
		arguments = new ArrayList();
		sql = "delete from customer where id = ?";
		arguments.add(String.valueOf(id));
		return (db.query(sql, arguments) == 0) ? false : true;
	}

	@Override
	public boolean deleteAdminByLoginId(String loginId) {
		return false;
	}

}
