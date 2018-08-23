package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BotClient extends Client {
    public static void main(String[] args) {
        Client botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int number = (int) (Math.random() * 100);
        return "date_bot_" + number;
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, " +
                    "месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            if (!message.contains(":")) return; // пропустить сообщение, если оно не формата userName: text

            String name = message.split(": ")[0];
            String text = message.split(": ")[1];
            try {
                if ("дата".equals(text)) {
                    sendLocalTextMessage(name, "d.MM.YYYY");
                } else if ("день".equals(text)) {
                    sendLocalTextMessage(name, "d");
                } else if ("месяц".equals(text)) {
                    sendLocalTextMessage(name, "MMMM");
                } else if ("год".equals(text)) {
                    sendLocalTextMessage(name, "YYYY");
                } else if ("время".equals(text)) {
                    sendLocalTextMessage(name, "H:mm:ss");
                } else if ("час".equals(text)) {
                    sendLocalTextMessage(name, "H");
                } else if ("минуты".equals(text)) {
                    sendLocalTextMessage(name, "m");
                } else if ("секунды".equals(text)) {
                    sendLocalTextMessage(name, "s");
                }
            } catch (IOException e) {
            }

        }

        private void sendLocalTextMessage(String name, String pattern) throws IOException {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
            String text = "Информация для " + name + ": " + sdf.format(Calendar.getInstance().getTime());
            sendTextMessage(text);
        }
    }
}

