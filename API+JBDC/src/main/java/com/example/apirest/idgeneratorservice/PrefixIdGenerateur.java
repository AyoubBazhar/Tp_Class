package com.example.apirest.idgeneratorservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PrefixIdGenerateur implements IdGenerateur {
    private int cmp = 0;

    @Value("${etudient.prefix}")
    private String prefix;
    @Override
    public String generateId() {
        cmp++;
        return prefix+cmp;
    }
}
