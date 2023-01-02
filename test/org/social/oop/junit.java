package org.social.oop;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class SampleTest {
Math math;
@Before
public void setUp() throws Exception {
math = new Math(8, 2);
}
@Test
public void testSum() {
Assert.assertEquals(17, math.sum());
}
}