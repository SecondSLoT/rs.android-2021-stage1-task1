package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val sadList: MutableList<Int> = sadArray.toMutableList()

        var i = 1
        while (i < sadList.size - 1) {
            if (sadList[i] > sadList[i - 1] + sadList[i + 1]) {
                sadList.removeAt(i)
                if (i > 1) i--
            } else {
                i++
            }
        }

        return sadList.toIntArray()
    }
}