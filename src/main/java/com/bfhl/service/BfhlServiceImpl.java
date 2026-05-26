package com.bfhl.service;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
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
        StringBuilder sb = new StringBuilder();

        if (request.getData() != null) {
            for (String s : request.getData()) {
                if (s == null || s.isEmpty()) continue;

                if (s.matches("\\d+")) {
                    int n = Integer.parseInt(s);
                    if (n % 2 == 0) {
                        evens.add(s);
                    } else {
                        odds.add(s);
                    }
                    sum += n;
                } else if (s.matches("[a-zA-Z]+")) {
                    alphas.add(s.toUpperCase());
                    sb.append(s);
                } else {
                    specials.add(s);
                    // extract any hidden letters
                    for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (Character.isLetter(c)) {
                            sb.append(c);
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

        String reversed = sb.reverse().toString();
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
