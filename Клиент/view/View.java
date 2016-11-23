package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import model.Car;
import controller.BasicController;
import controller.Controller;

public class View extends JPanel {

  private static final long serialVersionUID = 1L;
  private Car car1, car2;
  private BasicController controller;
  Graphics offGraphics;
  Dimension offDimension;
  Image offImage;

  public View(Car car, Car white) {
    this.car1 = white;
    this.car2 = car;
    this.controller = new BasicController(car, this);
    new Controller(white, this);
    init();
  }

  public void init() {
    addKeyListener(this.controller);
    setFocusable(true);
  }

  public void updateView() {
    repaint();
  }

  public void update(Graphics g) {
    @SuppressWarnings("deprecation")
    Dimension d = size();

    // Create the offscreen graphics context
    if ((offGraphics == null) || (d.width != offDimension.width)
        || (d.height != offDimension.height)) {
      offDimension = d;
     offImage = createImage(d.width,d.height);
      offGraphics = offImage.getGraphics();
    }

    Image background = Toolkit.getDefaultToolkit().getImage("Field.jpg");
    offGraphics.drawImage(background, 0, 0, this);

    if (car1.getBodyX() != 0 && car1.getBodyY() != 0)
      offGraphics.drawImage(car1.image[car1.getPosition()], car1.getBodyX(), car1.getBodyY(), this);
    offGraphics.drawImage(car2.image[car2.getPosition()], car2.getBodyX(), car2.getBodyY(), this);

    g.drawImage(offImage, 0, 0, null);

  }

  public void paint(Graphics g) {
    update(g);
    Font scoreFont = new Font("SansSerif", Font.BOLD, 30);
    g.setFont(scoreFont);

    g.setColor(Color.GREEN);
    g.drawString("Очки:", 20, 30);
    g.drawString("Игроки: ", 220, 30);

    g.setColor(Color.WHITE);
    g.drawString(" " + car2.getOchki(), 110, 30);
    g.drawString(car1.name, 350, 30);

    g.setColor(Color.YELLOW);
    g.drawString(" " + car1.ochki, 160, 30);
    g.drawString(car2.getName(), 490, 30);
   
    if (car2.getBodyX() <= 130 && car2.getBodyY() >= 650 && car1.getBodyX() >= 130 && car1.getBodyY() <= 650) {
      
      g.drawString("Game over", 600, 300);
    }
   
  if (car1.getBodyX() <= 130 && car1.getBodyY() >= 650 && car2.getBodyX() >= 130 && car2.getBodyY() <= 650) {
      
      g.drawString("Game over", 600, 300);
    }
  }
}

