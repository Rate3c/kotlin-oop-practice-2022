package lab_1

fun main() {

    val inputString =
        """            1. Divine Comedy // Dante Alighieri // 1472
            2. 1984 // George Orwell // 1949
            3. Brave New World // Aldous Huxley // 1932
            4. Animal Farm // George Orwell // 1945
            5. Death in the Afternoon // Ernest Hemingway // 1932
            6. Двенадцать стульев // Илья Ильф, Евгений Петров// 1928 """

    val shelf: List<Book> = parseBooks(inputString)

    println("\nBOOKS LIST:\n" + getList(shelf))
    println("\nThe oldest books:\n" + getList(getOldestBook(shelf)))
    println("\nThe latest books:\n" + getList(getNewestBook(shelf)))
    println("\nThe longest titled books:\n" + getList(getLongestTitle(shelf)))
    println("\nThe shortest titled books:\n" + getList(getShortestTitle(shelf)))
}
