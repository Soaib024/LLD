package shapeFactory;

import shape.Shape;
import shape.Square;

public class SquareFactory extends AbstractShapeFactory {
    protected Shape factoryMethod(){
        return new Square();
    }
}