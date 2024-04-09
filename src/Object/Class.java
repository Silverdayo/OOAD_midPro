package Object;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.*;

import Screen.Canvas;

public class Class extends BasicObject{
    final int classHeight = 150;
    final int classWidth = 100;
    final int dy = 30;

    public Class(Point origPoint, int depth){
        this.originPoint = origPoint;
        this.height = classHeight;
        this.width = classWidth;
        this.depth = depth;
        this.name = "class name";
        setPort();
    }

    @Override
    public void drawShape(Graphics g){

        g.setColor(new Color(20,20,20));  
        
        Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));

        g.drawRect((int)originPoint.getX(), (int)originPoint.getY(),  width, height); 

        int dividingLine = classHeight/3;
        g.drawLine((int)originPoint.getX(), (int)originPoint.getY() + dividingLine, (int)originPoint.getX() + classWidth, (int)originPoint.getY()+ dividingLine);
        g.drawLine((int)originPoint.getX(), (int)originPoint.getY() + dividingLine*2, (int)originPoint.getX() + classWidth, (int)originPoint.getY()+ dividingLine*2);

        int stringWidth = g.getFontMetrics(font).stringWidth(name);
		double empty = (classWidth - stringWidth)/2;
		g.setFont(font);	
		g.drawString(name, (int)originPoint.getX() + (int)empty, (int)originPoint.getY() + dy);
        
    }

    public  int getClassHeight(){
        return classHeight;
    }

    public  int getClassWidth(){
        return classWidth;
    }

}
