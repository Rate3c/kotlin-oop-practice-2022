package lab_5

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

interface Shape2d {
    fun calcArea(): Double
}

interface ColoredShape2d : Shape2d {
    val borderColor: Color
    val fillColor: Color
}

data class Circle(
    val radius: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {

    //check for existence
    init {
        if (radius <= 0) throw IllegalArgumentException("Radius cannot be negative or zero")
    }

    override fun calcArea(): Double {
        return PI * radius.pow(2)
    }
}

data class Square(
    val side: Double,
    override val borderColor: Color,
    override val fillColor: Color,
) : ColoredShape2d {

    //check for existence
    init {
        if (side <= 0) throw IllegalArgumentException("Side cannot be negative or zero")
    }

    override fun calcArea(): Double {
        return side.pow(2)
    }
}

data class Triangle(
    val firstSide: Double,
    val secondSide: Double,
    val thirdSide: Double,
    override val borderColor: Color,
    override val fillColor: Color,
) : ColoredShape2d {

    //check for existence
    init {
        if ((firstSide <= 0) || (secondSide <= 0) || (thirdSide <= 0))
            throw IllegalArgumentException("Sides cannot be negative or zero")

        //check triangle for existence
        if (firstSide + secondSide < thirdSide ||
            firstSide + thirdSide < secondSide ||
            thirdSide + secondSide < firstSide
        ) throw IllegalArgumentException("This triangle is not exist")
    }

    override fun calcArea(): Double {
        val semiPerimeter: Double = (firstSide + secondSide + thirdSide) / 2

        return sqrt(semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide))
    }
}

data class Rectangle(
    val firstSide: Double,
    val secondSide: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {

    //check for existence
    init {
        if ((firstSide <= 0) || (secondSide <= 0))
            throw IllegalArgumentException("Sides cannot be negative or zero")
    }

    override fun calcArea(): Double {
        return firstSide * secondSide
    }
}
