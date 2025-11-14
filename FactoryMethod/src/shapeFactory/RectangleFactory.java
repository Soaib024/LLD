package shapeFactory;

import shape.Rectangle;
import shape.Shape;

public class RectangleFactory extends AbstractShapeFactory {
    protected Shape factoryMethod(){
        return new Rectangle();
    }
}