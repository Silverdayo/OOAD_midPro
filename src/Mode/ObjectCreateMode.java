package Mode;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Object.BasicObject;
import Object.BasicObjectGenerate;
public class ObjectCreateMode extends Mode{
    private BasicObject object;
    public void mousePressed(MouseEvent e) {
        object = BasicObjectGenerate.create_BasicObject(object, e.getPoint());
        canvas.addShape(object);
    }

}
