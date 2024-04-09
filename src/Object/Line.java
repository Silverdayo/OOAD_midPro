package Object;
import java.awt.Graphics;
import java.awt.Point;

public class Line{
    protected Point originPoint;
    protected Point endPoint;
    protected BasicObject startShape;
    protected BasicObject endShape;
    protected int startPort;
    protected int endPort;

    public Point get_endPoint(){
        return this.endPoint;
    }

    public void set_endPoint(Point point){
        this.endPoint = point;
    }

    public void drawShape(Graphics g){
        System.out.println("you did not override its.");
    }

    public void focused(Graphics g) {
        
    }

    public void setPoint(Point point) {
        this.originPoint = point;
    }

    public void setStartPort(int n) {this.startPort = n;}

    public void setEndPort(int n) {this.endPort = n;}

    public int getStartPort() {return this.startPort;}

    public int getEndPort() {return this.endPort;}

    public void setStartShape(BasicObject shape) {this.startShape = shape;}

    public void setEndShape(BasicObject shape) {this.endShape = shape;}

    public BasicObject getStartShape() {return this.startShape;}

    public BasicObject getEndShape() {return this.endShape;}

    public void settled(BasicObject startShape, BasicObject endShape, int startPort, int endPort){
        setStartShape(startShape);
        setEndShape(endShape);
        setStartPort(startPort);
        setEndPort(endPort);
        setPoint(startShape.getPorts().get(startPort));
        set_endPoint(endShape.getPorts().get(endPort));
    }

    public void reset(){
        setPoint(startShape.getPorts().get(startPort));
        set_endPoint(endShape.getPorts().get(endPort));
    }

}
