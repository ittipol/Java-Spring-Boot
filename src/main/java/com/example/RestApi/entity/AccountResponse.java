package com.example.RestApi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountResponse {
    private int id;
    private String accountNo;
    private String name;
}
