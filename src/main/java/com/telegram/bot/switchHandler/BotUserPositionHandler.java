package com.telegram.bot.switchHandler;

import com.telegram.bot.botUser.BotUser;
import com.telegram.bot.botUser.Position;
import com.telegram.bot.checkStatus.CheckStatus;
import com.telegram.bot.messageSendler.MessageSandler;
import com.telegram.bot.services.BotUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BotUserPositionHandler {
    private final BotUsersService botUsersService;
    private final CheckStatus checkStatus;
    private final MessageSandler messageSandler;

    @Autowired
    public BotUserPositionHandler(BotUsersService botUsersService,
                                  CheckStatus checkStatus,
                                  MessageSandler messageSandler) {
        this.botUsersService = botUsersService;
        this.checkStatus = checkStatus;
        this.messageSandler = messageSandler;
    }


    public SendMessage messageHandler(Message message) {

        BotUser user = checkStatus.getBotUserFromMessage(message);

        System.out.println("id = " + user.getId() +
                "\n" +
                "position = " + user.getPosition() +
                "\n" +
                "name = " + user.getName() +

                "\n" +
                "balance = " + user.getBalance()
        );

        switch (user.getPosition()) {


            case SET_NAME -> {

                user.setPosition(Position.SET_BALANCE);
                botUsersService.saveOrUpdate(user);

                return SendMessage.builder()
                        .text(
                                "Нам необхідно трішечки детальніше познайомитися." +
                                        "\n" +
                                        "Це дуже просто та потребує всього два кроки: ввести імя та поточний баланс." +
                                        "\n" +
                                        "Введіть імя:"
                        ).parseMode("HTML")
                        .chatId(message.getChatId())
                        .build();
            }

            case SET_BALANCE -> {

                user.setName(String.valueOf(message.getText()));
                user.setPosition(Position.CHECK_VALID_BALANCE);
                botUsersService.saveOrUpdate(user);

                return SendMessage.builder()
                        .chatId(message.getChatId())
                        .text("Приємно познайомитись, <b>" + user.getName() + "</b>"
                                + "\n" +
                                "Тепер введіть свій баланс у форматі 0000 - для цілого числа та 000000.00 - для числа з частиною.")
                        .parseMode("HTML")
                        .build();
            }
            case CHECK_VALID_BALANCE -> {


                String regEx = message.getText();
                Pattern pattern = Pattern.compile("\\d{1,20}");
                Pattern pattern2 = Pattern.compile("\\d{1,20}\\.\\d{2}");
                Matcher matcher = pattern.matcher(regEx);
                Matcher matcher2 = pattern2.matcher(regEx);


                if (matcher.find() || matcher2.find()
                        && Double.valueOf(message.getText()) >= 0) {


                    user.setBalance(Double.valueOf(message.getText()));
                    user.setPosition(Position.MAIN_MENU);
                    botUsersService.saveOrUpdate(user);

                    return SendMessage.builder()
                            .chatId(message.getChatId())
                            .text("Дуже добре, " + user.getName() +
                                    "\n" +
                                    "Ваш поточний рахунок: <b>" + user.getBalance() + "</b>" +
                                    "\n" +
                                    "Можемо починати працювати.")
                            .parseMode("HTML")
                            .build();
                } else {
//                    user.setPosition(Position.SET_BALANCE);
                    botUsersService.saveOrUpdate(user);

                    return SendMessage.builder()
                            .chatId(message.getChatId())
                            .text("Вибачте, " + user.getName() +
                                    "\n" +
                                    "Значення <b>" + message.getText() + "</b> не відповідає стандарту." +
                                    "\n" +
                                    "Введіть свій баланс у форматі 0000 - для цілого числа та 000000.00 - для числа з частиною.")
                            .parseMode("HTML")
                            .build();
                }


            }

            default -> {
                return null;
            }
        }

    }


}
