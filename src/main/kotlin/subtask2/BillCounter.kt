package subtask2

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val bActual = (bill.sum() - bill[k]) / 2
        return if (bActual == b) {
            "Bon Appetit"
        } else {
            "${b - bActual}"
        }
    }
}
