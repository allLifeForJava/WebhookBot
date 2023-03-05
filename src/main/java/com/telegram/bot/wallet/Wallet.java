package com.telegram.bot.wallet;

public interface Wallet<T> {


    boolean addExpenses(String name, Double sum);

    boolean removeExpenses(String name, Double sum);

    boolean addSectionToWallet(String s);

    boolean removeSectionFromWallet(String s);


}
