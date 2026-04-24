@Mapper
public interface ArtcleMapper {
    @Select("SELECT * FROM article")
    List<Article> selectAll();

    @Select("SELECT COUNT(*) FROM article")
    int selectAllCount();
    
    @Select("SELECT * FROM article WHERE id=#{id}")
    Opitional<Article> selectByld(@Param("id") Long id);

    @Select("SELECT * FROM article WHERE member_id=#{memberId}")
    @ResultMap("articleResult")
    List<Article> selectByMemberId(@Param("memberId") Long memberId);

    @Select("SELECT COUNT(*) FROM article")
    int selectAllCount();


    // ...
}
