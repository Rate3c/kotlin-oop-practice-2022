package lab_2

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.*
import java.io.File

object JsonSerialization {
    private val json = Json {
        prettyPrint = false //turn off for tests

        serializersModule = SerializersModule {
            polymorphic(ColoredShape2d::class) {
                subclass(Square::class)
                subclass(Rectangle::class)
                subclass(Triangle::class)
                subclass(Circle::class)
            }
        }
    }

    fun serialization(listOfShapes: List<ColoredShape2d>): String = json.encodeToString(listOfShapes)

    fun deserialization(stringToDecode: String): List<ColoredShape2d> = json.decodeFromString(stringToDecode)
}

class FileIO {
    fun inputFromFile(inputFile: String): List<ColoredShape2d>  {
        return JsonSerialization.deserialization(File(inputFile).readText())
    }

    fun outputToFile(listOfShapes: List<ColoredShape2d>, outputFile: String) {
        File(outputFile).writeText(JsonSerialization.serialization(listOfShapes))
    }

}