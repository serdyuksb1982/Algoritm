import junit.framework.TestCase;;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MainTest extends TestCase
{

    @Test
    public void testBubleSort() {
        System.out.println ("Bubble sorting using array");
        int[] array = {3,5,4,8,6,9,2,1,7};
        int[] expResult = {1,2,3,4,5,6,7,8,9};
        int[] result = Main.bubleSort ( array );
        assertArrayEquals ( expResult,result );

    }

    @Test
    public void testQuicSort() {
        System.out.println ("Quic sorting using array");
        int[] array = {3,5,4,8,6,9,2,1,7};
        int[] expResult = {1,2,3,4,5,6,7,8,9};

        int[] result = Main.quicSort ( array,0, array.length - 1);
        assertArrayEquals ( expResult,result );
    }

    @Test
    public void testGetMaxElement() {
        System.out.println ("Max element search");
        int[] array = {3,5,4,8,6,9,2,1,7};
        int expResult =  9;
        int result = Main.getMaxElement ( array );
        assertEquals ( expResult,result );
    }

    @Test
    public void testBinarySearch() {
        System.out.println ("Binary search using array");
        int[] array = {1,2,3,4,5,6,7};
        int item = 7;

        int result = Main.binarySearch ( array,0,array.length , item );
        assertEquals ( item,result );
    }

    @Test
    public void testFactorial() {
        System.out.println ("Factorial");
        long expResult = 120L;
        long result = Main.factorial ( 5 );
        assertEquals ( expResult,result );
    }

    @Test
    public void testIsPrime() {
        System.out.println ("Prime test");
        boolean result = Main.isPrime ( 5 );
        Assert.assertTrue ( result );
    }
}
