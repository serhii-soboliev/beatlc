package org.sbk.leet
package design



/*
1603. Design Parking System
https://leetcode.com/problems/design-parking-system/
 */
class ParkingSystem(_big: Int, _medium: Int, _small: Int) {
    import scala.collection.mutable
    private val slots = mutable.HashMap((1,_big),(2,_medium),(3, _small))
    def addCar(carType: Int): Boolean = {
        slots.get(carType).map(v => {
            if(v == 0) return false
            slots(carType) = v - 1
            return true
        })
       false
    }

}
