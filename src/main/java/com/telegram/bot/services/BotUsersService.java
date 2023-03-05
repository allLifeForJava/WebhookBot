package com.telegram.bot.services;

import com.telegram.bot.botUser.BotUser;

import java.util.List;

public interface BotUsersService {

    public boolean saveOrUpdate(BotUser botUser);

    BotUser findById(Long id);

    boolean deleteById(Long id);

    List<BotUser> getAllBotUsers();


}
