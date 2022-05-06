package lab_5

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShapeCollectorTest {

    @Test
    fun addAll() {
        val color1 = Color(155, 0, 0, 0)
        val color2 = Color(0, 155, 0, 100)
        val shape1 = Circle(3.1, color1, color2)
        val shape2 = Circle(4.2, color2, color1)
        val shapeCollection = ShapeCollector<ColoredShape2d>()
        shapeCollection.addAll(listOf(shape1, shape2))
        assertEquals(listOf(shape1, shape2), shapeCollection.getListOfShapes())
    }

    @Test
    fun getSorted() {
        //colors
        val black = Color(0, 0, 0, 0)
        val green = Color(0, 128, 0, 50)
        val aqua = Color(0, 255, 255, 10)

        //shapes
        val circle1 = Circle(4.0, black, aqua)
        val circle2 = Circle(5.0, green, aqua)
        val triangle = Triangle(3.0, 3.0,3.0,green, black)

        val shapeCollection = ShapeCollector<ColoredShape2d>()
        shapeCollection.addShape(circle1)
        shapeCollection.addShape(circle2)
        shapeCollection.addShape(triangle)
        assertEquals(listOf(triangle, circle1, circle2), shapeCollection.getSorted(SortedByShapeArea()))
    }
}