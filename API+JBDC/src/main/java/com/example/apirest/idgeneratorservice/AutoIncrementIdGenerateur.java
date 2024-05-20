package com.example.apirest.idgeneratorservice;

import org.springframework.stereotype.Service;

@Service
public class AutoIncrementIdGenerateur implements IdGenerateur {
    private static int cmp =0;
    @Override
    public String generateId() {
        cmp++;
        return String.valueOf(cmp);
    }
}

