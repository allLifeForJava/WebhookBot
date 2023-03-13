package com.telegram.bot.checkStatus;

import com.telegram.bot.botUser.BotUser;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface CheckStatus {

    BotUser getBotUserFromMessage(Message message);


}
