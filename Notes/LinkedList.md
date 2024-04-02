# LinkedList
- Non contingous memory location.
- Since Array have memory limitation and need more time to expand.
  
![image](https://github.com/Dhamodharan17/dsa-prepration/assets/30789057/1af7cff0-24d1-413a-8c13-41a5c9bfcf1c)
```
 public static class Node{
        int data;
        Node next = null;
        Node(){

        }
        Node(int data){
            this.data = data;
            this.next = null;
        }
        Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
    }
```
## Operations
- Insertion ( At start, end, some position)
- Traversal
- Deletion 
- Search
- Reverse
    
## Insertion in linkedlist
### a.Create Linkedlist / Add at end

```
    public static void insertAtEndLL(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;

        while (curr != null && curr.next !=null){
            curr = curr.next;
        }
        // Logic : append reference of current node to "next"
        curr.next = newNode;
    }
```
### b.Add after some node

```
 public static void insertAfterNode(int node,int val){
        /*
          Logic : append reference of current node to "next"
          But here we will lose the next node, so store it and
          append that to new node
         */
        Node newNode = new Node(val);
        Node cur = head;
        // search the node
        while (cur !=null && cur.data !=node){
            cur = cur.next;
        }
        if(cur!=null){
            Node temp = cur.next;
            cur.next= newNode;
            newNode.next = temp;
        }
    }
```
### c.Add before some node

```
  public static void insertBeforeNode(int before,int val){

        Node cur = head;
        Node prev = null;
        // search for the node and keep its prev
        while(cur !=null && cur.data != before){
            prev = cur;
            cur = cur.next;
        }

        // update reference
        if(prev != null){
            Node temp = prev.next;
            prev.next = new Node(val);
            prev.next.next = temp;
        }else {
            // Edge case : head = before
            Node temp = head;
            head = new Node(val);
            head.next = temp;
        }

    }
```
## Traversal in linkedlist
### a.Iterative Traversal

```
  public static void traverseLL(Node node){
        while (node!=null){
            System.out.println(node.data);
            node = node.next;
        }
    }
```

### b.Recursive Traversal

```
  public static void traverseRecur(Node node) {

        if (node == null)
            return;

        System.out.println(node.data);
        traverseRecur(node.next);
    }
```
## Delete in Linkedlist

```
 public static void deleteNodeLL(int node) {
        // Logic : skip the node to be deleted.

        // search the node to delete
        Node cur = head;
        Node prev = null;
        while (cur != null && cur.data != node) {
            prev = cur;
            cur = cur.next;
        }
        if (prev != null) {
            prev.next = cur.next;
        } else {
            // Edge case : head node delete
            head=head.next;
        }
    }
```
## Reverse LinkedList
### a.Iterative Approach
```
   public static void reverseLL(){

        Node cur = head;
        Node prev = null;

        while (cur != null){
            Node next = cur.next;
            cur.next = prev;//logic
            prev = cur;
            cur = next;
        }

        head=prev;
    }
```
### b.Recursive Approach
```
 public static Node reverseRecurLL(Node cur,Node prev) {

        if(cur == null)
            return prev;

        Node next = cur.next;
        cur.next = prev;

        return reverseRecurLL(next,cur);
    }
```
