import com.artyom.network.TCPConnection;
import com.artyom.network.TCPConnectionListener;

import java.io.IOException;

public class Client implements TCPConnectionListener {
    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        tcpConnection.writeBytes("hello".getBytes());
    }

    @Override
    public void onReceiveData(TCPConnection tcpConnection, int length, byte[] data) {
        System.out.println("client: "+new String(data));
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {

    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {

    }
}
