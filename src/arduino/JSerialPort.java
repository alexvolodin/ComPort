package arduino;

import com.fazecast.jSerialComm.SerialPort;
import java.io.*;

public class JSerialPort {

    public static void main(String[] args) throws InterruptedException, IOException {

        SerialPort comPort = SerialPort.getCommPorts()[1];

        comPort.openPort();

        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        InputStream in = comPort.getInputStream();

        try {
            while (true) {
                while (comPort.bytesAvailable() == 0)
                    Thread.sleep(20);

                byte[] readBuffer = new byte[comPort.bytesAvailable()];
                ////   int numRead = comPort.readBytes(readBuffer, readBuffer.length);
                ////       System.out.println(numRead);

                for (int j = 0; j < readBuffer.length; ++j)
                    System.out.print((char)in.read());
            }
        }
        catch (Exception e) {e.printStackTrace();
        }
        comPort.closePort();
    }
}
