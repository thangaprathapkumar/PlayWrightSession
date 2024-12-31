package org.example;


import java.util.HashMap;

public class TwoSum {

        static int[] nums = {3, 5, 12, 4, 10};
       static int target = 9;

        public static void main(String[] args) {
            int[] result = twoSum(nums,target);
            if (result.length > 0) {
                System.out.println("Indices: " + result[0] + ", " + result[1]);
            } else {
                System.out.println("No solution found.");
            }
        }

        public static int[] twoSum(int[] nums, int target) {

            // HashMap to store the numbers and their corresponding indices
            HashMap<Integer, Integer> map = new HashMap<>();

            // Iterate through the array
            for (int i = 0; i < nums.length; i++) {
                // Calculate the complement: the number needed to reach the target
                int complement = target - nums[i];

                // If the complement exists in the map, we have a solution
                if (map.containsKey(complement)) {
                    // Return the indices of the two numbers that add up to the target
                    return new int[] { map.get(complement), i };
                }

                // Otherwise, store the current number and its index in the map
                map.put(nums[i], i);
            }

            // If no solution is found, return an empty array
            return new int[] {};
        }
    }

