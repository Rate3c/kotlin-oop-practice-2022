package lab_2

// comparator for according sort
class SortedByShapeArea : Comparator<ColoredShape2d> {
    override fun compare(shape1: ColoredShape2d, shape2: ColoredShape2d): Int {
        if (shape1.calcArea() < shape2.calcArea()) {
            return -1
        }
        if (shape1.calcArea() == shape2.calcArea()) {
            return 0
        }
        return 1
    }
}