package pl.org.seva.myapplication.main.data

class Nested(
    val a: A,
    val b: String,
) {

    override fun equals(other: Any?): Boolean {
        return if (other is Nested) a.equals(other.a) else super.equals(other)
    }

    override fun hashCode(): Int {
        return a.hashCode()
    }

}
