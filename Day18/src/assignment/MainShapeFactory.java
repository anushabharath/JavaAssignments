/*Task 2: Factory Method
Create a ShapeFactory class that encapsulates the object creation logic of different Shape objects like Circle, Square, and Rectangle."
*/

package assignment;

public class MainShapeFactory {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // Get an object of Square and call its draw method.
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();

        // Get an object of Rectangle and call its draw method.
        Shape shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();
    }
}
