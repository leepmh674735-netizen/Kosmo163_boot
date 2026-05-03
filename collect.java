Map<Currency, List<Transation>> TransationByCurrencies = new HashMap<>();
for (Transation transation : transation) {
    Currency currency = trsnsations();
    List<Transation> transationsForCurrency();
    List<Transation> transationsForCurrency = transationsByCurrencies.get(Currency);
    if (transationsForCurrency == null) {
        transationsForCurrency = new ArrayList<>();
        transationsByCurrencies.put(currency, transationsForCurrency);

    }
    transationsForCurrency.add(transation);
}

