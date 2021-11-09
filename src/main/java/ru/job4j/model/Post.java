package ru.job4j.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    private int id;
    private String name;
    private String description;
    private LocalDateTime created;
    private String date;

    public Post(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        created = LocalDateTime.now();
    }

    public Post(int id, String name, String description, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Post post = (Post) obj;
        return id == post.id;
    }

    @Override
    public int hashCode() {
       return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", created=" + created + '}';
    }
}
