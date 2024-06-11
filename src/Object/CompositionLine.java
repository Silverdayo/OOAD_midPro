package Object;
import java.awt.Graphics;
import java.awt.Point;
public class CompositionLine extends Line{
    public CompositionLine(Point startPoint, Point endPoint){
        this.originPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void drawShape(Graphics g){
        drawSolidLine(g, originPoint, endPoint);

        drawHead(g, originPoint, endPoint, 15);
    }

    @Override
    public void drawHead(Graphics g, Point startPoint, Point endPoint, int size){
        Point basePoint = new Point();
        basePoint.x = startPoint.x + (endPoint.x - startPoint.x) * (int)(startPoint.distance(endPoint) - size) / (int)(startPoint.distance(endPoint));
        basePoint.y = startPoint.y + (endPoint.y - startPoint.y) * (int)(startPoint.distance(endPoint) - size) / (int)(startPoint.distance(endPoint));

        Point vec = new Point();
        vec.x = - (endPoint.y - basePoint.y);
        vec.y = (endPoint.x - basePoint.x);

        int[] ptx = {endPoint.x , (basePoint.x + endPoint.x + vec.x)/2, basePoint.x , (basePoint.x + endPoint.x - vec.x)/2};
        int[] pty = {endPoint.y , (basePoint.y + endPoint.y + vec.y)/2 ,basePoint.y , (basePoint.y + endPoint.y - vec.y)/2 };

        g.fillPolygon(ptx, pty, 4);
    }
}
