
10-week review

From serendipity to commencement 


# Five-step method
- Step 1: Do not spend too much time on a new problem. If you get stuck on it, learn from the solution and the most voted answers
- Step 2: Solve the problem by yourself
- Step 3: Resolve it after 24 hours
- Step 4: Practice a week later
- Step 5: Practice it before attending the interview

# Data structure

## Linear
- Fundamental: Array(string), Linked list
- Advanced: Stack, Queue, Deque, Set, Map(hash or map), etc

## two dimentional
- Fundamental: Tree, Graph
- Advanced: Binary Search Tree(red-black tree, AVL, B-tree, B+ tree), Heap, Disjoint set, Trie, etc

## Special
- Bitwise, BloomFilter
- LRU Cache

# Time complexities

see https://www.bigocheatsheet.com/

# Algorithms

- branch: if-else, switch
- Iteration: for, while
- Recursion: Recursive function, Divide & conquer, Backtrace
- Search: DFS, BFS, A*, etc
- DP (Dynamic Programming)
- Binary Search
- Greedy
- Math & Geometry


# Code templates
## Recursion
```
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }

    // process current logic
    process(level, param);

    // drill down
    recur(level: level + 1, newParam);

    // restore current status
}
```

## Divide & Conquer

```
def divide_conquer(problem, param1, param2, ...):
    # recursion terminator
    if problem is None:
        print_result
        return

    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)

    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ...)
    subresult2 = self.divide_conquer(subproblems[1], p1, ...)
    subresult3 = self.divide_conquer(subproblems[2], p1, ...)

    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...)

```

## DFS

```
public List<List<Integer>> levelOrder(TreeNode root) 
{
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null) {
            return allResults;
    }
        travel(root,0,allResults);
        return allResults;
}

private void travel(TreeNode root,int level,List<List<Integer>> results)
{
    if(results.size()==level) {
        results.add(new ArrayList<>());
    }
    results.get(level).add(root.val);
    if(root.left!=null) {
        travel(root.left,level+1,results);
    }
    
    if(root.right!=null) {
        travel(root.right,level+1,results);
    }
}
```

## BFS

```
public class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;    
    }
}
    
public List<List<Integer>> levelOrder(TreeNode root) 
{    
    List<List<Integer>> allResults = new ArrayList<>();    
    if (root == null) {        
        return allResults;    
        }    
        Queue<TreeNode> nodes = new LinkedList<>();    
        nodes.add(root);    
        while (!nodes.isEmpty()) {        
            int size = nodes.size();        
            List<Integer> results = new ArrayList<>();        
            for (int i = 0; i < size; i++) {            
                TreeNode node = nodes.poll();            
                results.add(node.val);            
                if (node.left != null) {                
                    nodes.add(node.left);            
                }            
                if (node.right != null) {                
                    nodes.add(node.right);            
                }        
            }        
        allResults.add(results);    
    }    
    return allResults;
}
```


## Binary Search

```
public int binarySearch(int[] array, int target) 
{    
    int left = 0, right = array.length - 1, mid;    
    while (left <= right) {        
        mid = (right - left) / 2 + left;        
        if (array[mid] == target) {            
            return mid;        
        } else if (array[mid] > target) {            
            right = mid - 1;        
        } else {            
            left = mid + 1;        
        }    
    }    
    return -1;
}
```

## Trie
```

class Trie {    
    private boolean isEnd;    
    private Trie[] next;    

    /** Initialize your data structure here. */    
    public Trie() {        
        isEnd = false;        
        next = new Trie[26];    
    }

    /** Inserts a word into the trie. */    
    public void insert(String word) {        
        if (word == null || word.length() == 0) 
            return;        
        Trie curr = this;        
        char[] words = word.toCharArray();        
        
        for (int i = 0;i < words.length;i++) {            
            int n = words[i] - 'a';            
            if (curr.next[n] == null) curr.next[n] = new Trie();            
                curr = curr.next[n];        
        }        
        curr.isEnd = true;    
    }        
    
    /** Returns if the word is in the trie. */    
    public boolean search(String word) {        
        Trie node = searchPrefix(word);        
        return node != null && node.isEnd;    
    }        
    
    /** Returns if there is any word in the trie that starts with the given prefix. */    
    public boolean startsWith(String prefix) {        
        Trie node = searchPrefix(prefix);        
        return node != null;    
    }    
    
    private Trie searchPrefix(String word) {        
        Trie node = this;        
        char[] words = word.toCharArray();        
        for (int i = 0;i < words.length;i++) {            
            node = node.next[words[i] - 'a'];            
            if (node == null) 
                return null;        
        }        
        return node;    
    }
}
```

