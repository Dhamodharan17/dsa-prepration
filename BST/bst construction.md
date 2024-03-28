```
public BST insert(int value) {

      if(value < this.value){
        if(left == null){
          BST newBST = new BST(value);
          left = newBST;
        }else{
          // so this will point to left
          left.insert(value);
        }
      }else{
        if(right == null){
          BST newBST = new BST(value);
          right = newBST;
        }else{
          right.insert(value);
        }
      }
      // Do not edit the return statement of this method.
      return this;
    }
    ```
