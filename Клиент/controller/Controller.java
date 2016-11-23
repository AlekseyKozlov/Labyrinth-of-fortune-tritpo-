package controller;

import model.Car;
import view.View;

public class Controller implements Runnable {

  private View view;
  private Car model;

  public Controller(Car model, View view) {
    this.view = view;
    this.model = model;

    (new Thread(this)).start();
  }

  public void run() {
    while (true) {
      try {
        model.updateModel1();
        view.updateView();
        Thread.sleep(10);

      } catch (Exception exc) {
        exc.printStackTrace();
        break;
      }
    }
  }

}
