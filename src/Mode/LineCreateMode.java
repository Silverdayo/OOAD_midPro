package Mode;
import java.awt.event.MouseEvent;

import Factory.ILineFactory;

import Object.BasicObject;
import Object.Line;
import Object.Port;

import Screen.Canvas;

public class LineCreateMode extends Mode{
    private ILineFactory iLineFactory;

    Line line = null;

    BasicObject startShape = null;
    Port startPort = null;

    BasicObject endShape = null;
    Port endPort = null;

    Canvas canvas = Canvas.getCanvas();

    public LineCreateMode(ILineFactory ILineFactory){
        this.iLineFactory = ILineFactory;
    }

    public void mousePressed(MouseEvent e) {
        reset();

        startShape = canvas.getInsideShape(e.getPoint());
        if(startShape != null){
            startPort = startShape.getPorts().get(startShape.find_nearPort(e.getPoint()));
            line = iLineFactory.LineGenerate(startPort.getPosition(), e.getPoint());
            canvas.addLine(line);
        }

    }

    public void mouseReleased(MouseEvent e) {
        endShape = canvas.getInsideShape(e.getPoint());
        if(endShape != null && endShape != startShape){
            endPort = endShape.getPorts().get(endShape.find_nearPort(e.getPoint()));
            line.settled(startShape, endShape, startPort, endPort);
            startPort.addLine(line);
            endPort.addLine(line);
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
        startPort = null;
        endShape = null;
        endPort = null;
    }
}
