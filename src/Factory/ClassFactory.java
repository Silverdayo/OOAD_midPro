package Factory;

import java.awt.Point;

import Object.BasicObject;
import Object.Class;

public class ClassFactory implements IBasicObjectFactory{

    @Override
    public BasicObject BasicObjectGenerate(Point point) {
        return new Class(point);
    }
    
}
