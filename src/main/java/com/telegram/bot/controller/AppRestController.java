package com.telegram.bot.controller;

import com.telegram.bot.telegramBot.TelegramBot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class AppRestController {

    private final TelegramBot bot;


    public AppRestController(TelegramBot bot) {
        this.bot = bot;
    }


    @PostMapping("/")
    public BotApiMethod onUpdateReceived(@RequestBody Update update) {

        return bot.onWebhookUpdateReceived(update);
    }

}
