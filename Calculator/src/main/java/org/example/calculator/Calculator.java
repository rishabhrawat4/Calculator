package org.example.calculator;

public class Calculator {

    public static void main(String args[]){
    }
    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        String deliminator = ",";
        int sum = 0;
        String[] nums = numbers.split(deliminator);
        for(int i = 0; i<nums.length; i++){
            int num = Integer.parseInt(nums[i]);
            sum += num;
        }
        return sum;
    }
}
