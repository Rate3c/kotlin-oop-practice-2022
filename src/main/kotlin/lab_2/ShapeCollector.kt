package lab_2

class ShapeCollector {

    private val listOfShapes: MutableList<ColoredShape2d> = mutableListOf()

    //add new shape to list
    fun addShape(shape: ColoredShape2d) {
        listOfShapes.add(shape)
    }

    //return biggest area shape
    fun returnBiggest(): String {
        var maxArea = Double.MIN_VALUE
        var biggestShape = listOfShapes[0]

        for (shape in listOfShapes) {
            if (shape.calcArea() > maxArea) {
                maxArea = shape.calcArea()
                biggestShape = shape
            }
        }
        return ("$biggestShape \nWith area: $maxArea")
    }

    //return smallest area shape
    fun returnSmallest(): String {
        var minArea = Double.MAX_VALUE
        var smallestShape = listOfShapes[0]

        for (shape in listOfShapes) {
            if (shape.calcArea() < minArea) {
                minArea = shape.calcArea()
                smallestShape = shape
            }
        }
        return ("$smallestShape \nWith area: $minArea")
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
    fun getListOfShapes(): String {
        var output = ""

        listOfShapes.forEach { output += it.toString() + "\n" }

        return output
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
        var listOfDesiredType = mutableListOf<ColoredShape2d>()
        var counter = 0

        for (shape in listOfShapes) {
            if (shape.toString().contains(desiredType)) {
                listOfDesiredType.add(shape)
                counter++
            }
        }
        if (counter == 0) {
            println("There is no such shapes type in collection\n")
        }
        return listOfDesiredType
    }

}
