package com.atimera.calculatrice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class CalculatriceTest {

    private Calculatrice calculatriceUnderTest;

    private static Instant debut;

    @BeforeEach
    public void beforeEach() {
        System.out.println("Initialisation de la classe Calculatrice");
        calculatriceUnderTest = new Calculatrice();
    }

    @AfterEach
    public void afterEach(){
        System.out.println("Désaffectation de la classe pour éviter toute réutilisation");
        calculatriceUnderTest = null;
    }

    @BeforeAll
    public static void beforeAll(){
        debut = Instant.now();
    }

    @AfterAll
    public static void afterAll(){
        long duree = Duration.between(debut, Instant.now()).toMillis();
        System.out.println(
                MessageFormat.format("Durée des tests = {0} ms",
                duree));
    }


    @ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
    @CsvSource({"50,3,53", "12,5,17", "62,8,70", "-8,8,0", "4,-9,-5"})
    public void ajouter_shouldAddTwoIntegerNumbers(int arg1, int arg2, int expectedResult){
        // Arrange
        // Act
        int resulat = calculatriceUnderTest.ajouter(arg1, arg2);

        // Assert
        assertThat(resulat)
                .isEqualTo(expectedResult);
    }

    @Test
    public void ajouter_shouldMultiplyTwoIntegerNumbers(){
        // Arrange
        int a=2, b=8;

        // Act
        int resulat = calculatriceUnderTest.multiplier(a, b);

        // Assert
        assertThat(resulat).isEqualTo(16);
    }

    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = {0, 4, -5, 130})
    public void multiplier_shouldReturnZero_WhenMultiplierParZero(int arg){
        // Arrange
        // Act
        int resultat = calculatriceUnderTest.multiplier(arg, 0);

        // Assert
        assertThat(resultat).isZero();
    }

    @Test
    public void digitsSet_shouldReturnsTheSetOfDigits_ofPositiveInteger() {
        // GIVEN
        int number = -9581497;

        // WHEN
        Set<Integer> actualDigits = calculatriceUnderTest.digitsSet(number);

        // THEN
        assertThat(actualDigits).containsExactlyInAnyOrder(1, 4, 9, 5, 8, 7);
    }

}