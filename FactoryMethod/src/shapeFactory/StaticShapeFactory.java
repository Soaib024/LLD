package shapeFactory;

import shape.Rectangle;
import shape.Shape;
import shape.Square;
import shape.Circle;

public class StaticShapeFactory {
    public static Shape getShape(String shape){
        if (shape == null) return null;

        if (shape.equalsIgnoreCase("circle")) return new Circle();

        if (shape.equalsIgnoreCase("rectangle")) return new Rectangle();

        if (shape.equalsIgnoreCase("square")) return new Square();

        return null;
    }
}
