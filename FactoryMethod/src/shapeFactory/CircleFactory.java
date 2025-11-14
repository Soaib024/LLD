package shapeFactory;

import shape.Shape;
import shape.Circle;

public class CircleFactory extends AbstractShapeFactory {
    protected Shape factoryMethod(){
        return new Circle();
    }
}