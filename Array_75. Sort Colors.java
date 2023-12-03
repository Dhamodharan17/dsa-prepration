//https://leetcode.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {

        int start = 0;
        int end = nums.length-1;
        int i=0;

        while( i <= end){ // when stop moved to left - no need to proceed further

            if(nums[i] == 0){
                nums[i] = nums[start];// whatever in start, move to ith position
                nums[start] = 0;             
                start++;      
            } 
             if(nums[i] == 2){
                nums[i] = nums[end];// whatever in end, move to ith position
                nums[end] =2;
                end--;
            }else{
                 i++;
            }
           
                       
        }

    }
}
