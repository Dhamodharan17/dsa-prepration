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
