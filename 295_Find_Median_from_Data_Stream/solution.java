class MedianFinder {
    /*
        Design a data structure to find the median from a data stream
        - addNum adds numbers into a data structure
        - findMedian returns the median of the stored numbers thus far

        Strategy
        1.) Naive - single array -  sort and retrieve median every call addNum O(1), findMedian O(nlogn)
        2.) A min and max heap -  arrange in such a way that the median has to be 
            - ((double) minHeap.peek + maxHeap.peek)/2 OR
            - the peek of the larger heap
            - We will try to maintain equal sizes as possible, allowance of +1 max

    */
    private PriorityQueue<Integer> minHeap; // larger elements, smallest at the top
    private PriorityQueue<Integer> maxHeap; // smaller elements, largest at the top

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b)->a-b);
        maxHeap = new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if (maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double)(maxHeap.peek() + minHeap.peek()) /2;
        }else if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }else{
            return (double) minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */