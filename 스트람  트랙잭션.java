Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();

for (Transaction transation : transactions) { 
    if (transaction.getPrice() > 1000) {
        Currency currency = transaction.getCurrency();
        List<Transation> tranansationsForCurrency = 
        transactionsByCurrencies.get(currency);
        if (transactionsForCurrency == null) {
            tasnsactionsForCurrency = new ArrayList<>();
            transationsByCurrencise.put(currency,transationsForCurrency);

        }
        transactionForCurrency.add(transaction);

        import static java.util.stream.Collectors.toList;
        Map<Currency, List<Transation>> transactionByCurrencies = transactions.steam()
        .filter((Transation) -> t.getPrice() > 1000)
        .collect(groupongBy(Transaction::getCurrency));

    }