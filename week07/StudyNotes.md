# DFS code templates

```
public List<List<Integer>> levelOrder(TreeNode root) 
{        
    List<List<Integer>> allResults = new ArrayList<>();        
    if(root==null){            
        return allResults;        
    }        
    
    travel(root,0,allResults);        
    return allResults;    
}    

private void travel(TreeNode root,int level,List<List<Integer>> results)
{        
    if(results.size()==level){            
        results.add(new ArrayList<>());        
    }        
    results.get(level).add(root.val);        
    if(root.left!=null){            
        travel(root.left,level+1,results);        
    }        
    if(root.right!=null){            
        travel(root.right,level+1,results);        
    }    
}
```

# BFS code templates

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


