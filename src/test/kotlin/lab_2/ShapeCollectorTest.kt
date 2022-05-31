package lab_2

import org.junit.Assert
import org.junit.Test

internal class ShapeCollectorTest {

    @Test
    fun addShapeAndCountShape() {
        val black = Color(0, 0, 0, 0)
        val shape1 = Circle(5.0, black, black)
        val shape2 = Rectangle(4.2, 1.1, black, black)

        val shapeCollection = ShapeCollector<ColoredShape2d>()
        shapeCollection.addShape(shape1)
        shapeCollection.addShape(shape2)

        Assert.assertEquals(shapeCollection.countShapes(), 2)
    }

    @Test
    fun returnBiggest() {
        val black = Color(0, 0, 0, 0)
        val shape1 = Rectangle(5.0, 2.0, black, black)
        val shape2 = Rectangle(4.2, 2.4, black, black)

        val shapeCollection = ShapeCollector<ColoredShape2d>()
        shapeCollection.addShape(shape1)
        shapeCollection.addShape(shape2)

        Assert.assertTrue(shape1.calcArea() == 10.0)
    }

    @Test
    fun sumAreas() {
        val black = Color(0, 0, 0, 0)
        val shape1 = Rectangle(5.0, 2.0, black, black)
        val shape2 = Rectangle(10.0, 2.0, black, black)

        val shapeCollection = ShapeCollector<ColoredShape2d>()
        shapeCollection.addShape(shape1)
        shapeCollection.addShape(shape2)

        Assert.assertTrue(shapeCollection.sumAreas() == 30.0)
    }

    @Test
    fun colorBorderFilter() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color2)
        val shape3 = Circle(6.0, color1, color2)

        val shapeCollector = ShapeCollector<ColoredShape2d>()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        Assert.assertEquals(shapeCollector.colorBorderFilter(color1), listOf(shape1, shape3))
    }

    @Test
    fun fillColorFilter() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color2)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color2)
        val shape3 = Circle(6.0, color2, color2)

        val shapeCollector = ShapeCollector<ColoredShape2d>()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        Assert.assertEquals(shapeCollector.fillColorFilter(color2), listOf(shape1, shape2, shape3))
    }

    @Test
    fun getListOfShapes() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color2)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color2)
        val shape3 = Circle(6.0, color2, color2)

        val shapeCollector = ShapeCollector<ColoredShape2d>()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        Assert.assertEquals(shapeCollector.getListOfMyShapes(),listOf(shape1, shape2, shape3))
    }

    @Test
    fun groupedByBorderColor() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color2)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color2)
        val shape3 = Circle(6.0, color2, color2)

        val shapeCollector = ShapeCollector<ColoredShape2d>()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        Assert.assertEquals(shapeCollector.groupedByBorderColor(), mapOf(color1 to listOf(shape1), color2 to listOf(shape2, shape3)))
    }

    @Test
    fun groupedByFilledColor() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color1)

        val shapeCollector = ShapeCollector<ColoredShape2d>()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)

        Assert.assertEquals(shapeCollector.groupedByFilledColor(), mapOf(color1 to listOf(shape1, shape2)))
    }

    @Test
    fun returnCertainType() {
        val color1 = Color(122, 0, 255, 50)
        val color2 = Color(0, 8, 0, 56)

        val shape1 = Circle(3.0, color1, color2)
        val shape2 = Triangle(2.0, 3.0, 4.0, color2, color2)
        val shape3 = Circle(6.0, color2, color2)

        val shapeCollector = ShapeCollector<ColoredShape2d>()
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        Assert.assertEquals(shapeCollector.returnCertainType<Circle>(), listOf(shape1, shape3))

    }

    @Test
    fun addAll() {
        val color1 = Color(155, 0, 0, 0)
        val color2 = Color(0, 155, 0, 100)
        val shape1 = Circle(3.1, color1, color2)
        val shape2 = Circle(4.2, color2, color1)
        val shapeCollection = ShapeCollector<ColoredShape2d>()
        shapeCollection.addAll(listOf(shape1, shape2))
        Assert.assertEquals(listOf(shape1, shape2), shapeCollection.getListOfMyShapes())
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
        Assert.assertEquals(listOf(triangle, circle1, circle2), shapeCollection.getSorted(SortedByShapeArea()))
    }

    @Test
    fun testSerialization() {
        val red = Color(255, 0, 0, 0)
        val blue = Color(0, 0, 255, 0)

        val square = Square(7.0, blue, red)

        val collector = ShapeCollector<ColoredShape2d>()
        collector.addShape(square)
        val expected = "[{\"type\":\"lab_2.Square\",\"side\":7.0,\"borderColor\":{\"red\":0,\"green\":0,\"blue\":255,\"transparency\":0},\"fillColor\":{\"red\":255,\"green\":0,\"blue\":0,\"transparency\":0}}]"
        Assert.assertEquals(JsonSerialization.serialization(collector.listOfShapes), expected)
    }

    @Test
    fun testDeserialization() {

        val red = Color(255, 0, 0, 0)
        val green = Color(0, 255, 0, 0)

        val stringToDecode = "[{\"type\":\"lab_2.Circle\",\"radius\":2.0,\"borderColor\":{\"red\":255,\"green\":0,\"blue\":0,\"transparency\":0},\"fillColor\":{\"red\":0,\"green\":255,\"blue\":0,\"transparency\":0}}]"
        val listShape = JsonSerialization.deserialization(stringToDecode)
        Assert.assertEquals(listShape[0], Circle(2.0, red, green))
    }
}
