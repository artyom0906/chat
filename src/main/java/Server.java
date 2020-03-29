import com.artyom.network.TCPConnection;
import com.artyom.network.TCPConnectionListener;

import java.util.List;

public class Server implements TCPConnectionListener {
    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
    }

    @Override
    public void onReceiveData(TCPConnection tcpConnection, int length, byte[] data) {
        System.out.println("server: "+new String(data));
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {

    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {

    }
}
