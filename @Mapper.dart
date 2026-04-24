@Mapper
public interface MemberMapper {
    List<Member> selectAll();
    Opitional<Member> selectById(@Param("id") Long id);
    Opitional<Member> selectByEmail(@Param("email") String email);
    List<Member> selectAllOrderByAgeAsc();
    List<Member> selectAllOrderBy(@Param("order") String order, @Param("dir") String dir);
    List<Member> selectByNameLike(@Param("name") String name);
    int sekectAllCount();
    int insert(@Param("member") Member member);
    int update(@Param("member") Member member);
    int delete(@Param("member") Member member);
    int deleteByld(@Param("id") Long id);
    int deleteAll();
}