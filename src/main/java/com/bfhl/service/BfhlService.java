package com.bfhl.service;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlService {

    public BfhlResponse processData(BfhlRequest request) {
        BfhlResponse res = new BfhlResponse();
        res.setIs_success(true);
        res.setUser_id("priyanshi_khorwal_09052006");
        res.setEmail("priyanshikhorwal231190@acropolis.in");
        res.setRoll_number("0827CS231196");

        List<String> odds = new ArrayList<>();
        List<String> evens = new ArrayList<>();
        List<String> alphas = new ArrayList<>();
        List<String> specials = new ArrayList<>();

        int sum = 0;
        StringBuilder letters = new StringBuilder();

        if (request != null && request.getData() != null) {
            for (String element : request.getData()) {
                if (element == null) {
                    continue;
                }
                String str = element.trim();
                if (str.isEmpty()) {
                    continue;
                }

                if (str.matches("\\d+")) {
                    int val = Integer.parseInt(str);
                    if (val % 2 == 0) {
                        evens.add(str);
                    } else {
                        odds.add(str);
                    }
                    sum += val;
                } else if (str.matches("[a-zA-Z]+")) {
                    alphas.add(str.toUpperCase());
                    letters.append(str);
                } else {
                    specials.add(str);
                    for (int i = 0; i < str.length(); i++) {
                        char c = str.charAt(i);
                        if (Character.isLetter(c)) {
                            letters.append(c);
                        }
                    }
                }
            }
        }

        res.setOdd_numbers(odds);
        res.setEven_numbers(evens);
        res.setAlphabets(alphas);
        res.setSpecial_characters(specials);
        res.setSum(String.valueOf(sum));

        String reversed = letters.reverse().toString();
        StringBuilder finalStr = new StringBuilder();
        boolean upper = true;

        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (Character.isLetter(c)) {
                if (upper) {
                    finalStr.append(Character.toUpperCase(c));
                } else {
                    finalStr.append(Character.toLowerCase(c));
                }
                upper = !upper;
            } else {
                finalStr.append(c);
            }
        }

        res.setConcat_string(finalStr.toString());
        return res;
    }
}
