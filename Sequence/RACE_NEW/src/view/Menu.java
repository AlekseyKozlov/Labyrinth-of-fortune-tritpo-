package view;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Car;
import model.Connection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@SuppressWarnings("serial")
public class Menu extends JFrame  {
  ImagePanel imageMain, imageLogin,imageRules;
  JPanel panel, panelLogin,panelRules;
  JButton chooseCar, newGame, rulesOfTheGame, cancelLogin, okLogin, exit,back;
  JTextArea inputName, inputServerAdress;
  JLabel labelName, labelServerAdress;
  static String name;
  static String serverAdress;
  

  public Menu() {
    dispose();
    setUndecorated(true);
    setTitle("My Panel");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    imageMain = new ImagePanel();
    imageMain.setLayout(new BorderLayout());
    try {
      imageMain.setImage(ImageIO.read(new File("Tachka.jpg")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    panel = new JPanel();
    panel.setLayout(new GroupLayout(panel));
    panel.setOpaque(false);

    newGame();  
    rules();
    exitGame();

    imageMain.add(panel);
    panel.add(newGame);
    panel.add(rulesOfTheGame);
    panel.add(exit);
    // pp.setPreferredSize(Toolkit.getDefaultToolkit ().getScreenSize ());
    add(imageMain);

    // pack();
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(false);
  }

  public void newGame() {
    newGame = new JButton("New game");
    newGame.setBounds(900, 200, 200, 40);
    newGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.dispose();
        frame.setUndecorated(true);
        imageLogin = new ImagePanel();
        imageLogin.setLayout(new BorderLayout());
        try {
          imageLogin.setImage(ImageIO.read(new File("Login.jpg")));
        } catch (IOException e1) {
          e1.printStackTrace();
        }
        panelLogin = new JPanel();
        panelLogin.setLayout(new GroupLayout(panelLogin));
        panelLogin.setOpaque(false);


        inputName = new JTextArea();
        inputName.setBounds(600, 300, 400, 40);
      
        //inputName.setLineWrap(true);
        //inputName.setWrapStyleWord(true);
        inputServerAdress = new JTextArea();
       
        inputServerAdress.setBounds(600, 350, 400, 40);

        labelName = new JLabel("Your name:");
        labelName.setBounds(320, 300, 500, 40);

        labelServerAdress = new JLabel("Server adress:");
        labelServerAdress.setBounds(220, 350, 800, 40);

        cancelLogin = new JButton("Cancel");
        cancelLogin.setBounds(600, 400, 150, 40);
        cancelLogin.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
          }
        });

        okLogin = new JButton("Ok");
        okLogin.setBounds(850, 400, 150, 40);
        okLogin.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            name=inputName.getText();
            serverAdress=inputServerAdress.getText();
            serverAdress="192.168.1.1";
            //проверить на ввод информ
           frame.setVisible(false);
           createGui();
            
          }
        });

        imageLogin.add(panelLogin);
        Font font = new Font("Courier New", Font.PLAIN, 40);

        labelName.setFont(font);

        labelServerAdress.setFont(font);

        labelName.setForeground(Color.GREEN);

        labelServerAdress.setForeground(Color.GREEN);

        panelLogin.add(inputName);
        panelLogin.add(inputServerAdress);
        panelLogin.add(labelName);
        panelLogin.add(labelServerAdress);
        panelLogin.add(cancelLogin);
        panelLogin.add(okLogin);

        frame.add(imageLogin);
       // frame.setSize(500, 300);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        setVisible(false);
      }
    });
   
  }

 
  public void rules() {

    rulesOfTheGame = new JButton("Rules of the game");
   // Graphics g = null;
    //rulesOfTheGame.paintComponents(g);
    rulesOfTheGame.setBounds(900, 300, 200, 40);
    rulesOfTheGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        JFrame rules = new JFrame();
        rules.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rules.dispose();
        rules.setUndecorated(true);
        imageRules = new ImagePanel();
        imageRules.setLayout(new BorderLayout());
        try {
          imageRules.setImage(ImageIO.read(new File("Login.jpg")));
        } catch (IOException e1) {
          e1.printStackTrace();
        }
        panelRules = new JPanel();
        panelRules.setLayout(new GroupLayout(panelRules));
        panelRules.setOpaque(false);


        back= new JButton("Back");
        back.setBounds(600, 600, 150, 40);
        back.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            rules.setVisible(false);
          }
        });


        imageRules.add(panelRules);
       

        panelRules.add(back);
        

        rules.add(imageRules);
       // frame.setSize(500, 300);
        rules.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        rules.setLocationRelativeTo(null);
        rules.setVisible(true);
        rules.setResizable(false);
          }
        });
       
       
  }
  protected void paintBorder(Graphics g)
  {
      g.setColor(getForeground());

      g.drawOval(20, 20, getSize().width-20, getSize().height-20);
  }
  public void exitGame() {
    exit = new JButton("Exit");
    exit.setBounds(900, 400, 200, 40);
    exit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }

  public static void createGui() {
    Connection connection = new Connection(); 
    int[] arrayX = new int[100];
      int[] arrayY=new int[100];
    connection.runClient(serverAdress);
    Random rnd = new Random(System.currentTimeMillis());
    for(int i=0;i<100;i++){
    
      arrayX[i]=rnd.nextInt(1000);
      arrayY[i]=rnd.nextInt(1000);
    }
    Car car = new Car(1230, 160, name,arrayX,arrayY);
    Car white = new Car(0, 0, name,arrayX,arrayY);
    white.setConnection(connection);
    car.setConnection(connection);
    View view = new View(car, white);
    JFrame window = new JFrame();
    window.setContentPane(view);
    window.dispose();
    window.setUndecorated(true);
    window.setSize(Toolkit.getDefaultToolkit().getScreenSize());//setSize(1030, 730);
   // Image image = Toolkit.getDefaultToolkit().getImage("Images//audi.png");
   // window.setIconImage(image);
   // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
    window.setLocationRelativeTo(null);
   // window.setResizable(false);
    window.repaint();
   
  }
  

  public static void main(String[] args) throws IOException {
    @SuppressWarnings("unused")
    Menu menu = new Menu();
  }

}
