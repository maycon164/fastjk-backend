package com.deadlock.fastjk.data.auth;

public record GoogleUserDTO (
    String id,
    String email,
    Boolean verified_email,
    String name,
    String given_name,
    String family_name,
    String picture,
    String locale
){}
