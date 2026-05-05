package com.winter.app.board;

import java.util.List;
import com.winter.app.file.FileDTO;
import com.winter.app.pager.Pager;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 1. 명시적으로 매퍼 인터페이스임을 선언
public interface BoardMapper {

    /**
     * 페이징 처리를 위한 전체 게시글 개수 조회
     */
    Long getTotalCount(Pager pager) throws Exception;

    /**
     * 게시글 목록 조회
     */
    List<BoardDTO> getList(Pager pager) throws Exception;

    /**
     * 게시글 상세 조회
     */
    BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

    /**
     * 게시글 본문 등록
     */
    int setAdd(BoardDTO boardDTO) throws Exception;

    /**
     * 첨부 파일 정보 등록
     */
    int setFileAdd(FileDTO fileDTO) throws Exception;

    /**
     * 게시글 수정
     */
    int setUpdate(BoardDTO boardDTO) throws Exception;

    /**
     * 게시글 삭제
     */
    int setDelete(BoardDTO boardDTO) throws Exception;

    /**
     * 파일 상세 정보 조회
     */
    FileDTO getFileDetail(FileDTO fileDTO) throws Exception;

}