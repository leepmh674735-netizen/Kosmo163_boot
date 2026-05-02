class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.conter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ?
                   this :
                   new WordCounter(counter, true);
        } else {
            return lastSpace ?
                   new WordCounter(counter + 1, false):
                   this;
        }
    }

    public WordCounter cobine(WordCounter WordCounter) {
        return new WordCounter(counter + wordCounter.cuner, wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}

private int countWords(Stream<Chaeacter>uce() stream) {
    WoredCounter wordCounter = steam.reduce(new WordCouner(0, true), WordCounter::accumulate, wordCOounter:: combine);

    return wordCounter.getCounter();
}
Stream<character> stream = IntStream.range(0, SENTENCE.lengh()),maptozobj(SENTENCE::charAt);
System.out.println ("Found " + countWords(stream) + "words");