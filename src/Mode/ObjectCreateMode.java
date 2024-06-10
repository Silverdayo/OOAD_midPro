package Mode;
import java.awt.event.MouseEvent;


import Factory.IBasicObjectFactory;
import Object.BasicObject;

public class ObjectCreateMode extends Mode{
    private BasicObject object;
    private IBasicObjectFactory iBasicObjectFactory;

    public ObjectCreateMode(IBasicObjectFactory iBasicObjectFactory){
        this.iBasicObjectFactory = iBasicObjectFactory;
    }

    public void mousePressed(MouseEvent e) {
        object = iBasicObjectFactory.BasicObjectGenerate(e.getPoint());
        canvas.addShape(object);
    }

}
