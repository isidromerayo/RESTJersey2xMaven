package net.estilolibre.demo.jersey.unit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Test;

/**
 * @author isidromerayo
 *
 */
public class DummyTest {

	@Test
	public final void dummyJUnit() {
		assertTrue(true);
		assertFalse(false);
		String expectedValue = "hi";
		String actual = "hi";
		assertEquals(expectedValue,actual);
	}
	@Test
    public void dummyHamcrest() {
		assertThat("123",is("123"));
		List<Integer> list = Arrays.asList(5, 2, 4);
        assertThat(list, hasSize(3));
        // ensure the order is correct
        assertThat(list, contains(5, 2, 4));
        assertThat(list, containsInAnyOrder(2, 4, 5));
        assertThat(list, everyItem(greaterThan(1)));
    }
}
