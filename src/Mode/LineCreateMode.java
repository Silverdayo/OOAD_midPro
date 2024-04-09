package Mode;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Point;

import java.util.ArrayList;

import Object.Shape;
import Object.BasicObject;
import Object.BasicObjectGenerate;
import Object.Line;
import Screen.Canvas;

public class LineCreateMode extends Mode{

    Line line = null;

    BasicObject startShape = null;
    int startPort = -1;

    BasicObject endShape = null;
    int endPort = -1;

    Canvas canvas = Canvas.getCanvas();

    public void mousePressed(MouseEvent e) {
        reset();

        startShape = (BasicObject)canvas.getInsideShape(e.getPoint());
        if(startShape != null){
            startPort = startShape.find_nearPort(e.getPoint());
            line = BasicObjectGenerate.create_Line(line, startShape.getPorts().get(startPort), e.getPoint());
            canvas.addLine(line);
        }

    }

    public void mouseReleased(MouseEvent e) {
        endShape = (BasicObject)canvas.getInsideShape(e.getPoint());
        if(endShape != null && endShape != startShape){
            endPort = endShape.find_nearPort(e.getPoint());
            line.settled(startShape, endShape, startPort, endPort);
            startShape.add_connectedLine(line);
            endShape.add_connectedLine(line);
            canvas.repaint();
        }else{
            canvas.removeLine(line);
        }
    }

    public void mouseDragged(MouseEvent e) {
        line.set_endPoint(e.getPoint());
        canvas.repaint();
    }
    public String getName(){
        return "Association mode";
    }

    public void reset(){
        line = null;
        startShape = null;
        startPort = -1;
        endShape = null;
        endPort = -1;
    }
}
