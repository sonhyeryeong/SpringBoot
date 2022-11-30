package com.ingris.board.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ingris.board.entity.BoardDTO;
import com.ingris.board.service.BoardService;

@Controller
public class BoardController {
	@Resource(name="boardService")
	private BoardService boardService;

	@GetMapping("/")
	public ModelAndView main(ModelAndView mav) {
		mav.setViewName("layouts/main");
		mav.addObject("title", "탭에서 보는 인덱스");
		ArrayList<BoardDTO> boardList = boardService.selectBoardList();
		mav.addObject("boardList", boardList);
		return mav;
	}
	
	//[작성]-입력된 내용을 받아 저장하여야 함.   
	@PostMapping("/ajaxInsertBoard")
	@ResponseBody
	public Map<String, Object> ajaxInsertBoard(@ModelAttribute("BoardDTO") BoardDTO dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if(boardService.insertBoardOne(dto)==1) {//업데이트에 성공하면 
				result.put("msg", "success");
			} else {
				result.put("msg", "fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "fail");
		}
		return result;
	}
	
	//삭제 부분.
	@PostMapping("/ajaxDeleteBoard")
	@ResponseBody
	public Map<String, Object> ajaxDeleteBoard(@ModelAttribute("BoardDTO") BoardDTO dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if(boardService.deleteBoardOne(dto)==1) {
				result.put("msg", "success");
			} else {
				result.put("msg", "fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "fail");
		}
		return result;
	}
	
	//[수정부분]-읽어서 다시 view로 보내줘야함.  
	@PostMapping("/ajaxReadBoard")
	@ResponseBody
	public Map<String, Object> ajaxReadBoard(@ModelAttribute("BoardDTO") BoardDTO dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			BoardDTO selectBoardOne = boardService.selectBoardOne(dto);
			result.put("title", selectBoardOne.getTitle());
			result.put("content", selectBoardOne.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//[수정부분]-수정된 내용을 받아 저장하여야 함.   
	@PostMapping("/ajaxEditBoard")
	@ResponseBody
	public Map<String, Object> ajaxEditBoard(@ModelAttribute("BoardDTO") BoardDTO dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if(boardService.updateBoardOne(dto)==1) {//업데이트에 성공하면 
				result.put("msg", "success");
			} else {
				result.put("msg", "fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "fail");
		}
		return result;
	}

	
	
}
