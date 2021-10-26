package ru.job4j.store;

import org.junit.Test;
import ru.job4j.model.Candidate;
import ru.job4j.model.Post;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PsqlStoreTest {
    @Test
    public void whenCreatePost() {
        Store store = PsqlStore.instOf();
        Post post = new Post(0, "Java Job", "Job for Java dev");
        store.savePost(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
        System.out.println(postInDb.getId());
        assertThat(postInDb.getDescription(), is(post.getDescription()));
    }

    @Test
    public void whenCreateCandidate() {
        Store store = PsqlStore.instOf();
        Candidate candidate = new Candidate(0, "Junior Java");
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        System.out.println(candidate.getId());
        assertThat(candidate.getName(), is(candidateInDb.getName()));
    }
}