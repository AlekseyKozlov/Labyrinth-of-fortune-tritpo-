package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Car {
  Connection connection = new Connection();
  public String message;
  Graphics g;
  private int UP = KeyEvent.VK_UP;
  private int DOWN = KeyEvent.VK_DOWN;
  private int RIGHT = KeyEvent.VK_RIGHT;
  private int LEFT = KeyEvent.VK_LEFT;
  public int NEW_GAME = KeyEvent.VK_Q;
  public int EXIT = KeyEvent.VK_ESCAPE;
  private int position = 0;
  private boolean Collision = false;
  public int ochki=0;
  public boolean flag = false;
  public Image image[];
  public String name;
  String values[] = new String[5];
  int[] minaX = new int[100];
  int[] minaY=new int[100];
  private int bodyX;
  private int bodyY;
  boolean flagOne = true;

  public Car(int x, int y,  String name, int[] arrayX, int[] arrayY) {
    initCar(x, y, name,arrayX,arrayY);
  }

  public void initCar(int x, int y, String name ,int[] arrayX, int[] arrayY) {
    image = new Image[16];
    for (int i = 1; i <= 16; i++) {
      if (x == 0)
        image[i - 1] = Toolkit.getDefaultToolkit().getImage("CarWhite//" + (i - 1) + ".gif");
      else
        image[i - 1] =
            Toolkit.getDefaultToolkit().getImage("CarYellow//" + (i - 1) + ".gif");
    }
    for(int i=0;i<100;i++){
      
      minaX[i]=arrayX[i];
      minaY[i]=arrayY[i];
    }
    this.bodyX = x;
    this.bodyY = y;
    this.name = name;
  }

  public boolean Collision() {
   

    if (bodyX >= 45 && bodyX <= 118 && bodyY >= 42 && bodyY <= 155) {
      Collision = true;

    }
    else if (bodyX >= 212 && bodyX <= 291 && bodyY >= 0 && bodyY <= 172) {
      Collision = true;

    }
    else if (bodyX >= 356 && bodyX <= 441 && bodyY >= 76 && bodyY <= 295) {
      Collision = true;

    }
    else if (bodyX >= 623 && bodyX <= 708 && bodyY >= 265 && bodyY <= 485) {
      Collision = true;

    }
    else if (bodyX >= 248 && bodyX <= 368 && bodyY >= 347 && bodyY <= 467) {
      Collision = true;

    }
    else if (bodyX >= 140 && bodyX <= 210 && bodyY >= 216 && bodyY <= 300) {
      Collision = true;

    }
    else if (bodyX >= 0 && bodyX <= 70 && bodyY >= 206 && bodyY <= 290) {
      Collision = true;

    }
    else if (bodyX >= 225 && bodyX <= 275 && bodyY >= 540 && bodyY <= 685) {
      Collision = true;

    }
    else if (bodyX >= 70 && bodyX <= 142 && bodyY >= 400 && bodyY <= 523) {
      Collision = true;

    }
    
    
    
    else if (bodyX >= 1075 && bodyX <= 1120 && bodyY >= 600 && bodyY <= 700) {
      Collision = true;

    }
    
    else if (bodyX >= 1200 && bodyX <= 1245 && bodyY >= 490 && bodyY <= 590) {
      Collision = true;

    }
    else if (bodyX >= 1125 && bodyX <= 1170 && bodyY >= 390 && bodyY <= 490) {
      Collision = true;

    }
    else if (bodyX >= 1230 && bodyX <= 1275 && bodyY >= 255 && bodyY <= 355) {
      Collision = true;

    }
    else if (bodyX >= 955 && bodyX <= 1000 && bodyY >= 500 && bodyY <= 600) {
      Collision = true;

    }
    
    else if (bodyX >= 1115 && bodyX <= 1160 && bodyY >= 100 && bodyY <= 200) {
      Collision = true;

    }
    else if (bodyX >= 1070 && bodyX <= 1115 && bodyY >= 195 && bodyY <= 295) {
      Collision = true;

    }
    else if (bodyX >= 960 && bodyX <= 1005 && bodyY >= 40 && bodyY <= 140) {
      Collision = true;

    }
    else if (bodyX >= 935 && bodyX <= 980 && bodyY >= 295 && bodyY <= 395) {
      Collision = true;

    }
    else if (bodyX >= 855 && bodyX <= 900 && bodyY >= 660 && bodyY <= 760) {
      Collision = true;

    }
    else if (bodyX >= 715 && bodyX <= 760 && bodyY >= 590 && bodyY <= 690) {
      Collision = true;

    }
    else if (bodyX >= 435 && bodyX <= 480 && bodyY >= 660 && bodyY <= 760) {
      Collision = true;

    }
    else if (bodyX >= 545 && bodyX <= 590 && bodyY >= 515 && bodyY <= 615) {
      Collision = true;

    }
    else if (bodyX >= 390 && bodyX <= 435 && bodyY >= 470 && bodyY <= 570) {
      Collision = true;

    }
    else if (bodyX >= 805 && bodyX <= 850 && bodyY >= 390 && bodyY <= 490) {
      Collision = true;

    }
    else if (bodyX >= 515 && bodyX <= 560 && bodyY >= 280 && bodyY <= 380) {
      Collision = true;

    }
    else if (bodyX >= 450 && bodyX <= 495 && bodyY >= 5 && bodyY <= 105) {
      Collision = true;

    }
    else if (bodyX >= 710 && bodyX <= 755 && bodyY >= 0 && bodyY <= 100) {
      Collision = true;

    }
    else if (bodyX >= 570 && bodyX <= 615 && bodyY >= 70 && bodyY <= 170) {
      Collision = true;

    }
    else if (bodyX >= 780 && bodyX <= 825 && bodyY >= 160 && bodyY <= 260) {
      Collision = true;

    }
    else if (bodyX >= 855 && bodyX <= 900 && bodyY >= 215 && bodyY <= 315) {
      Collision = true;

    }
    
    
    else if (bodyX >= 1315) {
      Collision = true;

    }
    else if (bodyY <= 5) {
      Collision = true;

    }
    else if (bodyX <= 5) {
      Collision = true;

    }
    else if (bodyY >= 740) {
      Collision = true;

    }
    else if (bodyX <= 130 && bodyY >= 650) {
       UP = 0;
      DOWN = 0;
      RIGHT = 0;
      LEFT = 0;

    }
    
   
    else {
      Collision = false;
    } 
    
      for(int i=0;i<100;i++){
        if(bodyX>minaX[i]&&bodyY>minaY[i]&&bodyX<(minaX[i]+20)&&bodyY<(minaY[i]+20)){
 ochki++;   
        System.out.println("Pop");}
      }
   
 
    return Collision;

  }
  
  public void updateCar(boolean[] pressedStatus)
      throws IOException, LineUnavailableException, UnsupportedAudioFileException {
    if (pressedStatus[5] == true) {
      System.exit(0);
    }
    if (pressedStatus[0] == true) // for up arrow
    {
      System.out.println("X-" + bodyX + " Y-" + bodyY);
      if (position == 0) {
        change(0, 5);
      } else if (position == 1) {
        change(2, 5);
      } else if (position == 2) {
        change(3, 3);
      } else if (position == 3) {
        change(5, 2);
      } else if (position == 4) {
        change(5, 0);
      } else if (position == 5) {
        changeOne(5, 2);
      } else if (position == 6) {
        changeOne(3, 3);
      } else if (position == 7) {
        changeOne(2, 5);
      } else if (position == 8) {
        changeOne(0, 5);
      } else if (position == 9) {
        changeTwo(2, 5);
      } else if (position == 10) {
        changeTwo(3, 3);
      } else if (position == 11) {
        changeTwo(5, 2);
      } else if (position == 12) {
        changeTwo(5, 0);
      } else if (position == 13) {
        changeThree(5, 2);
      } else if (position == 14) {
        changeThree(3, 3);
      } else if (position == 15) {
        changeThree(2, 5);
      }

    }

    if (pressedStatus[1] == true) // down arrow
    {
      if (position == 0) {
        changeTwo(0, 5);
      } else if (position == 1) {
        changeTwo(2, 5);
      } else if (position == 2) {
        changeTwo(3, 3);
      } else if (position == 3) {
        changeTwo(5, 2);
      } else if (position == 4) {
        changeTwo(5, 0);
      } else if (position == 5) {
        changeThree(5, 2);
      } else if (position == 6) {
        changeThree(3, 3);
      } else if (position == 7) {
        changeThree(2, 5);
      } else if (position == 8) {
        changeThree(0, 5);
      } else if (position == 9) {
        change(2, 5);
      } else if (position == 10) {
        change(3, 3);
      } else if (position == 11) {
        change(5, 2);
      } else if (position == 12) {
        change(5, 0);
      } else if (position == 13) {
        changeOne(5, 2);
      } else if (position == 14) {
        changeOne(3, 3);
      } else if (position == 15) {
        changeOne(2, 5);
      }

    }

    if (pressedStatus[3] == true) // for left arrow
    {
      if (position == 0)
        position += 16;
      position -= 1;
      position = position % 16;

    }

    if (pressedStatus[2] == true) // for right arrow
    {
      position += 1;
      position = position % 16;
    }

    try {
      connection.sendToServer(bodyX, bodyY, position, ochki, name);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  // receives the message from the server and updates the positions
  public void updateModel1() {
    try {
      message = connection.receiveFromServer();
      parseMessageAndSetValues(message);
      bodyX = Integer.parseInt(values[0]);
      bodyY = Integer.parseInt(values[1]);
      position = Integer.parseInt(values[2]);
      ochki = Integer.parseInt(values[3]);
      name = values[4];

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void change(int X, int Y) {
    bodyX += X;
    bodyY -= Y;
    if (Collision()) {
      bodyX -= 2 * X;
      bodyY += 2 * Y;
    }
  }

  public void changeOne(int X, int Y) {
    bodyX += X;
    bodyY += Y;
    if (Collision()) {
      bodyX -= 2 * X;
      bodyY -= 2 * Y;
    }
  }

  public void changeTwo(int X, int Y) {
    bodyX -= X;
    bodyY += Y;
    if (Collision()) {
      bodyX += 2 * X;
      bodyY -= 2 * Y;
    }
  }

  public void changeThree(int X, int Y) {
    bodyX -= X;
    bodyY -= Y;
    if (Collision()) {
      bodyX += 2 * X;
      bodyY += 2 * Y;
    }
  }

  public void setConnection(Connection connection) {
    this.connection = connection;
  }


  public int getBodyX() {
    return bodyX;
  }

  public void setBodyX(int bodyX) {
    this.bodyX = bodyX;
  }

  public int getBodyY() {
    return bodyY;
  }

  public void setBodyY(int bodyY) {
    this.bodyY = bodyY;
  }

  public int getPosition() {
    return position;
  }

  public int getOchki() {
    return ochki;
  }

  public int getUp() {
    return UP;
  }

  public int getDown() {
    return DOWN;
  }

  public int getLeft() {
    return LEFT;
  }

  public int getRight() {
    return RIGHT;
  }

  public String getName() {
    return name;
  }

  public int getNewGame() {
    return NEW_GAME;
  }

  public int getExit() {
    return EXIT;
  }


  public void parseMessageAndSetValues(String message) {
    StringTokenizer string = new StringTokenizer(message, ":");
    int i = 0;
    while (string.hasMoreTokens()) {

      values[i] = string.nextToken();
      i++;
    }
  }
}
