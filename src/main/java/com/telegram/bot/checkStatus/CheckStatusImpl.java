package com.telegram.bot.checkStatus;

import com.telegram.bot.botUser.BotUser;
import com.telegram.bot.botUser.Position;
import com.telegram.bot.services.BotUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class CheckStatusImpl implements CheckStatus {
    private final BotUsersService botUsersService;

    @Autowired
    public CheckStatusImpl(BotUsersService botUsersService) {
        this.botUsersService = botUsersService;
    }

    @Override
    public BotUser getBotUserFromMessage(Message message) {

        BotUser botUser = botUsersService.findById(message.getChatId());

        if (botUser == null) {
            botUser = createNewBotUserFromMessage(message);
        }

        return botUser;
    }

    private BotUser createNewBotUserFromMessage(Message message) {

        BotUser botUser = new BotUser();
        botUser.setId(message.getChatId());
        botUser.setBalance(0.0);
        botUser.setPosition(Position.SET_NAME);

        botUsersService.saveOrUpdate(botUser);

        return botUser;
    }

}
