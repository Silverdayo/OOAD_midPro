package Factory;

import java.awt.Point;

import Object.BasicObject;
import Object.UseCase;

public class UseCaseFactory implements IBasicObjectFactory{

    @Override
    public BasicObject BasicObjectGenerate(Point point) {
        return new UseCase(point);
    }
    
}
