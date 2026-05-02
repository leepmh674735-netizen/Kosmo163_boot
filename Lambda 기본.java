Lambda 기본
Java
Runnable r = () -> System.out.println("Hello");
👉 함수형 사고 시작
2️⃣ Predicate (filter 기반)
Java
Predicate<String> isLong = s -> s.length() > 5;
System.out.println(isLong.test("Spring"));
3️⃣ Stream filter
Java
List<String> list = List.of("a", "bb", "ccc");

list.stream()
    .filter(s -> s.length() >= 2)
    .toList();
👉 제일 중요 (실무 1순위)
4️⃣ map 변환
Java
list.stream()
    .map(String::toUpperCase)
    .toList();
5️⃣ collect
Java
List<String> result =
    list.stream()
        .filter(s -> s.startsWith("a"))
        .collect(Collectors.toList());
6️⃣ groupingBy (진짜 중요)
Java
Map<Integer, List<String>> grouped =
    list.stream()
        .collect(Collectors.groupingBy(String::length));
7️⃣ flatMap (2차원 → 1차원)
Java
List<List<String>> data = List.of(
    List.of("a", "b"),
    List.of("c", "d")
);

List<String> result =
    data.stream()
        .flatMap(List::stream)
        .toList();
8️⃣ Optional 기본
Java
Optional<String> name = Optional.ofNullable(null);

String result = name.orElse("default");
9️⃣ Optional ifPresent
Java
Optional.of("kim")
        .ifPresent(System.out::println);
🔟 CompletableFuture (비동기 핵심)
Java
CompletableFuture.supplyAsync(() -> "Hello")
    .thenApply(s -> s + " World")
    .thenAccept(System.out::println);
    