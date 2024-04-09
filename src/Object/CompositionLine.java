package Object;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
public class CompositionLine extends Line{
    public CompositionLine(Point startPoint, Point endPoint){
        this.originPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void drawShape(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
    
        g.drawLine((int)originPoint.getX(), (int)originPoint.getY(), (int)endPoint.getX(), (int)endPoint.getY());

        Point basePoint = new Point();
        basePoint.x = originPoint.x + (endPoint.x - originPoint.x) * (int)(originPoint.distance(endPoint) - 15) / (int)(originPoint.distance(endPoint));
        basePoint.y = originPoint.y + (endPoint.y - originPoint.y) * (int)(originPoint.distance(endPoint) - 15) / (int)(originPoint.distance(endPoint));

        Point vec = new Point();
        vec.x = - (endPoint.y - basePoint.y);
        vec.y = (endPoint.x - basePoint.x);

        int[] ptx = {endPoint.x , (basePoint.x + endPoint.x + vec.x)/2, basePoint.x , (basePoint.x + endPoint.x - vec.x)/2};
        int[] pty = {endPoint.y , (basePoint.y + endPoint.y + vec.y)/2 ,basePoint.y , (basePoint.y + endPoint.y - vec.y)/2 };

        g.fillPolygon(ptx, pty, 4);
    }
}
