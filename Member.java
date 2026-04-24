MyBatis
@Table
@Data 
@Builder
@AllArgsControllor
@NoArgsConstructor
public class Member {
    @Id
    private Long id;
    private String name;
    private String email;
    private Integer age;
}