## Disjoint 

```
class UnionFind { 	
    private int count = 0; 	
    private int[] parent; 	
    
    public UnionFind(int n) { 		
        count = n; 		
        parent = new int[n]; 		
        for (int i = 0; i < n; i++) { 			
            parent[i] = i;		
        }	
    } 	
    
    public int find(int p) { 		
        while (p != parent[p]) { 			
            parent[p] = parent[parent[p]]; 			
            p = parent[p]; 		
        }		
        return p; 	
    }	
    
    public void union(int p, int q) { 		
        int rootP = find(p); 		
        int rootQ = find(q); 		
        if (rootP == rootQ) 
            return; 		
        
        parent[rootP] = rootQ; 		
        count--;	
    }
}
```
## N-queen (resolving by bit)

```
class Solution {	
    private int size; 	
    private int count;	
    
    private void solve(int row, int ld, int rd) { 		
        if (row == size) { 			
            count++; 			
            return; 		
        }		
        
        int pos = size & (~(row | ld | rd)); 		
        
        while (pos != 0) { 			
            int p = pos & (-pos); 			
            pos -= p; // pos &= pos - 1; 			
            solve(row | p, (ld | p) << 1, (rd | p) >> 1); 		
        } 	
    } 
    
    public int totalNQueens(int n) { 	
        count = 0; 	size = (1 << n) - 1; 	
        solve(0, 0, 0); 	
        return count;   
    } 
}
```

## Merge sort

```
public static void mergeSort(int[] array, int left, int right) {    
    if (right <= left) 
        return;    
    int mid = (left + right) >> 1; // (left + right) / 2    
    mergeSort(array, left, mid);    
    mergeSort(array, mid + 1, right);    
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {        
    int[] temp = new int[right - left + 1];         
    int i = left, j = mid + 1, k = 0;        
    while (i <= mid && j <= right) {            
        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];        
    }        
    
    while (i <= mid)   
        temp[k++] = arr[i++];        
    while (j <= right) 
        temp[k++] = arr[j++];        
    for (int p = 0; p < temp.length; p++) {            
        arr[left + p] = temp[p];        
    }        
}
```

## Quick Sort
```
public static void quickSort(int[] array, int begin, int end) {    
    if (end <= begin) 
        return;    
    int pivot = partition(array, begin, end);    
    quickSort(array, begin, pivot - 1);    
    quickSort(array, pivot + 1, end);
}

static int partition(int[] a, int begin, int end) {    
    nt pivot = end, counter = begin;    
    for (int i = begin; i < end; i++) {        
        if (a[i] < a[pivot]) {            
            int temp = a[counter]; 
            a[counter] = a[i]; 
            a[i] = temp;            
            counter++;        
        }    
    }    
    int temp = a[pivot]; 
    a[pivot] = a[counter]; 
    a[counter] = temp;   
    return counter;
}
```

## LRU Cache 
```
class LRUCache {

    private Map<Integer, DLinkNode> cache = new HashMap<>();

    private int size;
    
    private int capacity;
    
    private DLinkNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }


    private void removeNode(DLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private static class DLinkNode {
        Integer key;
        Integer value;
        DLinkNode prev;
        DLinkNode next;

        DLinkNode() {
        }

        DLinkNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
```

