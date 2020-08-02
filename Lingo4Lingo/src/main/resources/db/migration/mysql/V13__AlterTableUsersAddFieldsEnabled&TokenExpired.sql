alter table users
    add column enabled boolean after password,
    add column token_expired boolean after enabled;
