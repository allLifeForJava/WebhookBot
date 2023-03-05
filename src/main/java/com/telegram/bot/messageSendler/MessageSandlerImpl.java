package com.telegram.bot.messageSendler;

import com.telegram.bot.telegramBot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MessageSandlerImpl implements MessageSandler {
    @Autowired
    private TelegramBot bot;


    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }
}
