package lab_3

import java.net.URL

fun main() {

    val notes = NoteService()

    notes.createTextNote("Always pet your cat", Date(11,2,2012), "If you keep your cat active during the day, he will sleep better at night. If you’re not free-feeding your cat, you can also help her get a good night’s sleep by providing her with a substantial evening meal.")
    notes.createTask("My task", Date(2,2,2001), "Do poop", Date(2,3,2001))
    notes.createLink("How to get money", Date(12,15,2022), URL("https://cutt.ly/DGtZHdl"))
    notes.createLink("How to get more money", Date(12,15,1022), URL("https://cutt.ly/ZGt1Q0K"))

    println("All Notes:\n ${notes.getAllNotes()}\n")
    println("All Text Notes:\n ${notes.getAllTextNotes()}\n")
    println("All Tasks:\n ${notes.getAllTasks()}\n")
    println("All Links:\n ${notes.getAllLinks()}\n")

    notes.removeNote("My task")
    println("All Notes:\n ${notes.getAllNotes()}\n")
    println("Find note by title:\n ${notes.findNote("Cat information")}")

    println("Sort by date:\n ${notes.getSortedByDate()}")
    println("Sort by title:\n ${notes.getSortedByTitle()}")
}