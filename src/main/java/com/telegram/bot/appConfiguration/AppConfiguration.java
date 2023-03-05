package com.telegram.bot.appConfiguration;

import com.telegram.bot.botConfiguration.BotConfiguration;
import com.telegram.bot.telegramBot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
public class AppConfiguration {

    private final BotConfiguration botConfiguration;

    @Autowired
    public AppConfiguration(BotConfiguration botConfiguration) {
        this.botConfiguration = botConfiguration;
    }


    @Bean
    public TelegramBot bot() {
        TelegramBot bot = new TelegramBot(SetWebhook.builder()
                .url(botConfiguration.getBotWebHookPath())
                .build());

        return bot;
    }


}
