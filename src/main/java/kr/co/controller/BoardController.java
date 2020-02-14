package kr.co.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.BoardService;
import kr.co.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	// �Խ��� �� �ۼ� ȭ��
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
		
	}
	
	// �Խ��� �� �ۼ�
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception{
		logger.info("write");
		System.out.print("asdsad");
		service.write(boardVO);
		
		return "redirect:list";
	}
	
	// �Խ��� ��� ��ȸ
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		logger.info("list");
		
		model.addAttribute("list",service.list());
		
		
		return "board/list";
		
	}
	
	// �Խ��� ��ȸ
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(BoardVO boardVO, Model model) throws Exception{
		logger.info("read");
		
		model.addAttribute("read", service.read(boardVO.getBno()));
		
		return "board/readView";
	}
	
	// �Խ��� ������
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model) throws Exception{
		logger.info("updateView");
		
		model.addAttribute("update", service.read(boardVO.getBno()));
		
		return "board/updateView";
	}
	
	// �Խ��� ����
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception{
		logger.info("update");
		
		service.update(boardVO);
		
		return "redirect:/board/list";
	}

	// �Խ��� ����
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception{
		logger.info("delete");
		
		service.delete(boardVO.getBno());
		
		return "redirect:/board/list";
	}
}