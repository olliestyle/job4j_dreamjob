package ru.job4j.store;

import ru.job4j.model.Candidate;
import ru.job4j.model.Post;
import ru.job4j.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {
    private static final MemStore INST = new MemStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    private final static AtomicInteger POST_ID = new AtomicInteger(3);

    private final static AtomicInteger CANDIDATE_ID = new AtomicInteger(3);

    private final static AtomicInteger USER_ID = new AtomicInteger(3);

    private MemStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Job for Junior Java Developer"));
        posts.put(2, new Post(2, "Middle Java Job", "Job for Middle Java Developer"));
        posts.put(3, new Post(3, "Senior Java Job", "Job for Senior Java Developer"));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
        users.put(1, new User(1, "Egor", "egor@mail.ru", "111"));
        users.put(2, new User(2, "Oleg", "oleg@mail.ru", "222"));
        users.put(3, new User(3, "Pavel", "pavel@mail.ru", "333"));

    }

    public static MemStore instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    @Override
    public Collection<User> findAllUsers() {
        return users.values();
    }

    public void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    public Post findPostByName(String name) {
        return posts.values().
                stream().
                filter(post -> post.getName().equals(name)).
                findFirst().
                orElse(null);
    }

    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    public Candidate findCandidateByName(String name) {
        return candidates.values().
                stream().
                filter(candidate -> candidate.getName().equals(name)).
                findFirst().
                orElse(null);
    }

    @Override
    public User findUserById(int id) {
        return users.get(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return users.values().stream().filter(el -> el.getEmail().equals(email)).findFirst().orElse(null);
    }

    public void saveCandidate(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == 0) {
            user.setId(USER_ID.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    public void deleteCandidate(int id) {
        this.candidates.remove(id);
    }

    @Override
    public void deleteUser(int id) {
        this.users.remove(id);
    }
}
