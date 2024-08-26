package arduino;
import com.fazecast.jSerialComm.SerialPort;

 //// import java.io.*;
//// https://github.com/Fazecast/jSerialComm/wiki/Nonblocking-Reading-Usage-Example
////18.08.24

public class Check2 {
    public static void main(String[] args)  throws InterruptedException {

        SerialPort comPort = SerialPort.getCommPorts()[1];

        comPort.openPort();
  //comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 5000, 0);
    ///    InputStream in = comPort.getInputStream();

        try {
            while(true) {
                //_____________________________________________________________________________________________________
                while (comPort.bytesAvailable() == 0)
                    Thread.sleep(20);

                byte[] readBuffer = new byte[comPort.bytesAvailable()];
                int numRead = comPort.readBytes(readBuffer, readBuffer.length);
                System.out.println("Read " + numRead + " bytes.");
                //_____________________________________________________________________________________________________
            ////    System.out.println(in.available());       ////
           /*     for (int j = 0; j < 50; j++) {
                    System.out.print((char) in.read());
                }                     */
                //________________________________________________________________________________________________________

                //     in.close();
            }
        }
        catch(Exception e) {}
        comPort.closePort();
            }
        }


