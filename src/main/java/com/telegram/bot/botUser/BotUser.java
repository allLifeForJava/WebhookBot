package com.telegram.bot.botUser;

import com.telegram.bot.wallet.Wallet;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "bot_users")
public class BotUser {
    @Id
    @Column(name = "user_id")
    private long id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "balance")
    private double balance;
    @Column(name = "Position")
    private Position position;
    @Transient
    @Autowired
    private Wallet wallet;

    public BotUser() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
