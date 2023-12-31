// https://leetcode.com/problems/combination-sum/description/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCumSum(0,target,new ArrayList<Integer>(),candidates,ans); // update the same sum
        return ans;
        
    }
    public void findCumSum(int idx,int target,ArrayList<Integer> ds,int[] candidate,List<List<Integer>> ans){

        // base case
        if(idx == candidate.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return ;
        }

        // decide to pick and non pick

        if(candidate[idx]<=target){ // pick case
            ds.add(candidate[idx]);
            findCumSum(idx,target - candidate[idx],ds,candidate,ans);
            ds.remove(ds.size()-1); // after the recursion remove last element added (don't carry down sum)
        }
         findCumSum(idx+1,target,ds,candidate,ans);// not pick case
    }
}
