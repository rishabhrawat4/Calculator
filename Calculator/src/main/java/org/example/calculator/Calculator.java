package org.example.calculator;

public class Calculator {

    public static void main(String args[]){
    }
    public static int add(String numbers) throws Exception {
        int lastIndexOfNewLine = numbers.lastIndexOf("\n");
        if(numbers.isEmpty() || lastIndexOfNewLine == numbers.length()-1){
            throw new Exception("line can't be empty");
        }
        String deliminator = ",";
        int sum = 0;
        String[] lines = numbers.split("\n");
        boolean hasNewDeliminator = false;
        if(lines[0].length() > 2 && lines[0].substring(0, 2).equals("//")){
            deliminator = lines[0].substring(2,3);
            hasNewDeliminator = true;
        }
        for(int i = 0; i<lines.length; i++)
        {
            if(hasNewDeliminator && i == 0){
                continue;
            }
            String[] nums = lines[i].split(deliminator);
            if(nums.length > 2){
                throw new Exception("String can't contain more than two numbers");
            }
            for(int j = 0; j<nums.length; j++){
                int num = Integer.parseInt(nums[j]);
                sum += num;
            }
        }

        return sum;
    }
}
