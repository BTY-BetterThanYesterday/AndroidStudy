package study.bty.kotlin

// open 키워드를 붙여야 다른 클래스가 상속할 수 있다.
open class Human(
    val name: String = "",
    var age: Int = 0,
    mail: String
) {
    val email = if (mail.contains("@")) {
        mail
    } else {
        "$mail@human.com"
    }

    constructor(name: String) : this(name, 0, "")

    init {
        println("Human instance $name has been created.")
    }

    fun talk(person: Human) {
        println("${person.name}씨 반갑습니다.")
    }
}

/**
 * Human을 상속받는 Student
 * 상속받았기 때문에 Student는 모든 Human의 속성(프로퍼티)과 행동(함수/메소드)를 갖는다.
 */
class Student(name: String, age: Int, mail: String, id: Int) : Human(name, age, mail) {
    val schoolID = "UNV_$id"
}


// 왼쪽 초록색 버튼을 누르면 실행해볼 수 있다.
fun main() {
    val namju: Human = Student("이남주", 27, "namju123@naver.com", 123456)
    val haenara = Human("신해나라", 31, "haenara")
    println("안녕하세요 저는 ${namju.name}입니다. 저는 ${namju.age}살 입니다. 메일주소 : ${namju.email}")
    println("안녕하세요 저는 ${haenara.name}입니다. 저는 ${haenara.age}살 입니다. 메일주소 : ${haenara.email}")

    haenara.talk(namju)

    if (namju is Student) {
        println("${namju.name}의 학번은 ${namju.schoolID}")
    } else {
        println("${namju.name}는 학교에 다니지 않습니다.")
    }

    if (haenara is Student) {
        println("${haenara.name}의 학번은 ${haenara.schoolID}")
    } else {
        println("${haenara.name}는 학교에 다니지 않습니다.")
    }
}

// 실행결과 :
// Human instance 이남주 has been created.
// Human instance 신해나라 has been created.
// 안녕하세요 저는 이남주입니다. 저는 27살 입니다. 메일주소 : namju123@naver.com
// 안녕하세요 저는 신해나라입니다. 저는 31살 입니다. 메일주소 : haenara@human.com
// 이남주씨 반갑습니다.
// 이남주의 학번은 UNV_123456
// 신해나라는 학교에 다니지 않습니다.
