package com.amigoscode.demo;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EmailValidatorTest {

    private final EmailValidator underTest = new EmailValidator();

    @Test
    public void itShouldValidateCorrectEmail() {
        assertThat(underTest.test("hello@gmail.com")).isTrue();
    }

    @Test
    public void itShouldValidateInCorrectEmail() {
        assertThat(underTest.test("hellogmail.com")).isFalse();
    }
    @Test
    public void itShouldValidateInCorrectEmailWithoutDotAtEnd() {
        assertThat(underTest.test("hello@gmailcom")).isFalse();
    }
}