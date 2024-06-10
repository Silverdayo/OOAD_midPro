package Factory;

import java.awt.Point;

import Object.Line;
import Object.AssociationLine;

public class AssociationLineFactory implements ILineFactory{

    @Override
    public Line LineGenerate(Point startPoint, Point endPoint) {
        return new AssociationLine(startPoint, endPoint);
    }
    
}
