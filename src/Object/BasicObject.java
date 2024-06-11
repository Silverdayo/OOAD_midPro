package Object;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import Screen.Canvas;


public abstract class BasicObject{
    protected Point originPoint;
    protected int depth;
    protected String name;
    protected int height;
    protected int width;
    protected Font font = new Font(Font.DIALOG, Font.BOLD, 14);
    
    private ArrayList<Port> ports = new ArrayList<Port>();

    public Point getPoint(){
        return this.originPoint;
    }

    public int getdepth(){
        return this.depth;
    }

    public void drawShape(Graphics g){
        System.out.println("you did not override its.");
    }

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
        ports.add(new Port(Direction.LEFT));
        ports.add(new Port(Direction.UP));
        ports.add(new Port(Direction.DOWN));
        ports.add(new Port(Direction.RIGHT));
        setPortPosition();
        /*ports.add(new Point((int)originPoint.getX(), (int)originPoint.getY() + height/2));          // 00 left
        ports.add(new Point((int)originPoint.getX() + width/2, (int)originPoint.getY()));           // 01 up
        ports.add(new Point((int)originPoint.getX() + width/2, (int)originPoint.getY() + height));  // 10 down
        ports.add(new Point((int)originPoint.getX() + width, (int)originPoint.getY() + height/2));  // 11 right*/
    }

    public void setPortPosition(){
        ports.get(Direction.LEFT.ordinal()).setPosition(new Point((int)originPoint.getX(), (int)originPoint.getY() + height/2));
        ports.get(Direction.UP.ordinal()).setPosition(new Point((int)originPoint.getX() + width/2, (int)originPoint.getY()));
        ports.get(Direction.DOWN.ordinal()).setPosition(new Point((int)originPoint.getX() + width/2, (int)originPoint.getY() + height));
        ports.get(Direction.RIGHT.ordinal()).setPosition(new Point((int)originPoint.getX() + width, (int)originPoint.getY() + height/2));
    }
    
    public Point inside(Point point){
        Point returnPoint = null;
        
        if((point.getX()>originPoint.getX() && point.getY()>originPoint.getY()) && (point.getX()<originPoint.getX() + width && point.getY()<originPoint.getY() + height)){
            returnPoint = (ports.get(find_nearPort(point))).getPosition();
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

    public ArrayList<Port> getPorts(){
        return this.ports;
    }

    public void focused(Graphics g){
        for (Port it : ports) {
            it.drawPort(g);
        }
    }

    public void setPoint(Point point){
        this.originPoint.x += point.x;
        this.originPoint.y += point.y;
        setPortPosition();
        for (Port it : ports) {
            it.resetLine();
        }
    }

    public void mode_changeName(){
       Canvas canvas = Canvas.getCanvas();
       canvas.changeObjName();
    }

    public void Ungroup(){}

}
