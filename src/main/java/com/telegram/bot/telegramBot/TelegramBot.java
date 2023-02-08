package com.telegram.bot.telegramBot;

import com.telegram.bot.botConfiguration.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

public class TelegramBot extends SpringWebhookBot {
    @Autowired
    private BotConfiguration botConfiguration;

    public TelegramBot(SetWebhook setWebhook) {
        super(setWebhook);
    }

    @Override
    public String getBotUsername() {
        return botConfiguration.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfiguration.getBotToken();
    }

    @Override
    public String getBotPath() {
        return botConfiguration.getBotWebHookPath();
    }

    @Override
    public BotApiMethod<Message> onWebhookUpdateReceived(Update update) {
        if (update.hasMessage()) {
            return SendMessage.builder()
                    .chatId(update.getMessage().getChatId())
                    .text("hello")
                    .build();
        }
        return null;
    }
}
