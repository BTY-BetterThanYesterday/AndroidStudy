package study.bty.kotlin


/**
 * 클래스에서 프로퍼티 다루기
 * 1. 프로퍼티 초기화 하는 방법
 * Optional (?) : Null 로 초기화 하고 나중에 값을 저장
 * init () : 초기화 블록에서 값을 설정
 * lateinit : 초기값을 생략하고 나중에 대입. 대입 될 것을 가정한다.
 * by lazy : 사용 시점에 초기화 된다.
 */

class Unit(
    var hp: Int,
    var atk : Int
) {
    override fun toString(): String {
        return "hp: $hp atk: $atk"
    }


}


