package be.vdab;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by Hyuberuto on 27/05/15.
 */
public class Film_ActorEntityManagerFactoryTest extends AbstractEntityManagerFactoryTest {

    @Test
    public void testCreateActor(){
        Actor dRadcliffe = new Actor("Daniel","Radcliffe", Gender.MALE);
        assertEquals("Radcliffe Daniel", dRadcliffe.fullName());
    }

    @Test
    public void testCreateFilm(){
        Film chamber = new Film("Harry Potter and the Chamber of Secrets", 161, Genre.FANTASY);
        assertEquals(161, chamber.getLength());
    }

    @Test
    public void testAddAndRemoveFilm(){
        Film chamber = new Film("Harry Potter and the Chamber of Secrets", 161, Genre.FANTASY);
        em.persist(chamber);
        em.remove(em.find(Film.class,chamber.getId()));
        em.flush();
        assertNull(em.find(Film.class, chamber.getId()));
    }

    @Test
    public void testAddActor(){
        Actor dRadcliffe = new Actor("Daniel","Radcliffe", Gender.MALE);
        em.persist(dRadcliffe);
        assertNotNull(em.find(Actor.class,dRadcliffe.getId()));
    }
}
