package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "kvakva_01_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "6710639158:AAGV7eTa_7PB5TBFXs_A1YiKKjgL6OBA4p4"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Взлом холодильника", "step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Взять сосиску! +20 славы", "step_2_btn",
                            "Взять рыбку! +20 славы", "step_2_btn",
                            "Взять огурец! +20 славы", "step_2_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            sendPhotoMessageAsync("step_3_pic");
            addUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Взлом робота-пылесоса", "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Отправить робот-пылесос за едой! +30 славы", "step_4_btn",
                            "Покататься на робот-пылесосе! +30 славы", "step_4_btn",
                            "Убежать от робот-пылесоса! +30 славы", "step_4_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Надеть и включить камеру", "step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Сфотографироваться! +40 славы", "step_6_btn",
                            "Записать видео! +40 славы", "step_6_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            sendPhotoMessageAsync("step_7_pic");
            addUserGlory(40);
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Взломать компьютер", "step_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Похвастаться другим котам", "step_8_btn"));
            addUserGlory(50);
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            sendPhotoMessageAsync("sherry");
            sendTextMessageAsync(FINAL_TEXT);
        }
        if (getMessageText().equals("/glory")) {
            sendTextMessageAsync("Накоплено *" + getUserGlory() + "* очков славы!");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}