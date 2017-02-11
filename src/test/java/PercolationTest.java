import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jhunter on 2/11/17.
 */
public class PercolationTest {

    private Percolation percolation;

    @Before
    public void setup(){
        percolation = new Percolation(5);
    }

    @Test
    public void testNumSites(){
        assertEquals(25, percolation.getNumSites());
    }

    @Test
    public void testRowCol2ArrayIndex(){
        assertEquals(12, percolation.rowCol2ArrayIndex(3,2));
    }

    @Test
    public void testOpenSite(){
        assertFalse(percolation.isOpen(1,1));
        assertFalse(percolation.isOpen(5,5));

        percolation.open(1,1);
        assertTrue(percolation.isOpen(1,1));

        percolation.open(5,5);
        assertTrue(percolation.isOpen(5,5));
    }

    @Test
    public void testUnion(){
        percolation.open(1,1);
        percolation.open(2,1);
        assertTrue(percolation.getUf().connected(1, 6));

    }
}