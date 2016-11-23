import java.net.*;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.io.*;
public class Server {

  private static final Component JFrame = null;
  ServerSocket listenSocket;
  Socket connection;
  private CarServerThread clients[] = new CarServerThread[2];
  private int counter;
  OutputStream outStream;
  DataOutputStream outDataStream;
  InputStream inStream;
  DataInputStream inDataStream;
  String message;

  boolean listening = true;

  private int findClient(int ID) {
    for (int i = 0; i < counter; i++)
      if (clients[i].getID() == ID)
        return i;
    return -1;
  }

  public synchronized void handle(int ID, String input) {
    int index = findClient(ID);
   
      for (int i = 0; i < counter; i++) {
        if (index != i)
          clients[i].send(input);
      }
  }

  public void runServer() {
    try {
      listenSocket = new ServerSocket(8930,3);

      try {
        InetAddress here = InetAddress.getLocalHost();
        String host = here.getHostName();
        JOptionPane.showMessageDialog(JFrame, "on " + host + ", port 8930\n Server Started");
      } catch (UnknownHostException e) {
      }
    } 

    catch (IOException except) {
      except.printStackTrace();
    }

    while (listening) {
      try {
        clients[counter] = new CarServerThread(this, listenSocket.accept());
        clients[counter].start();
      } catch (IOException e) {
        e.printStackTrace();
      }
      counter++;
    }

    try {
      listenSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  } 

  public static void main(String[] args) {
    Server server = new Server();
    server.runServer();
  }
}
