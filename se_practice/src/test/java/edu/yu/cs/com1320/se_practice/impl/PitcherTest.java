package edu.yu.cs.com1320.se_practice.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PitcherTest {

    Pitcher p;

    @BeforeEach
    void setUp() {
        p = new Pitcher("Gerrit Cole", "yankees", "sp", 8, 1, 1, 0,51.2,36,13,12,2,16,58,2);
    }

    @Test
    void getWHIP() {
        double whip = p.getWhip();
        assertEquals(1.016,whip);
    }

    @Test
    void getERA() {
        double ERA = p.getERA();
        assertEquals(2.089, ERA);
    }
    @Test
    void soper9() {
        double so = p.getStrikeoutsPer9();
        assertEquals(10.2, so);
    }

    @Test
    void hper9() {
        double hper9 = p.getHitsPer9();
        assertEquals(6.3, hper9);
    }

    @Test
    void hrper9() {
        double hr = p.getHomeRunsPer9();
        assertEquals(0.4, hr);
    }

    @Test
    void wper9() {
        double walks = p.getWalksPer9();
        assertEquals(2.8, walks);
    }


}
