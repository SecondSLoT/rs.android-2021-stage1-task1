package subtask3

import java.util.*

class StringParser {

    private val treeMap = TreeMap<Int, String>()

    fun getResult(inputString: String): Array<String> {
        val stack1 = ArrayDeque<Int>() // ()
        val stack2 = ArrayDeque<Int>() // []
        val stack3 = ArrayDeque<Int>() // <>

        val stringList = mutableListOf<String>()

        for (i in inputString.indices) {
            when (inputString[i]) {
                '(' -> stack1.push(i)
                '[' -> stack2.push(i)
                '<' -> stack3.push(i)
                ')' -> if (stack1.isNotEmpty()) addToTreeMap(inputString, stack1, i)
                ']' -> if (stack2.isNotEmpty()) addToTreeMap(inputString, stack2, i)
                '>' -> if (stack3.isNotEmpty()) addToTreeMap(inputString, stack3, i)
            }
        }

        for (i in treeMap) {
            stringList.add(i.value)
        }

        return stringList.toTypedArray()
    }

    private fun addToTreeMap(origin: String, stack: ArrayDeque<Int>, endValue: Int) {
        val key = stack.pop() + 1
        treeMap[key] = origin.substring(key until endValue)
    }
}
