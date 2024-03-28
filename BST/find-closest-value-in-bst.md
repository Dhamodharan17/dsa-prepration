**Bruteforce Approach**
- iterate the tree
- calculate the difference and update the global variables
```
import java.util.*;

class Program {

  static int globalDiff = Integer.MAX_VALUE;
  static int result = 0;
  
  public static int findClosestValueInBst(BST tree, int target) {

    if(tree == null)
      return -1;
    
    findClosestValueInBst(tree.left,target);
    int localDiff = Math.abs(target-tree.value);
    if(localDiff<=globalDiff){
      globalDiff = localDiff;
      result = tree.value;
    }
    findClosestValueInBst(tree.right,target);

    return result;
  }
}
```
**Solution 1 - Recursive Apporach** 
- use bst property
- choose closest comparing difference
- paramterise the value that need to be carried all over the recursion
```
import java.util.*;

class Program {

  public static int findClosestValueInBst(BST tree, int target) {
    return findClosestValueInBst(tree,target,tree.value);
  }

  public static int findClosestValueInBst(BST tree,int target,int closest){

    // Choose closest by comparing difference
    if(Math.abs(target-closest)>Math.abs(target-tree.value)){
      closest = tree.value;
    }
    // Less value go left side
    if(target < tree.value && tree.left != null){
      return findClosestValueInBst(tree.left,target,closest);
    // More value go right side
    }else if(target > tree.value && tree.right != null){
      return findClosestValueInBst(tree.right,target,closest);
    }else{
      return closest;
    }
    
  }

}
```
**Solution 2 - Iterative Apporach**
- choose the closest
```
import java.util.*;

class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
    return findClosestValueInBst(tree,target,tree.value);
  }
    public static int findClosestValueInBst(BST tree, int target,int closest) {

      BST currentNode = tree;

      // Anyway we are going to traverse one part of the tree
      while(currentNode != null){
        // Choose the closest
        if(Math.abs(target-closest)>Math.abs(target-currentNode.value)){
          closest = currentNode.value;
        }
        if(target<currentNode.value){
          currentNode = currentNode.left;
        } else if(target>currentNode.value){
          currentNode = currentNode.right;
        }else{
          break;
        }
      }
  return closest;
    
  }
 
}
```
