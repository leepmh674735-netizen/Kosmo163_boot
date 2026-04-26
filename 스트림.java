Map<Currency, List<Transation>> transationsByCurrencies =
    new HashMap<>();
for (Transation transaction : transaction) {
    if (transaction.getPrice() > 1000) {
        Currency currency = transaction.getCurrency();
        List<Transation> transationForCurrency =
            transationsByCurrencies.get(currency);
        if (tranactionsForCurrency == null) {
            tranctionForCurrecy = new ArrayList<>();
            tranctionsByCurrencies.put(currency,tranactionsForCurrency);

        }
        tranactionsForCurrency.add(transaction);
    }
}


import static java.util.stream.Collectors.toList;
Map<Currency, List<Transation>> taransationsByCurrencies =
    transactions.stream().filter((Transation t) -> t.getPrice() > 1000)
    .collect(groupingBy(Transaction::getCurrency));