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
    public void testUnionAndPercolation(){
        assertFalse(percolation.percolates());
        percolation.open(1,1);
        percolation.open(2,1);
        assertTrue(percolation.getUf().connected(1, 6));
        percolation.open(3, 2);
        percolation.open(4,2);
        assertTrue(percolation.getUf().connected(12,17));
        percolation.open(2,2);
        assertTrue(percolation.getUf().connected(1,17));
        percolation.open(5,2);
        assertTrue(percolation.percolates());
        assertTrue(percolation.isFull(4,2));
    }

    @Test
    public void testPercolation(){
        Percolation perc8 = new Percolation(8);
        perc8.open(5,6);
        perc8.open(3,3);
        perc8.open(5,3);
        perc8.open(5,4);
        perc8.open(8,5);
        perc8.open(6,5);
        perc8.open(5,3);
        perc8.open(2,3);
        perc8.open(5,3);
        perc8.open(1,3);
        perc8.open(4,3);
        perc8.open(5,5);
        assertFalse(perc8.percolates());
        perc8.open(7,5);
        assertTrue(perc8.percolates());
    }
}