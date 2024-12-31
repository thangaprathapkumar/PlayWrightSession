package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int nums[]={3,5,12,4,10};
    static int target= 9;

    public static void main(String[] args) {
        twoSum();
    }

    public static int[] twoSum() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {

                    System.out.println("The J :" + nums[j]);
                    System.out.println("The i :" + nums[i]);
                    System.out.println("The target is :" + target);

                    return new int[] {
                            i, j
                    };

                }
            }
        }
        // If no valid pair is found, return an empty array instead of null
        return new int[] {};
    }

}