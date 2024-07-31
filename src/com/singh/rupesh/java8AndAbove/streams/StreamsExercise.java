package com.singh.rupesh.java8AndAbove.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
traders are executing transactions
 */
public class StreamsExercise {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1 Find all transactions in the year 2011 and sort them by value (small to high)
        List<Transaction> sortedTransactionsOf2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        sortedTransactionsOf2011.forEach(System.out::println);

        //2 What are all the unique cities where the traders work?
        List<String> cities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        cities.forEach(System.out::println);

        //3 Find all traders from Cambridge and sort them by name.
        List<Trader> tradersFromCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity() == "Cambridge")
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        tradersFromCambridge.forEach(System.out::println);

        //4 Return a string of all traders’ names sorted alphabetically.
        String traderNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());  // is efficient for strings as internally used String Builder
                //.reduce("", (n1, n2) -> n1 + " " + n2); // concatenation is in efficient as it creates a new string at
                // every iteration

        System.out.println(traderNames);

        //5 Are any traders based in Milan?
        boolean traderInMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader()
                        .getCity()
                        .equals("Milan"));

        System.out.println("Is there any trader from Milan? : " + traderInMilan);

        //6 Print the values of all transactions from the traders living in Cambridge.
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //7 What’s the highest value of all the transactions?
        Optional<Integer> maxValue =
                transactions.stream()
                .map(Transaction::getValue)
                .reduce(Math::max);

        maxValue.ifPresent(System.out::println);

        //8 Find the transaction with the smallest value.
        Optional<Transaction> smallestTransaction =
        transactions.stream()
                .reduce((t1, t2) ->
                        t1.getValue() < t2.getValue() ? t1 : t2);

        Optional<Transaction> smallestTransaction2 =
                transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));

    }
}

class Trader{
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}

class Transaction{
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}