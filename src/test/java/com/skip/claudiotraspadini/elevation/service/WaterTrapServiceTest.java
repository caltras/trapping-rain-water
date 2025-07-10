package com.skip.claudiotraspadini.elevation.service;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class WaterTrapServiceTest {

    @Inject
    WaterTrapService service;

    @Test
    void testCase_3_2_4_1_2() {
        int[] height = {3,2,4,1,2};
        assertEquals(2, service.totalVolume(height));
    }

    @Test
    void testCase_4_1_1_0_2_3() {
        int[] height = {4,1,1,0,2,3};
        assertEquals(8, service.totalVolume(height));
    }

    @Test
    void testCase_5_5_1_7_1_1_5_2_7_6() {
        int[] height = {5,5,1,7,1,1,5,2,7,6};
        assertEquals(23, service.totalVolume(height));
    }
    
    @Test
    void testTypicalCase() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(6, service.totalVolume(height));
    }

    @Test
    void testNoTrappedWater() {
        int[] height = {0,1,2,3,4,5};
        assertEquals(0, service.totalVolume(height));
    }

    @Test
    void testEmptyArray() {
        int[] height = {};
        assertEquals(0, service.totalVolume(height));
    }

    @Test
    void testNullArray() {
        assertEquals(0, service.totalVolume(null));
    }

    @Test
    void testAllSameHeight() {
        int[] height = {2,2,2,2};
        assertEquals(0, service.totalVolume(height));
    }

} 