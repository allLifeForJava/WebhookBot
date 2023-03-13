package com.telegram.bot.repository;

import com.telegram.bot.botUser.BotUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BotUserDAOImpl implements BotUserDAO {

    private final EntityManager entityManager;

    @Autowired
    public BotUserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public boolean saveOrUpdate(BotUser botUser) {

        if (botUser != null) {
            entityManager.merge(botUser);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BotUser findById(Long id) {
        BotUser botUser = entityManager.find(BotUser.class, id);
        return botUser;

    }

    @Override
    public boolean deleteById(Long id) {
        if (id != null) {
            entityManager.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<BotUser> getAllBotUsers() {
        Query query = entityManager.createQuery("from BotUser ");
        List<BotUser> botUserList = new ArrayList<>(query.getResultList());
        return botUserList;
    }
}
