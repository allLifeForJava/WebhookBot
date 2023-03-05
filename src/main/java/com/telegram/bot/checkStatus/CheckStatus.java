package com.telegram.bot.checkStatus;

import com.telegram.bot.botUser.Position;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface CheckStatus {

    Position getPositionFromMessage (Message message);


}
