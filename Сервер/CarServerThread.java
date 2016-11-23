import java.net.*;
import java.io.*;

public class CarServerThread extends Thread {
  private Socket socket = null;
  private int ID = -1;
  private Server callback = null;
  OutputStream outStream;
  DataOutputStream outDataStream;
  InputStream inStream;
  DataInputStream inDataStream;
  boolean flag = false;

  public CarServerThread(Server server, Socket socket) {
    super("CarServerThread");
    this.socket = socket;
    this.callback = server;
    this.ID = socket.getPort();

  }

  public void send(String msg) {
    try {
      outDataStream.writeUTF(msg);
      outDataStream.flush();
    } catch (IOException ioe) {
    }
  }

  public int getID() {
    return ID;
  }

  public void run() {

    try {
      outStream = socket.getOutputStream();
      outDataStream = new DataOutputStream(outStream);
      inStream = socket.getInputStream();
      inDataStream = new DataInputStream(inStream);
      String inputLine;
      while ((inputLine = inDataStream.readUTF()) != null) {
        callback.handle(ID, inputLine);
      }
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
