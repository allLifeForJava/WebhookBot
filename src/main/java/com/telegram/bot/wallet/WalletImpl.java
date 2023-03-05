package com.telegram.bot.wallet;

import com.telegram.bot.botUser.BotUser;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WalletImpl implements Wallet<BotUser> {

    private final Map<String, Double> wallet;

    public WalletImpl() {
        wallet = new HashMap<>();

        wallet.put("Food", 0.0);
        wallet.put("Cinema", 0.0);
        wallet.put("Sport", 0.0);
        wallet.put("Communal payments", 0.0);
        wallet.put("Gift", 0.0);
        wallet.put("Car", 0.0);
        wallet.put("Clothes", 0.0);
        wallet.put("Restaurant/Cafe/Fast_food", 0.0);

    }


    @Override
    public boolean addExpenses(String name, Double sum) {
        return false;
    }

    @Override
    public boolean removeExpenses(String name, Double sum) {
        return false;
    }

    @Override
    public boolean addSectionToWallet(String s) {
        return false;
    }

    @Override
    public boolean removeSectionFromWallet(String s) {
        return false;
    }
}
