package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера...");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
                map.getValue().send(message);
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Сообщение не удалось отправить.");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String receivedName;

            while (true) {
                // Метод serverHandshake должен отправлять запрос имени используя метод send класса Connection.
                connection.send(new Message(MessageType.NAME_REQUEST));

                Message receivedMessage = connection.receive();
                MessageType receivedType = receivedMessage.getType();
                receivedName = receivedMessage.getData();

                // До тех пор, пока тип сообщения полученного в ответ не будет равен MessageType.USER_NAME, запрос имени должен быть выполнен снова.
                if ((receivedType == MessageType.USER_NAME) &&
                        // 4. В случае, если в ответ пришло пустое имя, запрос имени должен быть выполнен снова.
                        (!receivedName.isEmpty() && !connectionMap.containsKey(receivedName))) break;
            }
            // После успешного проведения всех проверок, метод serverHandshake должен добавлять новую пару (имя, соединение) в connectionMap и отправлять сообщение о том, что имя было принято.
            connectionMap.put(receivedName, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));

            // Метод serverHandshake должен возвращать имя нового клиента с которым было установлено соединение.
            return receivedName;
        }

        // Добавь приватный метод void sendListOfUsers(Connection connection, String userName) throws IOException,
        // где connection – соединение с участником, которому будем слать информацию, а userName – его имя.
        private void sendListOfUsers(Connection connection, String userName) throws IOException {

            //  Пройтись по connectionMap.
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                String name = entry.getKey();
                // Команду с типом USER_ADDED и именем равным userName отправлять не нужно, пользователь и так имеет информацию о себе.
                if (name.equals(userName)) continue;

                //  У каждого элемента из п.2 получить имя клиента, сформировать команду с типом USER_ADDED и полученным именем.
                //  Отправить сформированную команду через connection.
                connection.send(new Message(MessageType.USER_ADDED, name));
            }
        }

        // Добавь приватный метод void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException,
        // где значение параметров такое же, как и у метода sendListOfUsers.
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receivedMessage = connection.receive();
                MessageType receivedType = receivedMessage.getType();
                // Если принятое сообщение – это текст (тип TEXT), то формировать новое текстовое сообщение путем конкатенации:
                // имени клиента, двоеточия, пробела и текста сообщения. Например, если мы получили сообщение с текстом «привет чат»
                // от пользователя «Боб«, то нужно сформировать сообщение «Боб: привет чат«.
                if (receivedType == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + receivedMessage.getData()));
                } else {
                    ConsoleHelper.writeMessage("Ошибка: полученное сообщение не текстовое!");
                }
            }
        }

        @Override
        public void run() {
            if (socket != null && socket.getRemoteSocketAddress() != null)
                // Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода getRemoteSocketAddress.
                ConsoleHelper.writeMessage("Было установлено соединение с удаленным адресом " + socket.getRemoteSocketAddress());

            String userName = null;
            // Создавать Connection, используя поле socket.
            try (Connection connection = new Connection(socket);) {
                // Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
                userName = serverHandshake(connection);
                // Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED)
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                // Сообщать новому участнику о существующих участниках
                sendListOfUsers(connection, userName);
                // Запускать главный цикл обработки сообщений сервером.
                serverMainLoop(connection, userName);
                // Обеспечить закрытие соединения при возникновении исключения.
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            } finally {
                if (userName != null) {
                    // если Handshake отработал и возвратил нам имя
                    // мы должны удалить запись для этого имени из connectionMap и
                    // разослать всем остальным участникам сообщение с типом USER_REMOVED и сохраненным именем.
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Cоединение с удаленным адресом закрыто");
            }
        }
    }
}
