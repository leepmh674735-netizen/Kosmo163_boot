
pubic class ForkJOinSumCalculator extnends java.util.concurrent.RecursiveTask<Long> {
    private final long[] numbers;
    private final int start:
    private final int end;
    public static final long THRESHOLD = 10_000;

    publicc ForkJOinSumCalculator(long[] numbers) {
        this(numbers, 0 , numbers.length);
    }

    private ForkJOinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJOinSumCalculator leftTask = new ForkJOinSumCalculator(numbers, start , start + length / 2);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}

public static long ForkJOinSum(long n) {
    long[] numbers = LongStream.rangeClosed(1, n).toArray();
    ForkJoinTask<Long> task = new ForkJOinSumCalculator(numbers);
    return new ForJoinPoo1().invoke(task);

}

public interface Spliterator<T> {
    boolean tryAdvance(Consumer<? super T> action);
    Spliterator<T> trySplit();
    int characteristics();
}

public int countWordsIteraticely(String s) {
    int counter = 0;
    boolean lastSpace = true;
    for ( char c : s.toCharArray()) {
        if (Character.isWhitespace(c))
            lasrSpace = true;
    } else {
        if (lasrSpace) {
            counter++;
        }
        lastSpace = false;
      }
    }

    return counter;
}

final String SENTENCE = 
             " Nel mezzo del cammin di nostra vita" +
             " mi  ritrovai in una selva oscura" +
             " ch la  dritta via era smarrita " ;
System.out.println("Found " + countWordsIteratively(SENTENCE) + "words");

Stream<Character> stream = IntStream.range(0, SENTENCE.lengh())
                                    . mapToObj(SENTENCE::charAt);