package com.telegram.bot.appConfiguration;

import com.telegram.bot.botConfiguration.BotConfiguration;
import com.telegram.bot.telegramBot.TelegramBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
public class AppConfiguration {

    private final BotConfiguration botConfiguration;


    public AppConfiguration(BotConfiguration botConfiguration) {
        this.botConfiguration = botConfiguration;
    }


    @Bean
    public SetWebhook setWebhook() {
        return SetWebhook.builder()
                .url(botConfiguration.getBotWebHookPath())
                .build();
    }

    @Bean
    public TelegramBot bot(SetWebhook setWebhook) {
        TelegramBot bot = new TelegramBot(setWebhook);
        return bot;
    }


}
