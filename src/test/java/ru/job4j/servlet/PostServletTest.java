package ru.job4j.servlet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.model.Post;
import ru.job4j.store.PsqlStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostServletTest {

    static PsqlStore store = PsqlStore.instOf();
    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (BufferedReader br = new BufferedReader(new FileReader("test.properties"))) {
            Properties config = new Properties();
            config.load(br);
            Class.forName(config.getProperty("driver-class-name"));
            store.setConfigForTests(config);
            connection = store.getPoolForTest().getConnection();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM post")) {
            statement.execute();
        }
    }

    @Test
    public void whenSavePostAndFindByGeneratedIdThenMustBeTheSame() {
        Post post = new Post(0, "Junior dev", "Job for Funior dev");
        store.savePost(post);
        System.out.println(post.getId());
        assertEquals(post, store.findPostById(post.getId()));
    }

    /*
    @Test
    public void whenCreatePost() throws Exception {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("n");
        when(req.getParameter("description")).thenReturn("d");
        when(PsqlStore.instOf()).thenReturn(store);
        new PostServlet().doPost(req, resp);
        Post added = store.findAllPosts().stream().findFirst().orElse(null);
        assertThat(added.getName(), is("n"));
        assertThat(added.getDescription(), is("d"));
    }
    */
}