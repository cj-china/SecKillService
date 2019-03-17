package game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
  private int speed=3;
  boolean left,up,right,down;
  public Plane(Image img,int x,int y) {
    this.img=img;
    this.x=x;
    this.y=y;
  }

  @Override
  public void drawSlef(Graphics g) {
    super.drawSlef(g);
    if(left){
      x-=speed;
    }
    if(up){
      y-=speed;
    }
    if(right){
      x+=speed;
    }
    if(down){
      y+=speed;
    }
  }

  public void addDirection(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT:
        left = true;
        break;
      case KeyEvent.VK_UP:
        up = true;
        break;
      case KeyEvent.VK_RIGHT:
        right = true;
        break;
      case KeyEvent.VK_DOWN:
        down = true;
        break;
    }
  }

  public void minusDirection(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT:
        left = false;
        break;
      case KeyEvent.VK_UP:
        up = false;
        break;
      case KeyEvent.VK_RIGHT:
        right = false;
        break;
      case KeyEvent.VK_DOWN:
        down = false;
        break;
    }
  }
}
