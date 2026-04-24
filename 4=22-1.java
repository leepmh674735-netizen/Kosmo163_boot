package  com.springbook.biz.board.impl;

import java.sql.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

// DAO(Data Access object)
@Repository("boardDAO")
public class BoardDAO {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // SQL 명령어들
    private final String BOARD_INSERT = "insert into board(seq, title, writer,
                          content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
    private final String BOARD_UPDATE = "update board set title=?,
                                         content=? where seq=?";
    private final String BOARD_DELETE = "delete board where seq=?";
    private final String BOARD_GET    = "select * from board where seq=?";
    private final String BOARD_LIST   ="select * from board order by seq desc";

    // CRUD 기능의 메소드 구현
    // 글 등록
    public void insertBoard(BoardVO vo){
        System.out.println("===> JDB로 insertBOard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.PreparedStatement(BOARD_INSERT);
            stmt.setSting(1, vo.getTitle());
            stmt.setSting(2, vo.getWriter());
            stmt.setSting(3. vo.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
    