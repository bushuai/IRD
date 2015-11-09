package me.donkey.service.impl;

import java.util.List;

import me.donkey.dao.NoticeDao;
import me.donkey.dao.impl.NoticeDaoImpl;
import me.donkey.entity.Notice;
import me.donkey.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	NoticeDao ns = new NoticeDaoImpl();

	@Override
	public List<Notice> getAllNotice() {
		// TODO Auto-generated method stub
		return ns.getAllNotice();
	}

	@Override
	public boolean addNotice(Notice notice) {
		// TODO Auto-generated method stub
		return ns.addNotice(notice);
	}

	@Override
	public boolean deleteNoticeById(int id) {
		// TODO Auto-generated method stub
		return ns.deleteNoticeById(id);
	}

	@Override
	public boolean updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		return ns.updateNotice(notice);
	}

}
