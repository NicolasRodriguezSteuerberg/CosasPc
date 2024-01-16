package com.nsteuerberg.proyectoletcode

class SolutionTwoSum {
/*
1. Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
*/


    /* Mi solucion
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var lista: IntArray = IntArray(2)
        var suma: Int
        var isFinish: Boolean = false
        for (i in nums.indices){
            for (j in nums.indices){
                if (i!=j) {
                    suma = nums.get(i) + nums[j]
                    if (suma == target) {
                        lista[0] = i
                        lista[1] = j
                        isFinish = true
                        break
                    }
                }
            }
            if (isFinish){
                break
            }
        }
        return lista
    }
    */

    // la mejor solucion
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val diffMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, int ->
            diffMap[int]?.let { return intArrayOf(it, index) }
            diffMap[target - int] = index
        }
        return intArrayOf()
    }
}