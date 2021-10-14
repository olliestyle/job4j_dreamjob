package ru.job4j.store;

import ru.job4j.model.Candidate;
import ru.job4j.model.Post;
import ru.job4j.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<User> findAllUsers();

    void savePost(Post post);

    void saveCandidate(Candidate candidate);

    void saveUser(User user);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    User findUserById(int id);

    User findUserByEmail(String email);

    void deleteCandidate(int id);

    void deleteUser(int id);
}