# heapify
```
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；    
    int largest = i;    
    if (left < length && array[left] > array[largest]) {        
        largest = left;    
    }    
    if (right < length && array[right] > array[largest]) {        
        largest = right;    
    }    
    if (largest != i) {        
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;        
        heapify(array, length, largest);    
    }
}

public static void heapSort(int[] array) {    
    if (array.length == 0) 
        return;    
    int length = array.length;    
    for (int i = length / 2-1; i >= 0; i-)         
        heapify(array, length, i);    
    for (int i = length - 1; i >= 0; i--) {        
        int temp = array[0]; array[0] = array[i]; array[i] = temp;        
        heapify(array, i, 0);    
    }
}
```

# Make the complicated program to be simple


The truth is to find the repeated patterns and interpret them in computer languages.


# Study method
- The excellent basic skills are the most critical differential points between experts and average developers, and they can be gained by well-practised
- The biggest incorrect method: Only practice once
- Five-step method
- Practice method: Find the weaknesses, less confidence, boring parts, and practice repeatedly. 
- Feedback: Learn from the official solutions and the most voted posts

# Good problams for practicing
- https://leetcode.com/problems/plus-one/
- https://leetcode.com/problems/climbing-stairs/
- https://leetcode.com/problems/two-sum/
- https://leetcode.com/problems/swap-nodes-in-pairs/
- https://leetcode.com/problems/merge-two-sorted-lists/
- https://leetcode.com/problems/move-zeroes/
- https://leetcode.com/problems/design-circular-deque/
- https://leetcode.com/problems/intersection-of-two-arrays-ii/
- https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
- https://leetcode.com/problems/remove-outermost-parentheses/
- https://leetcode.com/problems/fizz-buzz/
- https://leetcode.com/problems/add-digits/
- https://leetcode.com/problems/maximum-depth-of-binary-tree
- https://leetcode.com/problems/move-zeroes/
- https://leetcode.com/problems/binary-tree-inorder-traversal/
- https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
- https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
- https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
- https://leetcode.com/problems/two-sum/
- https://leetcode.com/problems/3sum/
- https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
- https://leetcode.com/problems/permutations/
- https://leetcode.com/problems/climbing-stairs/
- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
- https://leetcode.com/problems/lemonade-change/
- https://leetcode.com/problems/number-of-islands/
- https://leetcode.com/problems/valid-perfect-square/
- https://leetcode.com/problems/majority-element/
- https://leetcode.com/problems/word-ladder/
- https://leetcode.com/problems/walking-robot-simulation/
- https://leetcode.com/problems/maximum-subarray/
- https://leetcode.com/problems/longest-common-subsequence/
- https://leetcode.com/problems/search-a-2d-matrix/
- https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
- https://leetcode.com/problems/minimum-path-sum/
- https://leetcode.com/problems/coin-change/
- https://leetcode.com/problems/house-robber-ii/
- https://leetcode.com/problems/n-ary-tree-preorder-traversal/
- https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
- https://leetcode.com/problems/search-in-rotated-sorted-array/
- https://leetcode.com/problems/word-search-ii/
- https://leetcode.com/problems/search-a-2d-matrix/
- https://leetcode.com/problems/implement-trie-prefix-tree/
- https://leetcode.com/problems/number-of-islands/
- https://leetcode.com/problems/maximum-subarray/
- https://leetcode.com/problems/generate-parentheses/
- https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
- https://leetcode.com/problems/valid-perfect-square/
- https://leetcode-cn.com/problems/house-robber/
- https://leetcode.com/problems/reverse-bits/
- https://leetcode.com/problems/swap-nodes-in-pairs/
- https://leetcode.com/problems/relative-sort-array/
- https://leetcode.com/problems/maximum-length-of-repeated-subarray/
- https://leetcode.com/problems/first-unique-character-in-a-string/
- https://leetcode.com/problems/unique-paths/
- https://leetcode.com/problems/reverse-string-ii/
- https://leetcode.com/problems/longest-increasing-subsequence/


# Tips for interviews

1. Clarification: The question itself, boundaries, the volume of the dataset
2. Possible solutions: Try to get all possible solutions
- Compare time/space complexity
- Optimal solution
3. Coding: Simple(10-20 lines, High performance, Elegant code style)
4. Test cases

# The last word

commencement

https://www.youtube.com/watch?v=Hd_ptbiPoXM