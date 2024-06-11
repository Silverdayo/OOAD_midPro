package Object;

import java.awt.Graphics;
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
        drawSolidLine(g, originPoint, endPoint);
        drawArrow(g, originPoint, endPoint, 10);
    }

    public void drawArrow(Graphics g, Point startPoint, Point endPoint, int size){
        Point basePoint = new Point();
        basePoint.x = startPoint.x + (endPoint.x - startPoint.x) * (int)(startPoint.distance(endPoint) - size) / (int)(startPoint.distance(endPoint));
        basePoint.y = startPoint.y + (endPoint.y - startPoint.y) * (int)(startPoint.distance(endPoint) - size) / (int)(startPoint.distance(endPoint));

        Point vec = new Point();
        vec.x = - (endPoint.y - basePoint.y);
        vec.y = (endPoint.x - basePoint.x);

        g.drawLine((int)endPoint.getX(), (int)endPoint.getY(), basePoint.x + vec.x , basePoint.y + vec.y );
        g.drawLine((int)endPoint.getX(), (int)endPoint.getY(), basePoint.x - vec.x , basePoint.y - vec.y);
    }
}
