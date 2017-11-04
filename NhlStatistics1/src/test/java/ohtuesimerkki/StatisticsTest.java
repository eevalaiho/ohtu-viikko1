package ohtuesimerkki;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
	 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
            //public Player(String name, String team, int goals, int assists) {
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    double precision = 0.0001;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void testConstructorNonExistingTeam() {   
    	ArrayList<Player> teamZZZ = new ArrayList<Player>();
        assertEquals(teamZZZ, stats.team("ZZZ"));
    }
    @Test
    public void testConstructorExistingTeam() {   
        assertEquals(1, stats.team("PIT").size());
    }

    @Test
    public void testPlayerSearch() {
        assertEquals("PIT", stats.search("Lemieux").getTeam());
    }
    @Test
    public void testPlayerSearchNonExisting() {
        assertNull(stats.search("akfjak"));
    }
    @Test
    public void testTopScorers() {
    	List<Player> scorers = stats.topScorers(1);
        assertEquals(2,scorers.size(),precision);
    }
}