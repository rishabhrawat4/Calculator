package org.example.calculator;

public class Calculator {

    public static void main(String args[]){
    }
    public static int add(String numbers) throws Exception {
        if(numbers.isEmpty()){
            throw new Exception("line can't be empty");
        }
        String deliminator = ",";
        int sum = 0;
        String[] nums = numbers.split(deliminator);
        if(nums.length > 2){
            throw new Exception("String can't contain more than two numbers");
        }
        for(int i = 0; i<nums.length; i++){
            int num = Integer.parseInt(nums[i]);
            sum += num;
        }
        return sum;
    }
}
