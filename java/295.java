/**
 * id: 295 find median from data stream
 * tags: heap
 * date: 2021-04-22
 */
class MedianFinder {
    private PriorityQueue<Integer> small = new PriorityQueue<Integer>(1, (a, b) -> b - a);
    private PriorityQueue<Integer> large = new PriorityQueue<Integer>(1, (a, b) -> a - b);
    
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        // make sure the size of small and large differ at most by 1
        if(small.size() == 0 && large.size() == 0) {
            small.add(num);
            return;
        }
        if(large.size() > 0 && num > large.peek()) {
            large.add(num);
        } else {
            small.add(num);
        }
        while(small.size() > large.size() + 1) {
            large.add(small.poll());
        }
        while(small.size() < large.size() - 1) {
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        // At least one queue is empty
        if(small.size() == 0) {
            return (double) large.peek();
        } else if(large.size() == 0) {
            return (double) small.peek();
        }
        
        int low = small.peek();
        int high = large.peek();        
        if(small.size() == large.size()) {
            return (double)(low + high) / 2.0;
        } else if(small.size() > large.size()) {
            return (double) low;
        } else {
            return (double) high;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */