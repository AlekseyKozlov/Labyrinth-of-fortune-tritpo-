package model;

import java.net.*;
import java.io.*;

public class Connection {

  Socket connection;
  InputStream inStream;
  DataInputStream inDataStream;
  OutputStream outStream;
  DataOutputStream outDataStream;
String name;
  public void runClient(String serverAdress) {

    String host;
    try {

      try {
        InetAddress here = InetAddress.getLocalHost();
        host = here.getHostName();
      // host = JOptionPane.showInputDialog("Server Address ?", null);
       // information=new Information();
       // host=serverAdress;
     //   name=information.getName();
        System.out.println("Server: " + host);
        connection = new Socket(host, 8930);

      } catch (UnknownHostException e) {
        System.out.println("Failed to create socket to server\n");
      }
      inStream = connection.getInputStream();
      inDataStream = new DataInputStream(inStream);

      outStream = connection.getOutputStream();
      outDataStream = new DataOutputStream(outStream);

    } 

    catch (IOException except) {
      System.out.println("Network Exception");
      except.printStackTrace();
    } 

  } 
  /*public String nameClient() {
   return JOptionPane.showInputDialog("Input your name:");
  }*/

  public String receiveFromServer() throws IOException {
    return inDataStream.readUTF();
  }
  public String getName()  {
    return name;
  }

  public void closeConnection() throws IOException {
    connection.close();
  }

  public void sendToServer(int carX, int carY, int position, int circle,String name)
      throws IOException {
    outDataStream
        .writeUTF(carX + ":" + carY + ":" + position + ":" + circle +":"+name );
  }
}
