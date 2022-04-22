package lab_3

import java.net.URL

interface NoteServiceInterface {
    fun getAllNotes(): List<Note>
    fun getAllTextNotes(): List<Note.TextNote>
    fun getAllTasks(): List<Note.Task>
    fun getAllLinks(): List<Note.Link>

    fun createTextNote(title: String, date: Date, content: String): Note.TextNote
    fun createTask(title: String, date: Date, description: String, deadline: Date): Note.Task
    fun createLink(title: String,date: Date, url: URL): Note.Link

    fun removeNote(title: String)
    fun findNote(title: String): List<Note>

    fun getSortedByDate(): List<Note>
    fun getSortedByTitle(): List<Note>

}

class NoteService: NoteServiceInterface{

    private val notes: MutableList<Note> = mutableListOf()

    //get all notes
    override fun getAllNotes(): List<Note> {
        return notes
    }

    //get all text notes
    override fun getAllTextNotes(): List<Note.TextNote> {
        return notes.filterIsInstance<Note.TextNote>()
    }

    //get all tasks
    override fun getAllTasks(): List<Note.Task> {
        return notes.filterIsInstance<Note.Task>()
    }

    //get all links
    override fun getAllLinks(): List<Note.Link> {
        return notes.filterIsInstance<Note.Link>()
    }

    //create text note
    override fun createTextNote(title: String, date: Date, content: String): Note.TextNote {

        val textNote = Note.TextNote(title, date, content)

        notes.add(textNote)

        return textNote
    }

    //create task
    override fun createTask(title: String, date: Date, description: String, deadline: Date): Note.Task {

        val taskNote = Note.Task(title, date, description, deadline)

        notes.add(taskNote)

        return taskNote
    }

    //create link
    override fun createLink(title: String, date: Date, url: URL): Note.Link {

        val linkNote = Note.Link(title, date, url)

        notes.add(linkNote)

        return linkNote
    }

    //remove note
    override fun removeNote(title1: String) {
        notes.removeAll{ it.title == title1 }
    }

    //get note by title
    override fun findNote(title1: String): List<Note> {
        return notes.filter{ it.title == title1 }
    }

    //sort by date
    override fun getSortedByTitle() : List<Note> {
        return notes.sortedBy { it.title  }
    }

    //sort by date
    override fun getSortedByDate() : List<Note> {
        return notes.sortedBy { it.date }
    }
}