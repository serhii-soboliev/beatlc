package org.sbk.leet
package contests

class WC285 {

    /*
    2210. Count Hills and Valleys in an Array
     */
    def countHillValley(nums: Array[Int]): Int = {
        var r = 0
        var left = nums(0)
        (1 until nums.length-1).foreach(i => {
            if((left < nums(i) && nums(i) > nums(i+1)) || (left > nums(i) && nums(i) < nums(i+1))) {
                left = nums(i)
                r += 1
            }
        })
        r
    }

    /*
        2211. Count Collisions on a Road
     */
    def countCollisions(directions: String): Int = {
        var collisions = 0
        var carsMoving = 0
        var isCarStaying = false
        directions.foreach {
            case 'R' => carsMoving += 1
            case 'L' =>
                if(carsMoving > 0) {
                    collisions += (carsMoving + 1)
                    isCarStaying = true
                } else if (isCarStaying) {
                    collisions += 1
                }
                carsMoving = 0
            case 'S' =>
                isCarStaying = true
                if(carsMoving > 0) collisions += carsMoving
                carsMoving = 0

        }
        collisions
    }

    def maximumBobPointsDP(numArrows: Int, aliceArrows: Array[Int]): Array[Int] = {

        def dp(k: Int, numArrows: Int): Int = {
            if (k == 12 || numArrows <= 0) return 0
            var maxScore = dp(k + 1, numArrows)
            if (numArrows > aliceArrows(k)) maxScore = maxScore max dp(k + 1, numArrows - (aliceArrows(k) + 1)) + k
            maxScore
        }

        var nA = numArrows
        val ans = Array.fill[Int](12)(0)
        var remainBobArrows = nA
        (0 until 12) foreach(k => {
            if(dp(k, nA) != dp(k+1, nA)) {
                ans(k) = aliceArrows(k) + 1
                nA -= ans(k)
                remainBobArrows -= ans(k)
            }
        })
        ans(0) += remainBobArrows
        ans
    }

    def maximumBobPoints(numArrows: Int, aliceArrows: Array[Int]): Array[Int] = {

        def buildArrowsDistribution(mask: Long): (Int, Array[Int]) = {
            var remainingArrows = numArrows
            val ar = Array.fill[Int](12)(0)
            var score: Int = 0
            (0 until 12).foreach(k => {
                if(((mask >> k) & 1) == 1) {
                    val arrowsNeeded = aliceArrows(k) + 1
                    if(remainingArrows < arrowsNeeded) return (0, Array())
                    score += k
                    ar(k) = arrowsNeeded
                    remainingArrows -= arrowsNeeded
                }
            })
            ar(0) += remainingArrows
            (score, ar)
        }

        (0 until 1 << 12).map(mask => buildArrowsDistribution(mask)).maxBy(_._1)._2

    }
}

object WC285 {
    def main(args: Array[String]):Unit = {
        val c = new WC285()
        val t = c.maximumBobPoints(9, Array(1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0))
        println(c.countCollisions("LLRR"))
        println(c.countCollisions("RLRSLL"))
        print(c.countHillValley(Array(6, 6, 5, 5, 4, 1)))
        print(c.countHillValley(Array(2,4,1,1,6,5)))
    }
}
