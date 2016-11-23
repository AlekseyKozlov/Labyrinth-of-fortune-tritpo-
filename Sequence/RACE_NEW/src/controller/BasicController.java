package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Car;
import view.View;

public class BasicController implements KeyListener, Runnable {

  private View view;
  private Car car;
  public boolean UpPressed, DownPressed, RightPressed, LeftPressed, newGame, exit;
  public boolean[] pressedStatus = {false, false, false, false, false, false};
  boolean flag = true;

  public BasicController(Car model, View view) {
    this.view = view;
    this.car = model;
    (new Thread(this)).start();
  }

  @Override
  public void keyPressed(KeyEvent ke) {

    if (ke.getKeyCode() == car.getUp()) {
      pressedStatus[0] = true;
    }
    else if (ke.getKeyCode() == car.getDown()) {
      pressedStatus[1] = true;
    }
    else if (ke.getKeyCode() == car.getRight()) {
      pressedStatus[2] = true;
    }
    else if (ke.getKeyCode() == car.getLeft()) {
      pressedStatus[3] = true;
    } else if (ke.getKeyCode() == car.getNewGame()) {
      pressedStatus[4] = true;
    } else if (ke.getKeyCode() == car.getExit()) {
      pressedStatus[5] = true;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

    if (e.getKeyCode() == car.getUp()) {
      pressedStatus[0] = false;
    }
    else if (e.getKeyCode() == car.getDown()) {
      pressedStatus[1] = false;
    }
    else if (e.getKeyCode() == car.getRight()) {
      pressedStatus[2] = false;
    }
    else if (e.getKeyCode() ==car.getLeft()) {
      pressedStatus[3] = false;
    } else if (e.getKeyCode() == car.getNewGame()) {
      pressedStatus[4] = false;
    } else if (e.getKeyCode() == car.getExit()) {
      pressedStatus[5] = false;
    }
  }

  public void run() {
    while (true) {
      try {
        car.updateCar(pressedStatus);
        view.updateView();
        Thread.sleep(50);
      } catch (Exception exc) {
        exc.printStackTrace();
        break;
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent arg0) {
    // TODO Auto-generated method stub
    
  }
}
