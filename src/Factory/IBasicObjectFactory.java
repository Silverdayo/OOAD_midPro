package Factory;

import java.awt.Point;

import Object.BasicObject;

public interface IBasicObjectFactory {
    public BasicObject BasicObjectGenerate(Point point);
}
