package com.lelyak.edu.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PutAction {
    private String key;
    private String value;
}
