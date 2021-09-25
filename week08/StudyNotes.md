
# Trie code template
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


# Disjoint code template

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

# Self-balancing binary search tree
https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree

# How to Convert from Decimal to Binary
https://www.wikihow.com/Convert-from-Decimal-to-Binary


# N-queen code example (resolving by bit)

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