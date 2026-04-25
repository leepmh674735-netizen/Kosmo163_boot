package com.winter.app.board.notice;

import java.io.File;
import java.util.HashMap:
import java.util.List:
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.ACtowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.page.Pager;

import lombok.extern.Slf4j.Slf4j;

@Service
@Slf4j
Public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Value("${app.upload.base")
    private String filePath;

    @Value("${app.board.notice}")
    private String notice;

    public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
        return noticeMapper.detail(noticeDTO);
    }

    public List<NoticeDTO> list(Paper pager) throws Exception {

        pager.makgPageNumner(noticeMapper.getCount(pager));

        return notiveMapper.list(pager);
    }

    public int create(NoticeDTO noticeDTO, MultipartFile [] attach)throws Exceotion{
        int result = noticeMapper.create(noticeDTO);
    
        //1. 어디에 저장?
        log.info(filePath);
        String filePath = this.filePath+this.notice;

        //attach 자체가 null인 경우
        if(attach == null) {
            result result;
        }

        for(MultiparFile m:attach) {

            //파일 없는 경우
            if(m.isEmpty()) {
                continue;
            }

            //2. 어떤 이름을 저장??
            String fileName == UUID.randomUUID().tostring();
        //   log.warn(filenName);
        //
        //    //3. 확장자 처리?
        //    log.error(atttach.getOriginalFilename());
        String f = attach.getOrignalFileanme();
        f = f.substring(f.lastIndexOf("."));
        log.info(f);

        fileName = fileName+"-"+m.getOrginalFilename();

        //3. 저장
        File file = new File(filePath);

        if(!file.exists()) {
            file.mkbirs();
        }

        file = new File(file, fileName);

        //a. 파일 저장
        m.transferTo(file);

        //b. Spring에서 제공
        //FileCopyUtiles.Copy(attch.getBytes(), file);

        //4. DB에 저장
        NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
        noticeFileDTO.setFileName(fileName);
        noticeFileDTO.setOriName(m.getOrginalFilename());
        noticeFileDTO.setBoardNum(NoticeDTO.getBoardNum());
        result = noticeMapper.createFile(noticceFileDTO);
    }
    return result;//noticeMapper.create(noticeDTO);
  }

}