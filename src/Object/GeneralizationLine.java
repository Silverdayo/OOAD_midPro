package Object;

import java.awt.Graphics;
import java.awt.Point;
public class GeneralizationLine extends Line{
    public GeneralizationLine(Point startpoint, Point endPoint){
        this.originPoint = startpoint;
        this.endPoint = endPoint;
    }

    @Override
    public void drawShape(Graphics g){
        drawSolidLine(g, originPoint, endPoint);

        drawTriangel(g, originPoint, endPoint, 10);
    }

    public void drawTriangel(Graphics g, Point startPoint, Point endPoint, int size){
        Point basePoint = new Point();
        basePoint.x = startPoint.x + (endPoint.x - startPoint.x) * (int)(startPoint.distance(endPoint) - size) / (int)(startPoint.distance(endPoint));
        basePoint.y = startPoint.y + (endPoint.y - startPoint.y) * (int)(startPoint.distance(endPoint) - size) / (int)(startPoint.distance(endPoint));

        Point vec = new Point();
        vec.x = - (endPoint.y - basePoint.y);
        vec.y = (endPoint.x - basePoint.x);

        int[] ptx = {endPoint.x , basePoint.x + vec.x , basePoint.x - vec.x };
        int[] pty = {endPoint.y , basePoint.y + vec.y , basePoint.y - vec.y };

        g.fillPolygon(ptx, pty, 3);
    }
}
