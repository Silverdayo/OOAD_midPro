package Object;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class AssociationLine extends Line{

    Point left = new Point(-15,15);
    Point right = new Point(-15,-15);

    public AssociationLine(Point startPoint, Point endPoint){
        this.originPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void drawShape(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
    
        g.drawLine((int)originPoint.getX(), (int)originPoint.getY(), (int)endPoint.getX(), (int)endPoint.getY());

        Point basePoint = new Point();
        basePoint.x = originPoint.x + (endPoint.x - originPoint.x) * (int)(originPoint.distance(endPoint) - 10) / (int)(originPoint.distance(endPoint));
        basePoint.y = originPoint.y + (endPoint.y - originPoint.y) * (int)(originPoint.distance(endPoint) - 10) / (int)(originPoint.distance(endPoint));

        Point vec = new Point();
        vec.x = - (endPoint.y - basePoint.y);
        vec.y = (endPoint.x - basePoint.x);

        g.drawLine((int)endPoint.getX(), (int)endPoint.getY(), basePoint.x + vec.x , basePoint.y + vec.y );
        g.drawLine((int)endPoint.getX(), (int)endPoint.getY(), basePoint.x - vec.x , basePoint.y - vec.y);

    }
}
