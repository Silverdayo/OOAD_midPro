package Object;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
public class GeneralizationLine extends Line{
    public GeneralizationLine(Point startpoint, Point endPoint){
        this.originPoint = startpoint;
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

        int[] ptx = {endPoint.x , basePoint.x + vec.x , basePoint.x - vec.x };
        int[] pty = {endPoint.y , basePoint.y + vec.y , basePoint.y - vec.y };

        g.fillPolygon(ptx, pty, 3);
    }
}
