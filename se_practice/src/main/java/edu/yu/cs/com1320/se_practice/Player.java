package edu.yu.cs.com1320.se_practice;

import java.util.List;

public abstract class Player {
    protected String team;
    protected String position;
    protected String name;

    public abstract String getName();

    public abstract String getTeam();

    public abstract String getPosition();

    public abstract List<String> getAllStats();
}
