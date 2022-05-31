package lab_3

import org.junit.Assert.assertEquals
import org.junit.Test
import java.net.URL

internal class NoteServiceTest {

    private val testNotes = NoteService()

    val note1 = testNotes.createTextNote(
        "Always pet your cat",
        Date(11, 2, 2012),
        "If you keep your cat active during the day, he will sleep better at night. If you’re not free-feeding your cat, you can also help her get a good night’s sleep by providing her with a substantial evening meal."
    )
    val note2 = testNotes.createTask("My task", Date(2, 2, 2001), "Do poop", Date(2, 3, 2001))
    val note3 = testNotes.createLink("How to get money", Date(12, 15, 2022), URL("https://cutt.ly/DGtZHdl"))
    val note4 = testNotes.createLink("How to get more money", Date(12, 15, 1022), URL("https://cutt.ly/ZGt1Q0K"))

    @Test
    fun getAllNotesTest() {
        assertEquals(testNotes.getAllNotes(), listOf(note1, note2, note3, note4))
    }

    @Test
    fun getAllTextNotesTest() {
        assertEquals(testNotes.getAllTextNotes(), listOf(note1))
    }

    @Test
    fun getAllTasksTest() {
        assertEquals(testNotes.getAllTasks(), listOf(note2))
    }

    @Test
    fun getAllLinksTest() {
        assertEquals(testNotes.getAllLinks(), listOf(note3, note4))
    }

    @Test
    fun createTextNoteTestAndFinNote() {
        val note5 = testNotes.createTextNote(
            "Random text",
            Date(1, 2, 1992),
            "It doesn't make any sense"
        )

        assertEquals(testNotes.findNote("Random text"), listOf(note5))
    }

    @Test
    fun createTaskTest() {
        val task1 = testNotes.createTask("test task", Date(2, 2, 2001), "Do smth", Date(2, 3, 2001))

        assertEquals(testNotes.getAllTasks(), listOf(note2, task1))
    }

    @Test
    fun createLinkTest() {
        val link1 = testNotes.createLink("How to get job", Date(12, 15, 2020), URL("https://cutt.ly/DGtZHdl"))

        assertEquals(testNotes.getAllLinks(), listOf(note3, note4, link1))
    }

    @Test
    fun removeNoteTest() {
        testNotes.removeNote("Always pet your cat")

        assertEquals(testNotes.getAllTextNotes(), emptyList<Note>())
    }

    @Test
    fun getSortedByTitleTest() {
        assertEquals(testNotes.getSortedByTitle(), listOf(note1, note3, note4, note2))
    }

    @Test
    fun getSortedByDateTest() {
        assertEquals(testNotes.getSortedByDate(), listOf(note4, note2, note1, note3))
    }
}