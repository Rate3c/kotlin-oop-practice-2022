package lab_3

import java.net.URL

sealed class Note(
    var title: String,
    var date: Date
) {
    class TextNote(title: String, date: Date, val content: String): Note(title, date){
        override fun toString(): String {
            return "($date) $title - $content \n"
        }
    }

    class Task(title: String, date: Date, val description: String, val deadline: Date): Note(title, date){
        override fun toString(): String {
            return "($date) $title - \"$description\", Expired: $deadline\n"
        }
    }

    class Link(title: String, date: Date, val url: URL): Note(title, date) {
        override fun toString(): String {
            return "($date) $title - $url \n"
        }
    }

    override fun toString(): String {
        return "Note(title='$title', date=$date)"
    }
}
