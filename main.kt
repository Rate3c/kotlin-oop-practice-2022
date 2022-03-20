package lab_1

fun parseBooks(books:String): List<Book>{

    if (books.isEmpty()){   //if list of books is empty
        throw error("Input is empty")
    }

    var bookAuthors: List<String>
    var bookTitle: String
    var bookYear: Int
    val markDot = ('.')
    val markComma = (',')
    val markParse = ("//")
    val markNewLine = ('\n')
    var stringOfAuthors: String
    val inputText:String = books
    val listOfBooks: MutableList<Book> = mutableListOf() //allows to add and remove elements.
    var doneBook: String

    val inputToBooks: List<String> = inputText.split(markNewLine) //split the input list into an array of books

    for (bookIndex in inputToBooks){
        doneBook = bookIndex
        doneBook = doneBook.substringAfter(markDot).trim() //discard ID of the book
        bookTitle = doneBook.substringBefore(markParse).trim() //get title of the book

        if (bookTitle.isEmpty()) throw error("At least one title is missing")

        doneBook = doneBook.substringAfter(markParse).trim() //discard the title
        stringOfAuthors = doneBook.substringBefore(markParse).trim() //get the authors
        bookAuthors = stringOfAuthors.split(markComma) // split book authors to list of book authors

        if(bookAuthors.isEmpty()) throw error("At least one of the books is missing author")

        doneBook = doneBook.substringAfter(markParse).trim() //discard the authors

        if (doneBook.isEmpty()) throw error("At least one of the book is missing the year of publishing")

        bookYear = doneBook.toInt() //get the year of publishing

        if (bookYear < 1 || bookYear > 2022) throw error("The year of publishing is not correct")

        val ourBook = Book(bookTitle, bookAuthors, bookYear) //costructor
        listOfBooks.add(ourBook)
    }

    return listOfBooks
}

//check if we have any books and throw exception if not
fun shelfIsEmpty(shelf: List<Book>) {
    if (shelf.isEmpty()) {
        throw IllegalArgumentException("There are no books on the shelf")
    }
}

//get the list of books with the oldest year of publishing
fun getOldestBook(shelf: List<Book>) : List<Book> {

    shelfIsEmpty(shelf)

    var oldestYear = Int.MAX_VALUE

    for (book in shelf){
         if (book.year < oldestYear) oldestYear = book.year
    }

    return shelf.filter { it.year == oldestYear }
}

//get the list of books with the latest year of publishing
fun getNewestBook(shelf: List<Book>) : List<Book> {

    shelfIsEmpty(shelf)

    var newestYear = 1

    for (book in shelf){
        if (book.year >= newestYear) newestYear = book.year
    }

    return shelf.filter { it.year == newestYear }
}

//get the book with the shortest title
fun getShortestTitle(shelf: List<Book>): List<Book>{

    shelfIsEmpty(shelf)

    var shortestTitle = Int.MAX_VALUE

    for (book in shelf){
        if (book.title.length < shortestTitle) shortestTitle = book.title.length
    }

    return  shelf.filter { it.title.length == shortestTitle }
}

//get the book with the shortest title
fun getLongestTitle(shelf: List<Book>): List<Book>{

    shelfIsEmpty(shelf)

    var longestTitle = 1

    for (book in shelf){
        if (book.title.length >= longestTitle) longestTitle = book.title.length
    }

    return  shelf.filter { it.title.length == longestTitle }
}

// get the string of book information
fun getList(library: List<Book>): String {
    var strBook = ""
    for (book in library) {
        strBook += book.title + " // " + book.authors + " // " + book.year + "\n"
    }
    // drop the final new string mark
    return strBook.dropLast(1)
}

fun main() {

    val inputString =
        """            1. Divine Comedy // Dante Alighieri // 1472
            2. 1984 // George Orwell // 1949
            3. Brave New World // Aldous Huxley // 1932
            4. Animal Farm // George Orwell // 1945
            5. Death in the Afternoon // Ernest Hemingway // 1932
            6. Двенадцать стульев // Илья Ильф, Евгений Петров// 1928 """

    val shelf: List<Book> = parseBooks(inputString)

    println("Original books list before parse:\n")
    println(inputString)

    println("\nBOOKS LIST:\n")
    println(getList(shelf))

    println("\nThe oldest books list:")
    println(getList(getOldestBook(shelf)))

    println("\nThe latest books list:")
    println(getList(getNewestBook(shelf)))

    println("\nThe longest titled books list:")
    println(getList(getLongestTitle(shelf)))

    println("\nThe shortest titled books list:")
    println(getList(getShortestTitle(shelf)))
}