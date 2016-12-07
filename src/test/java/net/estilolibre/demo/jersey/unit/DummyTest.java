package net.estilolibre.demo.jersey.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

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
		List<Integer> list = Arrays.asList(5, 2, 4);
        assertThat(list, hasSize(3));
        // ensure the order is correct
        assertThat(list, contains(5, 2, 4));
        assertThat(list, containsInAnyOrder(2, 4, 5));
        assertThat(list, everyItem(greaterThan(1)));
    }
}
