package study.bty.kotlin.library

import java.lang.IllegalArgumentException

fun collections() {
//    val list = ArrayList<Int>()
//    list.add(1)
//    list.add(2)
//    list.add(3)

    val list: List<Int> = listOf(1, 2, 3)
    val list2 = list + list
    val list3 = list + listOf(4, 5, 6)
    val list4 = list.map { it * 2 }
    println(list)
    println(list2)
    println(list3)
    println(list4)

    val alist: ArrayList<Int> = arrayListOf(1, 2, 3)
    val mlist: MutableList<Int> = mutableListOf(1, 2, 3)
    (mlist as ArrayList).add(7)
    println(mlist)

//    val array = Array<Int>(5) { 0 }
//    array[0] = 1
//    array[1] = 2
//    array[2] = 3
    val array = arrayOf(1, 2, 3)
    val array2 = arrayOfNulls<Int>(3)

//    val set = HashSet<Int>()
//    set.add(1)
//    set.add(2)
//    set.add(3)
    val set: Set<Int> = setOf(1, 2, 3)
    val hset: HashSet<Int> = hashSetOf(1, 2, 3)

    val map: Map<Int, String> = mapOf(1 to "one", 2 to "two", 3 to "three")
    println(map[1])
    println(map[2])
    println(map[3])
    val mutableMap = map.toMutableMap()
    mutableMap[1] = "하나"
    println(map[1])
    println(mutableMap[1])
//    val pair = Pair(1, "하나")
    val pair: Pair<Int, String> = 1 to "하나"
    val triple = Triple(1, "하나", "one")
}

fun main() {
//    println(
//        ArrayList<Int>().apply {
//            this.add(1)
//            this.add(2)
//            this.add(3)
//            println(this[0])
//        }
//    )

    val list2 = ArrayList<Int>().also {
        it.add(1)
        it.add(2)
        it.add(3)
//        println(it[0])
    }
//    println(list2)

    val sum: Int = ArrayList<Int>().let {
        it.add(1)
        it.add(2)
        it.add(3)
        it.sum()
    }
//    println(sum)

    val sum2: Int = ArrayList<Int>().run {
        add(1)
        add(2)
        add(3)
        sum()
    }
//    println(sum2)

    val nullable: String? = null
    val result1 = nullable?.let {
        it.capitalize()
    } ?: "이건 널이야"

    val nullable2: String? = "hello"
    val result2 = nullable2?.let {
        it.toUpperCase()
    } ?: "이건 널이야"

//    println(result1)
//    println(result2)


//    println(
//        try {
//            toUpper(result1)
//        } catch (e: IllegalArgumentException) {
//            e.printStackTrace()
//        }
//    )

    val hello: String? = "hello"
    val hello2 = "#hello"
    hello.takeIf { it?.contains("#") == true }?.let {
        println(it.toUpperCase())
    }

    if (hello != null) {
        if (hello.contains("#")) {

        }
    }


    hello2.takeIf { it.contains("#") }?.let {
//        println(it.toUpperCase())
    }

    repeat(100) {
//        println("$it 퇴근하고싶다")
    }

//    println(
//        "hello world! kotlin!".split(" ")
//    )
//    println(
//        "hello world! kotlin!".replace("!", "#")
//    )

//    println("texts = ${texts.joinToString(
//        prefix = "(",
//        postfix = ")",
//        separator = ";"
//    ) { it.toUpperCase() } }")

    val texts = "Wow hello world! kotlin! a b aa bbb ".split(" ")
    val filtered = texts.filter { it.length < 6 }
    val all = texts.all { it.length < 6 }
    val any = texts.any { it.length < 6 }
    val contains = texts.contains("Wow")
    val mapped = texts.map {
        "_$it"
    }
    val sorted = texts.sorted()
    val sorted2 = texts.sortedBy { it.toUpperCase() }
    val asso = texts.associate { it.length to it }
    val taken = texts.take(3)
    val takenLast = texts.takeLast(3)

    println("texts = $texts")
    println("filtered = $filtered")
    println("all = $all")
    println("any = $any")
    println("contains = $contains")
    println("mapped = $mapped")
    println("sorted = $sorted")
    println("sorted2 = $sorted2")
    println("asso = $asso")
    println("taken = $taken")
    println("taken = $takenLast")
}

fun toUpper(text: String?): String {
    require(text != null)
    return text.toUpperCase()
}