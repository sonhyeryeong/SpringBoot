package com.ingris.board.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ingris.board.entity.BoardDTO;

@Mapper
public interface BoardMapper {
	ArrayList<BoardDTO> selectBoardList();
	BoardDTO selectBoardOne(BoardDTO dto);
	int deleteBoardOne(BoardDTO dto);
	int updateBoardOne(BoardDTO dto);
	int insertBoardOne(BoardDTO dto);
	
}
