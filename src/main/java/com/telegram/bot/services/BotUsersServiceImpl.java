package com.telegram.bot.services;

import com.telegram.bot.botUser.BotUser;
import com.telegram.bot.repository.BotUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BotUsersServiceImpl implements BotUsersService {
    private final BotUserDAO botUserDAO;

    @Autowired
    public BotUsersServiceImpl(BotUserDAO botUserDAO) {
        this.botUserDAO = botUserDAO;
    }

    @Transactional
    @Override
    public boolean saveOrUpdate(BotUser botUser) {
        return botUserDAO.saveOrUpdate(botUser);
    }

    @Transactional
    @Override
    public BotUser findById(Long id) {
        return botUserDAO.findById(id);
    }

    @Transactional
    @Override
    public boolean deleteById(Long id) {
        return botUserDAO.deleteById(id);
    }

    @Transactional
    @Override
    public List<BotUser> getAllBotUsers() {
        return botUserDAO.getAllBotUsers();
    }
}
