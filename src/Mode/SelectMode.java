package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import Object.*;


public class SelectMode extends Mode{
    Point start, startSelect;
    ArrayList<Shape> shapes;
    public void mousePressed(MouseEvent e) {
        resetPoint();
        start = e.getPoint();
        startSelect = e.getPoint();
        Point p = new Point(e.getPoint());
        shapes = canvas.get_shapes();
        canvas.focusedShape = canvas.getInsideShape(p);
        canvas.repaint();
    }
    
    public void mouseReleased(MouseEvent e) {
        canvas.repaint();
    }

    public void mouseDragged(MouseEvent e) {
        Point point = new Point(e.getPoint());
        if(canvas.focusedShape != null){
            Point vec = new Point(point.x - start.x, point.y - start.y);
            canvas.focusedShape.setPoint(vec);
        }else{
            Point startPoint = new Point(Math.min(startSelect.x, point.x), Math.min(startSelect.y, point.y));
            Point endPoint = new Point(Math.max(startSelect.x, point.x), Math.max(startSelect.y, point.y));
            canvas.selectedArea(startPoint, endPoint);
        }
        start.x = e.getX();
        start.y = e.getY();
        canvas.repaint();
    }

    private void resetPoint(){
        canvas.resetSelectedArea();

    }

    public String getName(){
        return "select mode";
    }
}
