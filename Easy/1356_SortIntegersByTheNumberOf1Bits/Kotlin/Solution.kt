class Solution {
    fun sortByBits(arr: IntArray): IntArray {
        //return arr.sortedWith(compareBy({ it.countOneBits() }, { it })).toIntArray()
        //return arr.sortedBy{ it }.sortedBy{ it.countOneBits() }.toIntArray()
        return arr.sortedBy{ it.countOneBits() * 10000 + it }.toIntArray()
    }
}