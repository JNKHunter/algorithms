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
    public void checkNumSites(){
        assertEquals(25, percolation.getNumSites());
    }

}