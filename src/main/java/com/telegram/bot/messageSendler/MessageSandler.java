package com.telegram.bot.messageSendler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface MessageSandler {

    void sendMessage(SendMessage sendMessage);

}
