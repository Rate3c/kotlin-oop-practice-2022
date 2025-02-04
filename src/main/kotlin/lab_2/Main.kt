package lab_2

fun main() {

    //colors
    val black = Color(0, 0, 0, 0)
    val green = Color(0, 128, 0, 50)
    val aqua = Color(0, 255, 255, 10)
    val red = Color(255, 0,0, 0)

    //shapes
    val circle1 = Circle(4.0, black, aqua)
    val circle2 = Circle(5.0, green, aqua)
    val triangle = Triangle(3.0, 3.0,3.0,green, black)
    val rectangle = Rectangle(10.0, 5.0, aqua, black)
    val square = Square(4.0, green, black)

    //create collection
    val shapeCollection = ShapeCollector<ColoredShape2d>()
    shapeCollection.addShape(circle1)
    shapeCollection.addShape(circle2)
    shapeCollection.addShape(triangle)
    shapeCollection.addShape(rectangle)
    shapeCollection.addShape(square)

    println("\nList of shapes:\n ${shapeCollection.getListOfMyShapes()}\n")
    println("Area of circle = " + circle1.calcArea())
    println("Area of triangle = " + triangle.calcArea())
    println("Area of rectangle = " + rectangle.calcArea())
    println("Area of square = " + square.calcArea())

    //methods of collector
    println("\nThe BIGGEST shape: ${shapeCollection.returnBiggest()}\n")
    println("The SMALLEST shape: ${shapeCollection.returnSmallest()}\n")
    println("Total area size: ${shapeCollection.sumAreas()}\n")
    println("The desired shapes by border color:\n ${shapeCollection.colorBorderFilter(green)}\n")
    println("The desired shapes by fill color:\n ${shapeCollection.fillColorFilter(black)}\n")
    println("Shapes grouped by border color = ${shapeCollection.groupedByBorderColor()}\n")
    println("Shapes grouped by fill color = ${shapeCollection.groupedByFilledColor()}\n")
    println("Shapes of a certain type = ${shapeCollection.returnCertainType<Circle>()}\n")

    shapeCollection.addAll(listOf(circle1, circle2))
    println("New collection size after adding 2 shapes: ${shapeCollection.getSize()}\n")

    println("Sort shapes in ascending order of areas:")
    println(shapeCollection.getSorted(SortedByShapeArea()))

    //lab 6
    shapeCollection.addShape(Circle(2.0, black, green))
    shapeCollection.addShape(Square(7.0, aqua, red))
    shapeCollection.addShape(Rectangle(6.0, 4.0, red, black))
    shapeCollection.addShape(Triangle(3.0, 4.0, 5.0, green, red))

    val file = FileIO()
    file.outputToFile(shapeCollection.listOfShapes, "file1.txt")

    val shapeCollection2 = ShapeCollector<ColoredShape2d>()
    shapeCollection2.listOfShapes = file.inputFromFile("file1.txt").toMutableList()
    shapeCollection2.addShape(Circle(9.0, green, red))
    shapeCollection2.addShape(Rectangle(5.0, 2.0, aqua, green))
    file.outputToFile(shapeCollection2.listOfShapes, "file2.txt")
}