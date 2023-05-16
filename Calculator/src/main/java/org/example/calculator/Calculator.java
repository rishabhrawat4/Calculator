package org.example.calculator;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> negativeNumbers = new ArrayList<>();
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
                if(num < 0){
                    negativeNumbers.add(num);
                }
                sum += num;
            }
        }

        if(!negativeNumbers.isEmpty()){
            String exceptionMsg = "negatives not allowed ";
            for(int i = 0; i<negativeNumbers.size(); i++){
                exceptionMsg += String.format("%s, ", negativeNumbers.get(i));
            }
            exceptionMsg = exceptionMsg.substring(0, exceptionMsg.length() - 2);
            throw new Exception(exceptionMsg);
        }

        return sum;
    }
}
