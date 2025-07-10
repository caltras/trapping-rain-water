package com.skip.claudiotraspadini.elevation.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WaterTrapService {
    public int totalVolume(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trappedWater += Math.max(0, leftMax - height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trappedWater += Math.max(0, rightMax - height[right]);
            }
        }

        return trappedWater;
    }
}
