package com.mvc.mall.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.mall.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private Logger logger = LoggerFactory.getLogger(NoticeDaoImpl.class);

	@Override
	public List<NoticeDto> list() {
		List<NoticeDto> result = new ArrayList<NoticeDto>();
		try {
			result = sqlSession.selectList(NAMESPACE+"NoticeList");
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl List");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public NoticeDto detail(int notice_no) {
		NoticeDto result = null;
		try {
			result = sqlSession.selectOne(NAMESPACE+"NoticeDetail",notice_no);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl Detail");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(NoticeDto dto) {
		int result = 0;
		try {
			result = sqlSession.insert(NAMESPACE+"NoticeInsert", dto);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl Insert");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(NoticeDto dto) {
		int result = 0;
		try {
			result = sqlSession.update(NAMESPACE+"NoticeUpdate", dto);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl Update");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int notice_no) {
		int result = 0;
		try {
			result = sqlSession.delete(NAMESPACE+"NoticeDelete", notice_no);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl Delete");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateCountView(int notice_no) {
		int result = 0;
		try {
			result = sqlSession.update(NAMESPACE+"NoticeCountView", notice_no);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl updateContView");
			e.printStackTrace();
		}
		return result;
	}

}