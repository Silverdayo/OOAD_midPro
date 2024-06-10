package Factory;

import java.awt.Point;

import Object.Line;

public interface ILineFactory {
    public Line LineGenerate(Point startPoint, Point endPoint);
}
