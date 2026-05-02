
List<Apple> heavyApples1 = 
    inventory.stream().filter((Apple a) -> a.getWeight() > 150)
                      .collect(toList());

List<Apple> heavyApples1 = 
    inventory.parallelStream().filter((Applen a) -> a.getWeight() > 150)
                              .collect(toList());

default void sort(Comparator<? super E> c) {
    Collectors.sort(this, c);
}

def simplifyExpression(expr: Expr):Expr = expr match {
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(0)) => e
     case BinOp("/", e, Number(0)) => e
     case _ => expr
    
}