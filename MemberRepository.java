MemberRepository.java
@Repository
public interface MemberRepository extends CrudReposity<Member. Long> {
    @Query("SELECT * FROM member WHERE age >= 13 AND age <= 19")
    List<Member> findTeenAge();

    @Query("SELECT * FROM member WHERE age >= :min AND age <= :max")
    List<Member> findByAgeRange(int min, int max);

    // ...
}