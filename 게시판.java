@Controller
public class InsertBoardController {

    @Requestmapping(value="/insertBoard.do")
    public String insertBoard(BoardVO vo, Board DAO boardDAO) {
        boardDAO.insertBoard(vo);
        return "getBoardList.do"; 
    }
}