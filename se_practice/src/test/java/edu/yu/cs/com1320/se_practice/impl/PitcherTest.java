package edu.yu.cs.com1320.se_practice.impl;

import static org.junit.jupiter.api.Assertions.*;

import edu.yu.cs.com1320.se_practice.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PitcherTest {

    Statistics s = new Statistics();

    @BeforeEach
    void setUp() {
        s.addPlayer(new Batter("Aaron Judge", "yankees", "cf", 118, 21, 27, 6,0, 6, 16, 16, 36, 0));
        s.addPlayer(new Pitcher("Gerrit Cole", "yankees", "sp", 8, 1, 1, 0,51.2,36,13,12,2,16,58,2));
        s.addPlayer(new Batter("DJ Lemahieu", "yankees", "3b", 133, 19, 33,7,1,5,18,11,35,2));
        s.addPlayer(new Batter("Anthony Rizzo", "yankees", "1b", 139, 22,42,5,0,6,17,15,33,5));
        s.addPlayer(new Pitcher("Clay Holmes", "yankees", "cl", 15,0,0,4,13.0,12,7,5,0,6,17,2));
        s.addPlayer(new Pitcher("Wandy Peralta", "yankees", "rp", 16,0,0,0,13.1,36,13,12,2,16,58,2));
    }
}