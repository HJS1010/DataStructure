package com.stone.queue;

import java.util.PriorityQueue;
import java.util.*;

/**
 * 使用Java PriorityQueue
 * 内部实现是最小堆
 * 使用Comparator
 */
public class Solution3 {

    private class Freq {
        private int e;
        private int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq a, Freq b) {
                return a.freq - b.freq;
            }
        });
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (pq.peek().freq < map.get(key)) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(((new Solution3()).topKFrequent(nums, k)));

        int[] nums1 = {1, 1};
        int k1 = 1;
        System.out.println(((new Solution3()).topKFrequent(nums1, k1)));

    }
}
