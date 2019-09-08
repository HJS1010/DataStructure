package com.stone.queue;

import java.util.PriorityQueue;
import java.util.*;

/**
 * 使用Java PriorityQueue
 * 内部实现是最小堆
 */
public class Solution5 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (pq.peek() < map.get(key)) {
                pq.remove();
                pq.add(key);
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(((new Solution5()).topKFrequent(nums, k)));

        int[] nums1 = {1, 1};
        int k1 = 1;
        System.out.println(((new Solution5()).topKFrequent(nums1, k1)));

    }
}
