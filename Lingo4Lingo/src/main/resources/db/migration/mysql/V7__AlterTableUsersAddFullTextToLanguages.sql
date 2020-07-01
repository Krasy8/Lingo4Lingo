ALTER TABLE users
    ADD fulltext(
        language_native_1,
        language_native_2,
        language_native_3,
        language_spoken_1,
        language_spoken_2,
        language_spoken_3,
        language_spoken_4,
        language_spoken_5
    );
