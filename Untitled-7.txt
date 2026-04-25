implements 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl- api:3.0.1'
implementation 'org.glassfish.web:j=tarta.servlet.jsp.jstl:3.0.1'

spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

@Date
@AllArgsContructor
public class Member {
    private Long id;
    private String name;
    private String email;
    private Integer age;
}