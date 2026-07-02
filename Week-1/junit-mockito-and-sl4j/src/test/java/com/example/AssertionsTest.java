package com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AssertionsTest {

    @Test
    public void shouldUseCommonAssertions() {
        String text = "lab";
        String missing = null;
        Object value = new Object();

        assertEquals("lab", text);
        assertTrue(text.startsWith("l"));
        assertFalse(text.endsWith("z"));
        assertNull(missing);
        assertNotNull(value);
    }
}
