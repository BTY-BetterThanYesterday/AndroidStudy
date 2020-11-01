package study.bty.kotlin

class InterfaceTest {
}

abstract class Parent {
    open fun foo() {
        println("foo")
    }

    open fun bar() {

    }
}
interface Parent2 {
    val value: Int
    val value2 get() = 0
    fun foo() {
        println("bar")
    }
}

class Child : Parent(), Parent2 {
    override val value: Int
        get() = TODO("Not yet implemented")

    override fun foo() {
        super<Parent>.foo()
    }

    override fun bar() {
        super.bar()
    }

}


class Book
class Books(val books: List<Book>) : List<Book> by books

fun main() {
    val child = Child()
    child.foo()

    val books = Books(listOf())
    books.isEmpty()
}
