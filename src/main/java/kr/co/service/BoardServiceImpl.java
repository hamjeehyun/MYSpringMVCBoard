package kr.co.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.BoardDAO;
import kr.co.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	// �Խñ� �ۼ�
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}
	
	// �Խù� ��� ��ȸ
	@Override
	public List<BoardVO> list() throws Exception {

		return dao.list();
	}

	// �Խù� ��ȸ
	@Override
	public BoardVO read(int bno) throws Exception {

		return dao.read(bno);
	}
	
	@Override
	public void update(BoardVO boardVO) throws Exception {

		dao.update(boardVO);
	}

	@Override
	public void delete(int bno) throws Exception {
		
		dao.delete(bno);
	}
}