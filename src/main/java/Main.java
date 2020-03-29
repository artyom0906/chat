import com.artyom.network.TCPConnection;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<TCPConnection> tcpConnections = new ArrayList<>();
    public static void main(String... args) throws IOException{
            Runnable target;
            new Thread(()-> {
                while (true) {
                    try (ServerSocket ss = new ServerSocket(1111)) {
                        TCPConnection tcpConnection = new TCPConnection(new Server(), ss.accept());
                        tcpConnections.add(tcpConnection);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            Scanner scanner = new Scanner(System.in);
            TCPConnection tcpConnection = new TCPConnection(new Client(), scanner.nextLine(), 1111);
            while (true){
                tcpConnection.writeBytes(scanner.nextLine().getBytes());
            }
    }
}
