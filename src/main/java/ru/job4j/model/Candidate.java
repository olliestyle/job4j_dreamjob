package ru.job4j.model;

import java.util.Objects;

public class Candidate {
    private int id;
    private String name;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Candidate c = (Candidate) obj;
        return c.id == this.id && Objects.equals(c.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
