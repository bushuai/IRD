package me.donkey.service;

import java.util.List;

import me.donkey.entity.Notice;

public interface NoticeService {
	public List<Notice> getAllNotice();

	public boolean addNotice(Notice notice);

	public boolean deleteNoticeById(int id);

	public boolean updateNotice(Notice notice);
}
