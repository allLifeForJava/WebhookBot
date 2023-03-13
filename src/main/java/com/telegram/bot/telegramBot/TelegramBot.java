package com.telegram.bot.telegramBot;

import com.telegram.bot.botConfiguration.BotConfiguration;
import com.telegram.bot.services.BotUsersServiceImpl;
import com.telegram.bot.switchHandler.BotUserPositionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

import javax.validation.constraints.NotNull;

public class TelegramBot extends SpringWebhookBot {
    @Autowired
    private BotConfiguration botConfiguration;
    @Autowired
    private BotUsersServiceImpl botUsersService;
    @Autowired
    private BotUserPositionHandler botUserPositionHandler;

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
    public BotApiMethod<Message> onWebhookUpdateReceived(@NotNull Update update) {


        Message message = update.getMessage();
        System.out.println("message id = " + message.getChatId());
        return botUserPositionHandler.messageHandler(message);


//        return null;







       /* if (update.hasMessage()) {

            Message message = update.getMessage();

            return SendMessage.builder()
                    .chatId(update.getMessage().getChatId())
                    .text("hello")
                    .build();
        }
        return null;
    }*/
    }
}
