package me.donkey.dao;

import java.util.List;

import me.donkey.entity.Notice;

public interface NoticeDao {
	public List<Notice> getAllNotice();

	public boolean addNotice(Notice notice);

	public boolean deleteNoticeById(int id);

	public boolean updateNotice(Notice notice);
}
