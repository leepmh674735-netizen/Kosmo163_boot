List<String> names = Arrays.asList("a", "b", "c");

names.stream()
     .filter(n -> n.startsWith("a"))
     .collect(Collectors.toList());

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private int age;
}

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // Stream 적용 예시
    public List<Member> getAdults() {
        return memberRepository.findAll()
                .stream()
                .filter(m -> m.getAge() >= 20)
                .collect(Collectors.toList());
    }

    // map 변환 (DTO 스타일)
    public List<String> getNames() {
        return memberRepository.findAll()
                .stream()
                .map(Member::getName)
                .toList();
    }
}

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/adults")
    public List<Member> adults() {
        return memberService.getAdults();
    }

    @GetMapping("/names")
    public List<String> names() {
        return memberService.getNames();
    }
}
List<List<String>> data = List.of(
        List.of("a", "b"),
        List.of("c", "d")
);

List<String> result = data.stream()
        .flatMap(List::stream)
        .toList();

long count = names.parallelStream()
        .filter(n -> n.startsWith("a"))
        .count();


CompletableFuture.supplyAsync(() -> {
    return "Hello";
}).thenApply(result -> result + " World")
  .thenAccept(System.out::println);

