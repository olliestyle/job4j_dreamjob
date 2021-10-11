package ru.job4j;

import ru.job4j.model.Candidate;
import ru.job4j.model.Post;
import ru.job4j.store.PsqlStore;
import ru.job4j.store.Store;

public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        System.out.println("Create New Post");
        store.savePost(new Post(0, "Java Job", "Job for Java Developer"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName() + " " + post.getDescription() + " " + post.getCreated());
        }

        System.out.println();
        System.out.println("Update Post");
        store.savePost(new Post(31, "Java Middle Job", "Job for Middle Java Developer"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName() + " " + post.getDescription() + " " + post.getCreated());
        }

        System.out.println();
        System.out.println("Find Post by Id");
        Post findPostById = store.findPostById(31);
        System.out.println(findPostById);

        System.out.println();
        System.out.println("Create New Candidate");
        store.saveCandidate(new Candidate(0, "Oleg"));
        for (Candidate candidate: store.findAllCandidates()) {
            System.out.println(candidate.getId() + " " + candidate.getName());
        }

        System.out.println();
        System.out.println("Update Candidate");
        store.saveCandidate(new Candidate(2, "Gleb"));
        for (Candidate candidate: store.findAllCandidates()) {
            System.out.println(candidate.getId() + " " + candidate.getName());
        }

        System.out.println();
        System.out.println("Find Candidate by Id");
        Candidate findCandidateById = store.findCandidateById(2);
        System.out.println(findCandidateById);
    }
}
