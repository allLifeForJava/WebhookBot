package com.telegram.bot.botUser;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bot_users", schema = "my_db", catalog = "")
public class BotUsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "balance")
    private Integer balance;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotUsersEntity that = (BotUsersEntity) o;
        return userId == that.userId && Objects.equals(userName, that.userName) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, balance);
    }
}
