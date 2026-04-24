SpringJdbcApplication.java
@Component
@RequiredArgsConstructor
@Slf4j
public class SpringJdbcApplication implements ApplicationRunner {
    private final MemberResitory memberResitory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // create
        Member member = Membern.builder()
                 .name("정혁")
                 .email("HyeokJung@hanbit.co.kr").age(10).build();
        memberResitory.save(member);

        // update
        member.setAge(11);
        memberResitory.save(member);
      }
  }