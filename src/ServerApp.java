
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидает соединения....");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился к серверу!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            School school = new School();

            while (true) {
                String clientRequest = dataInputStream.readUTF();
                if (clientRequest.equals("0")) {
                    break;
                }

                else if (clientRequest.equals("1")) {
                    dataOutputStream.writeUTF("Введите имя ученика: ");
                    String clientName = dataInputStream.readUTF();
                    dataOutputStream.writeUTF("Введите номер телефона ученика: ");
                    int clientPhone = Integer.parseInt(dataInputStream.readUTF());
                    dataOutputStream.writeUTF("Введите класс ученика: ");
                    int clientGroup = Integer.parseInt(dataInputStream.readUTF());

                    dataOutputStream.writeUTF(school.listStudent(clientName, clientPhone, clientGroup) +"\n" + "Выберите пункт меню:\n" +
                            "1 - добавить ученика\n2 - удалить ученика\n" +
                            "3 - показать список учеников класса\n4 - редактировать данные\n" +
                            "0 - выход.");

                } else if (clientRequest.equals("2")) {
                    dataOutputStream.writeUTF("Введите имя ученика: ");
                    String clientName = dataInputStream.readUTF();
                    dataOutputStream.writeUTF("Введите номер телефона ученмка ");
                    int clientPhone = Integer.parseInt(dataInputStream.readUTF());

                    dataOutputStream.writeUTF(school.delFromList(clientName, clientPhone)+ "\n" + "Выберите пункт меню:\n" +
                            "1 - добавить ученика\n2 - удалить ученика\n" +
                            "3 - показать список учеников класса\n4 - редактировать данные\n" +
                            "0 - выход.");

                } else if (clientRequest.equals("3")) {
                    dataOutputStream.writeUTF("Введите номер класса: ");
                    int clientGroup = Integer.parseInt(dataInputStream.readUTF());
                    dataOutputStream.writeUTF((school.getList(clientGroup))+ "\n" + "Выберите пункт меню:\n" +
                            "1 - добавить ученика\n2 - удалить ученика\n" +
                            "3 - показать список учеников класса\n4 - редактировать данные\n" +
                            "0 - выход.");

                } else if (clientRequest.equals("4")) {
                    dataOutputStream.writeUTF("Введите имя ученика для изменения информации: ");
                    String clientName = dataInputStream.readUTF();
                    dataOutputStream.writeUTF("Введите новый номер телефона ученика: ");
                    int clientPhone = Integer.parseInt(dataInputStream.readUTF());
                    dataOutputStream.writeUTF("Введите новый класс ученика: ");
                    int clientGroup = Integer.parseInt(dataInputStream.readUTF());

                    dataOutputStream.writeUTF(school.editStudent(clientName, clientPhone, clientGroup) + "\n" + "Выберите пункт меню:\n" +
                            "1 - добавить ученика\n2 - удалить ученика\n" +
                            "3 - показать список учеников класса\n4 - редактировать данные\n" +
                            "0 - выход.");
                }

                else {
                    dataOutputStream.writeUTF("Некорректный запрос.");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
