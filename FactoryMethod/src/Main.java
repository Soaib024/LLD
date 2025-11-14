import animal.Animal;
import document.Document;
import document.Powerpoint;
import documentFactory.PowerPointFactory;
import documentFactory.WordFactory;
import shape.Shape;
import animalFactory.*;
import shapeFactory.*;
import notification.*;

void main() {
    // Shape.Shape
    Shape circle = new CircleFactory().getShape();
    circle.draw();
    Shape rectangle = new RectangleFactory().getShape();
    rectangle.draw();
    Shape square = new SquareFactory().getShape();
    square.draw();

    ConcreteShapeFactory shapeFactory = new ConcreteShapeFactory();
    Shape circle1 = shapeFactory.getShape("circle");
    circle1.draw();
    Shape rectangle1 = shapeFactory.getShape("rectangle");
    rectangle1.draw();
    Shape square1 = shapeFactory.getShape("square");
    square1.draw();

    Shape circle2 = StaticShapeFactory.getShape("circle");
    circle2.draw();
    Shape rectangle2 = StaticShapeFactory.getShape("rectangle");
    rectangle2.draw();
    Shape square2 = StaticShapeFactory.getShape("square");
    square2.draw();

    // animal.Animal
    ConcreteAnimalFactory animalFactory = new ConcreteAnimalFactory();
    Animal duck = animalFactory.getAnimal("duck");
    duck.eat();
    duck.walk();
    Animal tiger = animalFactory.getAnimal("tiger");
    tiger.eat();
    tiger.walk();

    Animal duck1 = new DuckFactory().getAnimal();
    duck1.walk();
    duck1.eat();
    Animal tiger1 = new TigerFactory().getAnimal();
    tiger1.walk();
    tiger1.eat();

    // document.Document

    Document word = new WordFactory().getDocument();
    word.print();
    word.delete();
    Document powerpoint = new PowerPointFactory().getDocument();
    powerpoint.print();
    powerpoint.delete();

    NotificationFactory emailNotificationFactory = new EmailNotificationFactory();
    NotificationFactory smsNotificationFactory = new SMSNotificationFactory();
    NotificationFactory pushNotificationFactory = new PushNotificationFactory();


    Notification emailNotification = emailNotificationFactory.createNotification();
    emailNotification.send("1");

    Notification smsNotification = smsNotificationFactory.createNotification();
    smsNotification.send("2");

}
