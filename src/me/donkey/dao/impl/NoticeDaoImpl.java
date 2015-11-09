package me.donkey.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.donkey.dao.NoticeDao;
import me.donkey.entity.Customer;
import me.donkey.entity.Notice;
import me.donkey.util.DBUtil;

public class NoticeDaoImpl implements NoticeDao {
	DBUtil db = new DBUtil();
	List<String> arguments;
	String sql;
	ResultSet resultSet;
	Notice notice;

	@Override
	public List<Notice> getAllNotice() {
		// TODO Auto-generated method stub

		try {
			sql = "select * from notice";
			List<Notice> notices = new ArrayList();
			resultSet = db.executeQuery(sql, null);
			while (resultSet.next()) {
				Notice notice = new Notice();
				notice.setId(resultSet.getInt("id"));
				notice.setAdminId(resultSet.getInt("admin_id"));
				notice.setTitle(resultSet.getString("title"));
				notice.setContent(resultSet.getString("content"));
				notice.setPublish_date(resultSet.getString("publish_date")
						.substring(0,10));
				notices.add(notice);
			}
			return notices;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean addNotice(Notice notice) {
		// TODO Auto-generated method stub
		sql = "insert into notice values(title,cotent,admin_id) valus('"
				+ notice.getTitle() + "','" + notice.getContent() + "','"
				+ notice.getAdminId() + "')";
		return (db.query(sql, null)) == 0 ? false : true;
	}

	@Override
	public boolean deleteNoticeById(int id) {
		// TODO Auto-generated method stub
		sql = "delete from notice where id = " + id;
		return (db.query(sql, null)) == 0 ? false : true;
	}

	@Override
	public boolean updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		sql = "update notice set title='" + notice.getTitle() + "',content='"
				+ notice.getContent() + "'  where id = " + notice.getId();
		return (db.query(sql, null)) == 0 ? false : true;
	}

}
