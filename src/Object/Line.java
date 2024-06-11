package Object;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line{
    protected Point originPoint;
    protected Point endPoint;
    protected BasicObject startShape;
    protected BasicObject endShape;
    protected Port startPort;
    protected Port endPort;

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

    public void setStartPort(Port n) {this.startPort = n;}

    public void setEndPort(Port n) {this.endPort = n;}

    public Port getStartPort() {return this.startPort;}

    public Port getEndPort() {return this.endPort;}

    public void setStartShape(BasicObject shape) {this.startShape = shape;}

    public void setEndShape(BasicObject shape) {this.endShape = shape;}

    public BasicObject getStartShape() {return this.startShape;}

    public BasicObject getEndShape() {return this.endShape;}

    public void settled(BasicObject startShape, BasicObject endShape, Port startPort, Port endPort){
        setStartShape(startShape);
        setEndShape(endShape);
        setStartPort(startPort);
        setEndPort(endPort);
        setPoint(startPort.getPosition());
        set_endPoint(endPort.getPosition());
    }

    public void reset(){
        setPoint(startPort.getPosition());
        set_endPoint(endPort.getPosition());
    }

    public void drawSolidLine(Graphics g, Point startPoint, Point endPoint){
        Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
    
        g.drawLine((int)startPoint.x, (int)startPoint.y, (int)endPoint.x, (int)endPoint.y);

    }

    public void drawHead(Graphics g, Point startPoint, Point endPoint, int Size){
        System.out.println("You did not override it.");
    }
    
}
