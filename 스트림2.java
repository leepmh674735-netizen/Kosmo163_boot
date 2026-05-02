File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
    public boolean accept(File file) {
        retrurn file.isHidden();
    }
});
File[] hiddenFiles = new File(".").listFiles(File::isHidden);

public static List<Apple> filterGreenApples(List<Apple> inventory) {
   List<Apple> result = new ArrayList<>();
   for (Apple apple :inventory) {
    if ("green".equals(apple.getColor())) {
        result.add(apple);
    }
   }
   return result;
}

public static List<Apple> filterGreenApples(List<Apple> inventory) {
   List<Apple> result = new ArrayList<>();
   for (Apple apple :inventory) {
    if (apple.getWeight() > 150) {
        result.add(apple);
    }
   }
   return result;
}
public static boolean isGreenApple(Apple apple) {
    return "green".equals(apple.getColor());
}

public static boolean isHeavyApple(Apple apple) {
    return apple.getWeight() > 150;
}

public interface Predicate<T> {
    boolean test(T t);
}

static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple :inventory) {
        if (p.test(apple)) {
            result.add(apple);
        }
    }
    return result;
}

filterApples(inventory, Apple::isGreenApple);
filterAppies(inventory, Apple::isHeavyApple);

filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
filterApples(inventory, (Apple a) -> a.getWeight() > 150);
filterApples(inventory, (Apple a) ->a.getWeight() < 80 ll "brown".equals(a.getColoe());

static <T> collectin<T> filter(collection<T> c, Predicate<T> p);
filterApples(inventory, (Apple a) -> a.getWeight() > 150);
filterApples(inventory, Apple a) -> a.getWeight() > 150);

Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
for (Transaction transaction :transactions) {
    if (transaction.getPrice() > 1000) {
        Currency currency = transation.getCurrency();
        List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
        if (transactionsForCurrency == null) {
            transationsForCurrency = new ArrayList<>();
            transactionsByCurrencies.put(currency.transactionsForCurrency);
        }
        transactionsForCurrency.add(transaction);
    }
}

import static java.util.stream.Collectors.toList;
Map<currency, List<Transaction>> transactionsByCurrencies = 
   transactions.steam()
            .fiter((Trasation t) -> t.getPrice() > 1000)
             .collect(groupingBy(groupingBy(Transaction::getCurrency));
