package study.bty.kotlin.async

import java.lang.Thread.sleep

fun main() {
    // 람다를 이용한 함수 정의
    /**
     * fun plus(a: Int, b: Int) : Int {
     *     return a + b
     * }
     */
    val plus: (Int, Int) -> Int = { a, b ->
        a + b
    }

    val minus: (Int, Int) -> Int = { a, b ->
        a - b
    }

    val times = { a: Int, b: Int ->
        a * b
    }

    val result = calculate(3, 5, times)
//    println(result)

    // 람다 합성
//    val fun1 = {a: Int -> a + 1}
//    val fun2 = {a: Int -> a * 2}
//    fusion(fun1, fun2)
    fusion({ a: Int -> a + 1 }, { a: Int -> a * 2 })
    fusion({ a: Int -> a + 1 }) { a: Int -> a * 2 }

//    callAll(
//        { println("함수 호출1") },
//        { println("함수 호출2") },
//        { println("함수 호출3") },
//        { println("함수 호출4") },
//        { println("함수 호출5") }
//    )

    // 그때 그때의 시간을 출력해보자.
//    val time = { System.currentTimeMillis() }
//    println(time())
//    Thread.sleep(1010)
//    println(time())
//    Thread.sleep(1005)
//    println(time())

    // 간단한 스레드 예제
//    val runnable = object : Runnable {
//        override fun run() {
//            println("Hello Thread!")
//        }
//    }
//    val runnable = Runnable {
//        Thread.sleep(1000)
//        println("Hello Thread!")
//    }
//
//    val forkedThread = Thread(runnable)
//    forkedThread.start()

//     downloadWithPolling()
    downloadWithCallback()


    // 버튼 리스너를 이용한 콜백 예제
//    Button("Button") { println("Hello Callback!") }.onClick()
//    Button("Button", { println("Hello Callback!") }).onClick()
//    Button("Button", callback = { println("Hello Callback!") }).onClick()
//    Button(name = "Button", callback = { println("Hello Callback!") }).onClick()
}

private fun downloadWithPolling() {
    val file = arrayOfNulls<String>(10)
    val download = Runnable {
        for (i in file.indices) {
            file[i] = "${i + 1}번째 파일"
            sleep(500)
        }
        println("폴링방식 실제 완료 시간 : ${System.currentTimeMillis()}")
    }

    Thread(download).start()
    println(file.joinToString { it ?: "__" })
    while (file.any { it == null }) {
        println(file.joinToString(prefix = "다운로드 중 : ") { it ?: "__" })
        sleep(400)
    }
    println("폴링방식 완료 인지 시간 : ${System.currentTimeMillis()}")
    println(file.joinToString { it!! })

}

private fun downloadWithCallback() {
    val callback: (file: Array<String?>) -> Unit = { file ->
        // 완료된 파일을 소비
        println(file.joinToString(prefix = "다운로드 완료: ") { it ?: "__" })
        println("폴링방식 완료 인지 시간 : ${System.currentTimeMillis()}")
    }

    val file = arrayOfNulls<String>(10)
    val download = Runnable {
        for (i in file.indices) {
            file[i] = "${i + 1}번째 파일"
            sleep(500)
        }
        println("폴링방식 실제 완료 시간 : ${System.currentTimeMillis()}")
        callback(file)
    }

    Thread(download).start()
}

fun plus(a: Int, b: Int): Int {
    return a + b
}

fun calculate(a: Int, b: Int, calculator: (Int, Int) -> Int): Int {
    return calculator(a, b)
}

fun fusion(calculator1: (Int) -> Int, calculator2: (Int) -> Int): (Int) -> Int {
    return { i -> calculator1(calculator2(i)) }
}

fun callAll(vararg func: () -> Unit) {
    func.forEach {
        it()
    }
}

class Button(val name: String, val callback: () -> Unit) {
    fun onClick() {
        callback()
    }
}

interface iFoo {
    fun foo()
}