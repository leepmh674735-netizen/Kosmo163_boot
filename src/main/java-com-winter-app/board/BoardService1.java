package com.winter.app.board;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.winter.app.file.FileDTO;
import com.winter.app.pager.Pager;

public interface BoardService {

    /**
     * 게시글 목록 조회 (페이징 처리 포함)
     */
    List<BoardDTO> getList(Pager pager) throws Exception;

    /**
     * 게시글 상세 조회
     */
    BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

    /**
     * 게시글 등록 (파일 첨부 포함)
     * 
     * @return 성공 시 1, 실패 시 0
     */
    int add(BoardDTO boardDTO, MultipartFile[] attach) throws Exception;

    /**
     * 게시글 수정 (새로운 파일 첨부 포함)
     */
    int setUpdate(BoardDTO boardDTO, MultipartFile[] attach) throws Exception;

    /**
     * 게시글 삭제
     */
    int setDelete(BoardDTO boardDTO) throws Exception;

    /**
     * 파일 개별 상세 정보 조회 (다운로드 등에서 활용)
     */
    FileDTO getFileDetail(FileDTO fileDTO) throws Exception;

}