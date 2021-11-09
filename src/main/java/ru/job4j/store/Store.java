package ru.job4j.store;

import ru.job4j.model.Candidate;
import ru.job4j.model.City;
import ru.job4j.model.Post;
import ru.job4j.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Post> findLastDayPosts();

    Collection<Candidate> findAllCandidates();

    Collection<Candidate> findLastDayCandidates();

    Collection<User> findAllUsers();

    Collection<City> findAllCities();

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
