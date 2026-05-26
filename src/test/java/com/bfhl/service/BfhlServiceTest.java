package com.bfhl.service;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BfhlServiceTest {

    private final BfhlService bfhlService = new BfhlServiceImpl();

    @Test
    void testProcessDataWithMixedInput() {
        BfhlRequest request = new BfhlRequest();
        request.setData(Arrays.asList("a", "1", "334", "4", "R", "$"));

        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.isIs_success());
        assertEquals("priyanshi_khorwal_09052006", response.getUser_id());
        assertEquals("priyanshikhorwal231190@acropolis.in", response.getEmail());
        assertEquals("0827CS231196", response.getRoll_number());
        assertEquals(Arrays.asList("1"), response.getOdd_numbers());
        assertEquals(Arrays.asList("334", "4"), response.getEven_numbers());
        assertEquals(Arrays.asList("A", "R"), response.getAlphabets());
        assertEquals(Arrays.asList("$"), response.getSpecial_characters());
        assertEquals("339", response.getSum());
        // allAlphabets = "aR"
        // reverse = "Ra"
        // alt caps = "Ra" (R -> upper, a -> lower)
        assertEquals("Ra", response.getConcat_string());
    }

    @Test
    void testProcessDataWithMultiCharInput() {
        BfhlRequest request = new BfhlRequest();
        request.setData(Arrays.asList("A", "ABCD", "DOE"));

        BfhlResponse response = bfhlService.processData(request);

        assertEquals("EoDdCbAa", response.getConcat_string());
    }

    @Test
    void testProcessDataWithEmptyArray() {
        BfhlRequest request = new BfhlRequest();
        request.setData(List.of());

        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.getOdd_numbers().isEmpty());
        assertTrue(response.getEven_numbers().isEmpty());
        assertTrue(response.getAlphabets().isEmpty());
        assertTrue(response.getSpecial_characters().isEmpty());
        assertEquals("0", response.getSum());
        assertEquals("", response.getConcat_string());
    }
}
