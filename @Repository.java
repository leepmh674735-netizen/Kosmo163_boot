@Repository
public interface MemberRepository extends JpaRePository<Member, Long> {
}
@Component
@Slf4j
@RequiredArgsConstructor
public class JpaApplication implements ApplicationRunner {
    private final MemberRepository memberResitory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        memberRepository.save(Member.builder()
                 .name("윤서준")
                 .email("SeojunYoon@hanbit.co.kr")")
                 .age(10).build());
        memberRepository.save(Member.builder()
                .name("'윤광철'")
                .email("KwangcheolYoon@hanbit.co.kr")
                .age(43).build());
         }
    }