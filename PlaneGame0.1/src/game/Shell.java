package game;

import java.awt.*;

public class Shell extends GameObject {
  private double degree;
  public Shell(){
    x=200;
    y=200;
    width=10;
    height=10;
    speed=3;
    degree=Math.random()*Math.PI*2;
  }

  public void draw(Graphics g){
    Color c=g.getColor();
    g.setColor(Color.YELLOW);
    g.fillOval(x,y,width,height);
    x+=speed*Math.cos(degree);
    y+=speed*Math.sin(degree);
    g.setColor(c);
    if(y<=30||y>=MyGameFrame.height-10){
      degree=-degree;
    }
    if(x<=0||x>=MyGameFrame.WIDTH-width) {
      degree=Math.PI-degree;

    }


  }
}
