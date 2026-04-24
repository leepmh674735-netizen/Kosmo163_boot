@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private Interger age;
}