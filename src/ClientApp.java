import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


    public class ClientApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            try (Socket socket = new Socket("localhost", 1234)) {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("Выберите пункт меню:\n1 - добавить ученика\n2 - удалить ученика\n" +
                        "3 - показать список учеников класса\n4 - редактировать данные\n" +
                        "0 - выход.");
                while (true) {
                    String request = scanner.nextLine();
                    dataOutputStream.writeUTF(request);
                    System.out.println(dataInputStream.readUTF());
                      if (request.equals("0"))
                        break;


                                    }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }

        }
    }

