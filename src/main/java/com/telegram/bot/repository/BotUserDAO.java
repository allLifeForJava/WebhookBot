package com.telegram.bot.repository;

import com.telegram.bot.botUser.BotUser;

import java.util.List;

public interface BotUserDAO {

    boolean saveOrUpdate(BotUser botUser);

    BotUser findById(Long id);

    boolean deleteById(Long id);

    List<BotUser> getAllBotUsers();

}
