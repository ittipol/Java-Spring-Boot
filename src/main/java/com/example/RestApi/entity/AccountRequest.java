package com.example.RestApi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountRequest {
    private String accountNo;
    private String name;
    private String description;
}
