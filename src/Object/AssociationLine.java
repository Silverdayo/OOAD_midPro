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
        drawSolidLine(g, originPoint, endPoint);
        drawArrow(g, originPoint, endPoint, 20);

    }
}
