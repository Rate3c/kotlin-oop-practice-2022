package lab_1

fun parseBooks(books: String): List<Book> {

    if (books.isEmpty()) {   //if list of books is empty
        throw error("Your list is empty")
    }

    val bookList = mutableListOf<Book>()
    val listOfBookLines = books.lines().toMutableList()

    (0 until (listOfBookLines.size)).forEach { i ->
        val authors = mutableListOf<String>()
        listOfBookLines[i] = listOfBookLines[i].substringAfter('.')   //getting titles

        val title: String = listOfBookLines[i].substringBefore("//").trim()    //delete titles
        listOfBookLines[i] = listOfBookLines[i].substringAfter("//")  //get the sting after dropping the title

        if (listOfBookLines[i].substringBefore("//").trim().isNotEmpty()) { //getting authors
            while (listOfBookLines[i].contains(',')) {
                authors.add(listOfBookLines[i].substringBefore(',').trim())
                listOfBookLines[i] = listOfBookLines[i].substringAfter(',')
            }
            authors.add(listOfBookLines[i].substringBefore("//").trim())
            listOfBookLines[i] = listOfBookLines[i].substringAfter("//")
        }

        val year: Int = listOfBookLines[i].filter { it.isDigit() }.toInt() //getting years
        bookList.add(Book(title, authors, year))
    }
    return bookList
}

//check if we have any books and throw exception if not
fun shelfIsEmpty(shelf: List<Book>) {
    if (shelf.isEmpty()) {
        throw IllegalArgumentException("There are no books on the shelf")
    }
}

//get the list of books with the oldest year of publishing
fun getOldestBook(shelf: List<Book>): List<Book> {

    shelfIsEmpty(shelf)
    var oldestYear = Int.MAX_VALUE

    for (book in shelf) {
        if (book.year < oldestYear) oldestYear = book.year
    }
    return shelf.filter { it.year == oldestYear }
}

//get the list of books with the latest year of publishing
fun getNewestBook(shelf: List<Book>): List<Book> {

    shelfIsEmpty(shelf)
    var newestYear = 1

    for (book in shelf) {
        if (book.year >= newestYear) newestYear = book.year
    }
    return shelf.filter { it.year == newestYear }
}

//get the book with the shortest title
fun getShortestTitle(shelf: List<Book>): List<Book> {

    shelfIsEmpty(shelf)
    var shortestTitle = Int.MAX_VALUE

    for (book in shelf) {
        if (book.title.length < shortestTitle) shortestTitle = book.title.length
    }
    return shelf.filter { it.title.length == shortestTitle }
}

//get the book with the shortest title
fun getLongestTitle(shelf: List<Book>): List<Book> {

    shelfIsEmpty(shelf)
    var longestTitle = 1

    for (book in shelf) {
        if (book.title.length >= longestTitle) longestTitle = book.title.length
    }
    return shelf.filter { it.title.length == longestTitle }
}

// get the string of book information
fun getList(library: List<Book>): String {

    var stringBook = ""

    for (book in library) {
        stringBook += book.title + " // " + book.authors + " // " + book.year + "\n"
    }
    return stringBook
}
