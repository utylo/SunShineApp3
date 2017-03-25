package app.com.example.android.sunshineapp.data;

import android.test.AndroidTestCase;

/**
 * Created by UTYLO on 3/23/2017.
 */
 public class TestPractice extends AndroidTestCase {


    @Override
    protected void setUp() throws Exception { super.setUp();}

    public void testThatDemonstratesAssertions() throws Throwable {

        int a = 5;
        int b = 3;
        int c = 5;
        int d = 10;

        assertEquals("X should b equal",a,c);
        assertTrue("Y should be equal",d > a);
        assertFalse("Z should be false",a == b);

        if (b > d) {
            fail("XX should never happen");

        }
    }
    @Override
    protected void  tearDown() throws Exception { super.tearDown(); }




}



