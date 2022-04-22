package lab_2

class ShapeCollector {

    private val listOfShapes: MutableList<ColoredShape2d> = mutableListOf()

    //add new shape to list
    fun addShape(shape: ColoredShape2d) {
        listOfShapes.add(shape)
    }

    //return biggest area shape
    fun returnBiggest(): ColoredShape2d {
        var maxArea = Double.MIN_VALUE

        if (listOfShapes.size == 0) {
            throw IllegalArgumentException("List of shapes is empty")
        } else {
            var biggestShape = listOfShapes[0]

            for (shape in listOfShapes) {
                if (shape.calcArea() > maxArea) {
                    maxArea = shape.calcArea()
                    biggestShape = shape
                }
            }
            return biggestShape
        }
    }

    //return smallest area shape
    fun returnSmallest(): ColoredShape2d {
        var minArea = Double.MAX_VALUE

        if (listOfShapes.size == 0) {
            throw IllegalArgumentException("List of shapes is empty")
        } else {
            var smallestShape = listOfShapes[0]

            for (shape in listOfShapes) {
                if (shape.calcArea() < minArea) {
                    minArea = shape.calcArea()
                    smallestShape = shape
                }
            }
            return smallestShape
        }
    }

    //return the sum of all areas
    fun sumAreas(): Double {
        var sum = 0.0

        for (shape in listOfShapes) {
            sum += shape.calcArea()
        }
        return sum
    }

    //searching by color of border
    fun colorBorderFilter(desiredBorderColor: Color): List<ColoredShape2d> {
        return listOfShapes.filter { it.borderColor == desiredBorderColor }
    }

    //searching by fill color
    fun fillColorFilter(desiredFilledColor: Color): List<ColoredShape2d> {
        return listOfShapes.filter { it.fillColor == desiredFilledColor }
    }

    //return list of shapes
    fun getListOfShapes(): List<ColoredShape2d> {
        return listOfShapes
    }

    //get the size of list of shapes
    fun countShapes(): Int {
        var count = 0

        for (shape in listOfShapes) {
            count++
        }
        return count  // or just listOfShapes.size()
    }

    //return shapes grouped by border color
    fun groupedByBorderColor(): Map<Color, List<ColoredShape2d>> {
        return listOfShapes.groupBy { it.borderColor }
    }

    //return shapes grouped by fill color
    fun groupedByFilledColor(): Map<Color, List<ColoredShape2d>> {
        return listOfShapes.groupBy { it.fillColor }
    }

    //return shapes of certain type
    fun returnCertainType(desiredType: String): List<ColoredShape2d> {
        val listOfDesiredType = mutableListOf<ColoredShape2d>()
        var counter = 0

        for (shape in listOfShapes) {
            if (shape.toString().contains(desiredType)) {
                listOfDesiredType.add(shape)
                counter++
            }
        }
        if (counter == 0) {
            throw IllegalArgumentException("There is no such shapes type in collection\n")
        }
        return listOfDesiredType
    }

    //didnt work out:(
    /*fun returnCertainType(Shapes: Class<out ColoredShape2d>): List<ColoredShape2d> {
        return listOfShapes.filterIsInstance(Shapes)
    }*/

}
