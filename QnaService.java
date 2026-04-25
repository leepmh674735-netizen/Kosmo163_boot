package com.winter.app.board.qna;

import com.winter.app.board.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {

    private final NoticeService noticeService;

    @Autowired
    private QnaMapper qnaMapper;

    QnaService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    // 답글
    public int replyCreate(QnaDTO qnaDTO) throws Exception {
        QnaDTO parent = qnaMapper.detail(qnaDTO);

        // 답글의 REF
        qnaDTO.setBoardRef(parent.getBoardRef());
        // 답글의 STEP
        qnaDTO.setBoardStep(parent.getBoardStep() + 1);

        // 답글의 DEPTH
        qnaDTO.setBoardDepth(parent.getBoardDepth() + 1);

        int result = qnaMapper.replyUpdate(parent);

        result = qnaMapper.create(qnaDTO);

        return result;

    }

}