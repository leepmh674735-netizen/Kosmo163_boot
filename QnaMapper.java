package com.winter.app.board.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.page.Pager;

@Mapper
public interface QnaMapper {

    public Long getCount(Pager pager) throws Exception;

    // list
    public List<QnaDTO> list(Pager pager) throws Exception;

    // detail
    public QnaDTO detail(QnaDTO qnaDTO) throws Exception;

    // create
    public int create(QnaDTO qnaDTO) throws Exception;

    // update
    public int update(QnaDTO qnaDTO) throws Exception;

    // delete
    public int delete(QnaDTO qnaDTO) throws Exception;

    public int replyUpdate(QnaDTO qnaDTO) throws Exception;

}