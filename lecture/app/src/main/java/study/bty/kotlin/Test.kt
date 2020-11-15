package study.bty.kotlin

const val DOMAIN = "@domain.com"

class Test {
    val members = mutableListOf(1, 2, 3, 4, 5)
    fun getMemterCount(): Int = members.size

    val sizeValue: Int = getMemterCount()
    val sizeGet: Int
        get() = getMemterCount()
    val sizeGetField: Int = getMemterCount()
        get() = field
    val sizeLazy by lazy { getMemterCount() }

    // 메일 아이디를 받아서 도메인을 붙여서 반환하는 프로퍼티
    var mailAddress: String = ""
        get() = field
        set(value) {
            field = "$value${DOMAIN}"
            integer++
        }

    private val _list = mutableListOf("", "1")
    val list: List<String> get() = _list

    private var _int = 0
    val int get() = _int

    fun addInt() = _int++

    fun addList() = _list.add("add")

    var integer = 0
        private set
}


/**
 * 출력 결과
 * sizeValue = 5
 * sizeGet = 5
 * sizeLazy = 5
 * sizeLazy = 5
 * sizeValue = 5
 * sizeGet = 6
 * sizeLazy = 5
 * sizeLazy = 5
 */
fun main() {
    val test = Test()
    println("sizeValue = ${test.sizeValue}")
    println("sizeGet = ${test.sizeGet}")
    println("sizeLazy = ${test.sizeGetField}")
    println("sizeLazy = ${test.sizeLazy}")

    test.members.add(6)

    println("sizeValue = ${test.sizeValue}")
    println("sizeGet = ${test.sizeGet}")
    println("sizeLazy = ${test.sizeGetField}")
    println("sizeLazy = ${test.sizeLazy}")

    println("test.mailAddress : ${test.mailAddress}")
    test.mailAddress = "hello"
    println("test.mailAddress : ${test.mailAddress}")


    println(test.list)
    test.addList()
    println(test.list)

    // test.integer = 1 // 컴파일에서 막힌다.

    println("int : ${test.int}")
    test.addInt()
    println("int : ${test.int}")
}
