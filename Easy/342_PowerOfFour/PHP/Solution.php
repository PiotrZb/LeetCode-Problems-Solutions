<?php
class Solution {

    function isPowerOfFour($n) {
        if ($n < 1) return false;
        // while($n % 4 == 0) $n /= 4;
        // return $n == 1;
        $n = log($n, 4);
        return round($n) == $n;
    }
}
?>