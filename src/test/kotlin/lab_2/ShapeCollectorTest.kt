package lab_2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShapeCollectorTest {

    @Test
    fun addShapeAndCountShape() {
        val black = Color(0, 0, 0, 0)
        val shape1 = Circle(5.0, black, black)
        val shape2 = Rectangle(4.2, 1.1, black, black)

        val shapeCollection = ShapeCollector()
        shapeCollection.addShape(shape1)
        shapeCollection.addShape(shape2)

        assertEquals(shapeCollection.countShapes(), 2)
    }

    @Test
    fun returnBiggest() {
        val black = Color(0, 0, 0, 0)
        val shape1 = Rectangle(5.0, 2.0, black, black)
        val shape2 = Rectangle(4.2, 2.4, black, black)

        val shapeCollection = ShapeCollector()
        shapeCollection.addShape(shape1)
        shapeCollection.addShape(shape2)

        assertEquals(shape1.calcArea(), 10.0)
    }

    @Test
    fun sumAreas() {
        val black = Color(0, 0, 0, 0)
        val shape1 = Rectangle(5.0, 2.0, black, black)
        val shape2 = Rectangle(10.0, 2.0, black, black)

        val shapeCollection = ShapeCollector()
        shapeCollection.addShape(shape1)
        shapeCollection.addShape(shape2)

        assertEquals(shapeCollection.sumAreas(), 30.0)
    }

    @Test
    fun colorBorderFilter() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color2)
        val shape3 = Circle(6.0, color1, color2)

        val shapeCollector = ShapeCollector()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        assert(shapeCollector.colorBorderFilter(color1) == listOf(shape1, shape3))
    }

    @Test
    fun fillColorFilter() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color2)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color2)
        val shape3 = Circle(6.0, color2, color2)

        val shapeCollector = ShapeCollector()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        assertEquals(shapeCollector.fillColorFilter(color2), listOf(shape1, shape2, shape3))
    }

    @Test
    fun getListOfShapes() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color2)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color2)
        val shape3 = Circle(6.0, color2, color2)

        val shapeCollector = ShapeCollector()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        assertEquals(shapeCollector.getListOfShapes(),listOf(shape1, shape2, shape3))
    }

    @Test
    fun groupedByBorderColor() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color2)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color2)
        val shape3 = Circle(6.0, color2, color2)

        val shapeCollector = ShapeCollector()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        assertEquals(shapeCollector.groupedByBorderColor(), mapOf(color1 to listOf(shape1), color2 to listOf(shape2, shape3)))
    }

    @Test
    fun groupedByFilledColor() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color1)

        val shapeCollector = ShapeCollector()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)

        assertEquals(shapeCollector.groupedByFilledColor(), mapOf(color1 to listOf(shape1, shape2)))
    }

    @Test
    fun returnCertainType() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color2)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color2)
        val shape3 = Circle(6.0, color2, color2)

        val shapeCollector = ShapeCollector()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        assertEquals(shapeCollector.returnCertainType("Circle"), listOf(shape1, shape3))

    }
}