package Object;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Graphics;

public abstract class Shape {
    protected Point originPoint;
    protected int depth;

    public Point getPoint(){
        return this.originPoint;
    }


    public int getdepth(){
        return this.depth;
    }

    public void drawShape(Graphics g){
        /*System.out.println("you did not override its.");*/
    }

    public abstract Point inside(Point point);

    public abstract int find_nearPort(Point point);

    public abstract void focused(Graphics g);

    public abstract void setPoint(Point point);

    public void changeName(String name){}

    public abstract ArrayList<Point> getPorts();
}
