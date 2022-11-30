package com.ingris.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingris.board.entity.BoardDTO;
import com.ingris.board.repository.BoardMapper;

@Service("boardService")
@Transactional
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;

	public ArrayList<BoardDTO> selectBoardList() {
		return boardMapper.selectBoardList();
	}

	public BoardDTO selectBoardOne(BoardDTO dto) throws Exception {
		return boardMapper.selectBoardOne(dto);
	}

	public int deleteBoardOne(BoardDTO dto) throws Exception {
		return boardMapper.deleteBoardOne(dto);
	}

	public int updateBoardOne(BoardDTO dto) throws Exception {
		return boardMapper.updateBoardOne(dto);
	}

	public int insertBoardOne(BoardDTO dto) throws Exception {
		return boardMapper.insertBoardOne(dto);
	}

}
