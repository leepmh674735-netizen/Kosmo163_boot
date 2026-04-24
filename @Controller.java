@Controller
public class MemberController {
    private List<Member> members = List.of(
            new Member(1L, "윤서준", "SeojunYoon@hanbit.co.kr", 10),
            new Member(2L, "윤광철", "KwangchelYoon@hanbit.co.kr", 43),
            new Member(3L, "공미영", "MiyeongKong@hanbot.co.kr", 21),
            new Member(4L, "김도윤", "DoyunKim@hanbit.co.kr", 10)
    );
    
    @GetMapping("/member/list")
    public String getMembers(Model model) {
        model.addAttribute("members", memders);
            return "member-list";
        }
    }