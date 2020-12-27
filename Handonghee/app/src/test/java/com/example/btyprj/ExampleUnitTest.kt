package com.example.btyprj

import org.junit.Test

import org.junit.Assert.*
import java.io.Console
import java.lang.StringBuilder

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println(homeworkText1("1231241"))
        println(homeworkText2("2Ksz3j214_06ka!"))
    }

    fun homeworkText1(inputValue : String): String {
        var ret : StringBuilder = StringBuilder()

        inputValue.forEachIndexed { index, c ->
            if((index + 1).toString().contains('3') or (index + 1).toString().contains('6') or (index + 1).toString().contains('9'))
                ret.append('짝')
            else
                ret.append(c)
        }

        return ret.toString()
    }

    fun homeworkText2(inputValue : String): Int {
        if(inputValue.isEmpty())
            return 0

        var ret : Int = 0

        inputValue.filter { it.isDigit() }.filter { (it.toInt() - 48) % 2 == if(inputValue.last() == '#') 0 else 1 }.forEach {
            val value = it.toInt() - 48
            ret += value * value
        }

        return ret
    }
}