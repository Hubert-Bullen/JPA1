package be.vdab;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by Hyuberuto on 27/05/15.
 */
public class Film_Actor_DirectorEntityManagerFactoryTest extends AbstractEntityManagerFactoryTest {

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

    @Test
    public void testAddActorsAndDirectorToFilm(){ //Deze test zetten we eigenlijk best in de @Before zodat we gegarandeerd worden dat die dit altijd waar is voor alle tests.
    // Nu kunnen we ongeluk hebben.
        Film stone = em.find(Film.class,1);
        List<Actor> stoneActors = new ArrayList<>();
        stoneActors.add(em.find(Actor.class,1));
        stoneActors.add(em.find(Actor.class,2));
        stone.addActors(stoneActors);
        stone.addDirector(em.find(Director.class,1));
    }

    @Test
    public void testFilmHasActorsAndDirector(){
        Film film = em.find(Film.class, 1);
        List<Actor> filmActors = film.getActors();
        for (Actor ac : filmActors){
            assertNotNull(ac.fullName());
            System.out.println("---------------");
            System.out.println(ac.fullName());
        }
        assertNotNull(film.getDirector().fullName());
        System.out.println("*****************");
        System.out.println("Director: " + film.getDirector().fullName());
        System.out.println("");

    }

    @Test
    public void testActorHasFilms(){
        Actor actor = em.find(Actor.class,1);
        List<Film> actorFilms = actor.getFilms();
        for (Film af : actorFilms){
            assertNotNull(af.getTitle());
            System.out.println("----------------");
            System.out.println(af.getTitle());
        }
        System.out.println("");
    }
    @Test
    public void testActorFilmHasDirector(){
        Actor actor = em.find(Actor.class,1);
        List<Film> actorFilms = actor.getFilms();
        for (Film af : actorFilms){
            assertNotNull(af.getDirector());
            System.out.println("*****************");
            System.out.println(af.getDirector().fullName());
        }
        System.out.println("");


    }
}
