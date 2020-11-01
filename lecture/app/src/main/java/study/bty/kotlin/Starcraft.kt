package study.bty.kotlin


/**
 * 클래스에서 프로퍼티 다루기
 * 1. 프로퍼티 초기화 하는 방법
 * Optional (?) : Null 로 초기화 하고 나중에 값을 저장
 * init () : 초기화 블록에서 값을 설정
 * lateinit : 초기값을 생략하고 나중에 대입. 대입 될 것을 가정한다.
 * by lazy : 사용 시점에 초기화 된다.
 */

class Unit private constructor(
    var hp: Int,
    var atk : Int,
    var atkAir : Double,
    val sp : Species = Species.ZERG
) {
    init {
        poplutaion++
    }
    override fun toString(): String {
        return "hp: $hp atk: $atk"
    }
    companion object {
        fun of(hp :Int, atk: Int) = Unit(hp, atk, 0.0)
        fun of(hp :Int, atk: Double) = Unit(hp, 0, atk)
        var poplutaion : Int = 0
    }
}

enum class Species {
    ZERG, TERRAN, PROTOS
}

fun main() {
    val scv = Unit.of(0, 0)
    println(Unit.poplutaion)
    val scv2 = Unit.of(0, 0)
    println(Unit.poplutaion)
    val scv3 = Unit.of(0, 0)
    println(Unit.poplutaion)

    Single.foo()

    val p = when (scv.sp) {
        Species.ZERG -> { 0 }
        Species.TERRAN -> { 1 }
        Species.PROTOS -> { 2 }
    }

    val hhp = when (scv.hp) {
        0 -> { 1 }
        1 -> { 2 }
        else ->  { 0 }
    }
}

object Single {
    fun foo() { }
}


