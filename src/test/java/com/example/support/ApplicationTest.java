package com.example.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.JerseyRsApplication;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SpringApplicationConfiguration(classes = JerseyRsApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
//@WebIntegrationTest("server.port=9000") //Didnt work
@ActiveProfiles("web")
//@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public @interface ApplicationTest {
		
}





//Some examples for Fluent assertion for Java.
/*
// entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.*;

// in the examples below fellowshipOfTheRing is a List<TolkienCharacter>

// basic assertions
assertThat(frodo.getName()).isEqualTo("Frodo");
// as() is used to describe the test and will be shown before the error message
assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(33);
assertThat(frodo).isNotEqualTo(sauron)
                 .isIn(fellowshipOfTheRing);

// chaining string specific assertions
assertThat(frodo.getName()).startsWith("Fro")
                           .endsWith("do")
                           .isEqualToIgnoringCase("frodo");

// collection specific assertions (there are plenty more)
assertThat(fellowshipOfTheRing).hasSize(9)
                               .contains(frodo, sam)
                               .doesNotContain(sauron);

// Java 8 exception assertion, standard style ...
assertThatThrownBy(() -> { throw new Exception("boom!"); }).hasMessage("boom!");
// ... or BDD style
Throwable thrown = catchThrowable(() -> { throw new Exception("boom!"); });
assertThat(thrown).hasMessageContaining("boom");

// using 'extracting' feature to check fellowshipOfTheRing character's names (Java 7)
assertThat(fellowshipOfTheRing).extracting("name")
                               .contains("Boromir", "Gandalf", "Frodo", "Legolas")
// same thing using Java 8 method reference
assertThat(fellowshipOfTheRing).extracting(TolkienCharacter::getName)
                               .doesNotContain("Sauron", "Elrond");

// extracting multiple values at once grouped in tuples (Java 7)
assertThat(fellowshipOfTheRing).extracting("name", "age", "race.name")
                               .contains(tuple("Boromir", 37, "Man"),
                                         tuple("Sam", 38, "Hobbit"),
                                         tuple("Legolas", 1000, "Elf"));

// filtering a collection before asserting in Java 7 ... 
assertThat(fellowshipOfTheRing).filteredOn("race", HOBBIT)
                               .containsOnly(sam, frodo, pippin, merry);
// ... or in Java 8
assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o"))
                               .containsOnly(aragorn, frodo, legolas, boromir);

// combining filtering and extraction (yes we can)
assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o"))
                               .containsOnly(aragorn, frodo, legolas, boromir)
                               .extracting(character -> character.getRace().getName())
                               .contains("Hobbit", "Elf", "Man");



*/