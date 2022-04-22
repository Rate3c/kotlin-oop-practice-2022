package lab_3

class Date(val month: Int,val day: Int,val year: Int) : Comparable<Date> {
    init {
        if (year < 0 || year > 2022 ) throw error("Wrong year")
        if (month < 0 || month > 12) throw error("Wrong month")
        if (day < 0 || day > 31) throw error("Wrong day")
    }

    override fun toString(): String {
        return "$month-$day-$year"
    }

    override fun compareTo(other: Date): Int {
        if (this.year > other.year) return 1
        if (this.year < other.year) return -1
        if (this.month > other.month) return 1
        if (this.month < other.month) return -1
        if (this.day > other.day) return 1
        if (this.day < other.day) return -1
        return 0
    }
}