@Builder
@EqualsAndHashCode(of = {"name", "price"})
 public class Product {
    private String name;
    private String description;
    private int price;
 }
 Product p1 = Product.buider().name("바나나").description("맛있는 상품").
 print(1000).build();
Product p2 = Product.builder().name("바나나").description("신선한 상품").
print(1000).build();
System.out.println("p1.equals(p2) " +p1.equals(p2));