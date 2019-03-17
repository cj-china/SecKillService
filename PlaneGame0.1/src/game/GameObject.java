package game;

import java.awt.*;

/**
 * 游戏物体的父类
 */
public class GameObject {
  Image img;
  int x;
  int y;
  int width;
  int height;
  int speed;

  public void drawSlef(Graphics g){
    g.drawImage(img,x,y,null);
  }

  public Rectangle getRect(){
    return new Rectangle(x,y,width,height);
  }
}
