Study Notes

# Recursion 

Recursion and loops are the same after compiling the code.

See the movie Inception to get more concept
- Go down the next layer of the dream, and go back(up) the upper layer
- Using sounds(arguments) to sync information to the upper layer 
- All environments and people are a copy, and the main characters go through multiple layers of dreams.

## code template

### Python
```
def recursion(level, param1, param2, ...):
    # recursion terminator
    if level > MAX_LEVEL:
        process_result
        return

    # process logic in current level
    process(level, data...)

    # drill down
    self.recursion(level + 1, p1, ...)

    # reverse the current level status if needed

```

### Java

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

## Thinking points
- Do NOT do recursion as human beings do
- Find the simplest method to split the task into repeatable sub-tasks
- Apply mathematical induction

# Divide & Conquer

Recursion state tree

## Code template

# python
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



