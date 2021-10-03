
# heapify code example
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

# mergeSort code example:

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

# quickSort code example
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

# LRU Cache code example
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

# Some other sources
- https://www.bilibili.com/video/av63851336
- https://www.bilibili.com/video/av25136272
- https://www.cnblogs.com/onepixel/p/7674659.html
- https://www.sqlpassion.at/archive/2018/01/06/understanding-the-meltdown-exploit-in-my-own-simple-words/
- https://en.wikipedia.org/wiki/Cache_replacement_policies
- https://www.cnblogs.com/cpselvis/p/6265825.html
- https://github.com/Baqend/Orestes-Bloomfilter
- https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java

