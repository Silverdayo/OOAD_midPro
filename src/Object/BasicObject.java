package Object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.font.*;
import java.util.ArrayList;

import Screen.Canvas;

public abstract class BasicObject extends Shape{
    protected String name;
    protected int height;
    protected int width;
    protected Font font = new Font(Font.DIALOG, Font.BOLD, 14);
    protected int portWidth = 10;
    private ArrayList<Point> ports;
    private ArrayList<Line> connectedLines = new ArrayList<Line>();

    public int getheight(){
        return this.height;
    }

    public int getwidth(){
        return this.width;
    }

    public void changeName(String name){
        
        this.name = name;
    }

    public String get_Name(){
        return this.name;
    }

    public void setPort(){
        ports = new ArrayList<Point>();
        ports.add(new Point((int)originPoint.getX(), (int)originPoint.getY() + height/2));          // 00 left
        ports.add(new Point((int)originPoint.getX() + width/2, (int)originPoint.getY()));           // 01 up
        ports.add(new Point((int)originPoint.getX() + width/2, (int)originPoint.getY() + height));  // 10 down
        ports.add(new Point((int)originPoint.getX() + width, (int)originPoint.getY() + height/2));  // 11 right
    }
    
    public Point inside(Point point){
        Point returnPoint = null;
        
        if((point.getX()>originPoint.getX() && point.getY()>originPoint.getY()) && (point.getX()<originPoint.getX() + width && point.getY()<originPoint.getY() + height)){
            returnPoint = ports.get(find_nearPort(point));
        }

        return returnPoint;
    }

    public int find_nearPort(Point point){
        int index = 0;
        double dxdy = ((double)width)/((double)height);
        double x = dxdy * (point.getY() - this.originPoint.getY()) + this.originPoint.getX();
        if(x < point.getX()) index += 1;
 
        dxdy = -dxdy;
        x = dxdy * (point.getY() - this.originPoint.getY() - (double)height) + this.originPoint.getX();
        if(Math.abs(x) < point.getX()) index += 2;


        return index;
    }

    public ArrayList<Point> getPorts(){
        return this.ports;
    }

    public void focused(Graphics g){
        for (Point it : ports) {
            g.setColor(Color.black);
            g.fillRect((int)it.getX() - portWidth/2, (int)it.getY() - portWidth/2, portWidth, portWidth);
        }
    }

    public void setPoint(Point point){
        this.originPoint.x += point.x;
        this.originPoint.y += point.y;
        setPort();
        for (Line it : connectedLines) {
            it.reset();
        }
    }

    public void add_connectedLine(Line line){
        connectedLines.add(line);
    }

    public void remove_connectedLine(Line line){
        connectedLines.remove(line);
    }

    public void mode_changeName(){
       Canvas canvas = Canvas.getCanvas();
       canvas.changeObjName();
    }
    @Override
    public Point getPoint(){
        return this.originPoint;
    }
}
