package lab_2

class ShapeCollector<T: ColoredShape2d> {

    var listOfShapes: MutableList<T> = mutableListOf()

    //add new shape to list
    fun addShape(shape: T) {
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
    fun colorBorderFilter(desiredBorderColor: Color): List<T> {
        return listOfShapes.filter { it.borderColor == desiredBorderColor }
    }

    //searching by fill color
    fun fillColorFilter(desiredFilledColor: Color): List<T> {
        return listOfShapes.filter { it.fillColor == desiredFilledColor }
    }

    //return list of shapes
    fun getListOfMyShapes(): List<T> {
        return listOfShapes.toList()
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
    fun groupedByBorderColor(): Map<Color, List<T>> {
        return listOfShapes.groupBy { it.borderColor }
    }

    //return shapes grouped by fill color
    fun groupedByFilledColor(): Map<Color, List<T>> {
        return listOfShapes.groupBy { it.fillColor }
    }

    inline fun <reified Type> returnCertainType(): List<T> {
        return if (listOfShapes.isEmpty())
            emptyList()
        else {
            val newList = mutableListOf<T>()
            for (shape in listOfShapes) {
                if (shape is Type) {
                    newList.add(shape)
                }
            }
            return newList
        }
    }

    //add new list of shapes to other list of shapes
    fun addAll(list: List<T>) {
        list.forEach { listOfShapes.add(it) }
    }

    //return sorted list of shapes
    fun getSorted(comparator: Comparator<T>): List<T>
    {
        return listOfShapes.sortedWith(comparator)
    }

    fun getSize(): Int{
        return listOfShapes.size
    }
}
