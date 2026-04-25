public static boolean isGreenApple(Apple apple){return"green".equals(apple.getColor());}public static boolean isHeavyApple(Apple apple){return apple.getWeigh()>150;}

public interface Predicate<T> {
    boolean test(T t);}

    static List<Apple> filterApples(List<Apple> inventry,
            Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        result result;
}

filterApples(inventory, Apple::isGreenApple);
 fiterApples(inventory, Apple:: isHeavyApple);

 filerApples(inventory, (Apple a) -> "green" .equals(a.getColor()));
 filterApples(inventory, (Apple a) -> a.getWeigh() > 150);
 fiterApples(invectory, (Apple a) -> a.getWeight() < 80 ll
                                       "brown".equals(a.getColor()));

static <T> Collecton<T> filter(Collection<T> c, Predicate<T> p);

fiterApples(invectory, (Apple a) -> a.getWeight() > 150);
filter(inventory, Apple a) -> a.getWeigh() > 150);