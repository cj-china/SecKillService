package game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MyGameFrame extends JFrame {
  public static final int WIDTH=500;
  public static final int height=500;
  private Image bg=GameUtil.getImage("image/bg.jpg");
  private Image planeImg=GameUtil.getImage("image/plane.png");
  private Plane plane=new Plane(planeImg,250,250);
  private Shell[] shells=new Shell[50];

  @Override
  public void paint(Graphics g) {//自动被调用，g是画笔
  /*  Font f=g.getFont();
    Color c=g.getColor();
    g.setColor(Color.YELLOW);
    g.drawLine(100,100,300,300);//画线
    g.drawRect(100,100,300,300);//画矩形
    g.drawOval(100,100,300,300);//画圆形
    g.fillRect(100,100,40,40);
    g.setFont(new Font("宋体",Font.BOLD,40));
    g.drawString("我是渣渣会",200,200);

    g.setColor(c);*/
    g.drawImage(bg,0,0,null);
    plane.drawSlef(g);

    for(int i=0;i<shells.length;i++){
      shells[i].draw(g);
    }

  }

  class PaintThread extends Thread{
    @Override
    public void run() {
      while (true){
        repaint();

        try {
          Thread.sleep(40);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }
  }

  class Monitor extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
     plane.addDirection(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
      plane.minusDirection(e);
    }
  }

  /**初始化窗口*/
  public void launchFrame(){
    setTitle("王杰的游戏作品");
    setSize(MyGameFrame.WIDTH,MyGameFrame.height);
    setLocation(50,50);
    setVisible(true);

    new PaintThread().start();

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    addKeyListener(new Monitor());

    for(int i=0;i<shells.length;i++){
      shells[i]=new Shell();
    }
  }

  public static void main(String[] args){
      MyGameFrame mGF=new MyGameFrame();
      mGF.launchFrame();
  }
}
