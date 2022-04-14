package lab_2

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
    private val radius: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {
    override fun calcArea(): Double {
        if (radius <= 0) throw IllegalArgumentException("Radius cannot be negative or zero")
        return PI * radius.pow(2)
    }
}

data class Square(
    private val side: Double,
    override val borderColor: Color,
    override val fillColor: Color,
) : ColoredShape2d {
    override fun calcArea(): Double {
        if (side <= 0) throw IllegalArgumentException("Side cannot be negative or zero")
        return side.pow(2)
    }
}

data class Triangle(
    private val firstSide: Double,
    private val secondSide: Double,
    private val thirdSide: Double,
    override val borderColor: Color,
    override val fillColor: Color,
) : ColoredShape2d {
    override fun calcArea(): Double {
        val semiPerimeter: Double = (firstSide + secondSide + thirdSide) / 2

        if ((firstSide <= 0) || (secondSide <= 0) || (thirdSide <= 0))
            throw IllegalArgumentException("Sides cannot be negative or zero")

        //check triangle for existence
        if (firstSide + secondSide < thirdSide ||
            firstSide + thirdSide < secondSide ||
            thirdSide + secondSide < firstSide
        ) throw IllegalArgumentException("This triangle is not exist")

        return return sqrt(semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide))
    }
}

data class Rectangle(
    private val firstSide: Double,
    private val secondSide: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {
    override fun calcArea(): Double {
        if ((firstSide <= 0) || (secondSide <= 0))
            throw IllegalArgumentException("Sides cannot be negative or zero")
        return firstSide * secondSide
    }
}
