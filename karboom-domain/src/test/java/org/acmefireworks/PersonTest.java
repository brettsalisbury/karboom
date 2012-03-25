package org.acmefireworks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 17/03/12
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonTest {

    private Person personTwo;
    private Person personOne;

    @Before
    public void setUp() {
        personOne = new Person("Allan", "Border");
        personTwo = new Person("Allan", "Border");
    }

    @Test
    public void shouldIndicateTwoPersonsAreEqualIfFirstnameAndSurnameIsTheSame() {
        assertEquals(personOne, personTwo);
    }

    @Test
    public void shouldHaveSameHashCodeIfTwoPersonInstancesAreEqual() {
        assertEquals(personOne.hashCode(), personTwo.hashCode());
    }

    @Test
    public void shouldReturnFormattedNameAsToStringValue() {
        testPersonStringIsFormattedCorrectly("Graham", "Chapman");
    }

    @Test
    public void shouldReturnFormattedNameAsToStringValueEvenIfNamesAreNull() {
        testPersonStringIsFormattedCorrectly(null, null);
    }

    private void testPersonStringIsFormattedCorrectly(String firstName, String surname) {

        // Given
        Person person = new Person(firstName, surname);
        String expectedStringValue = String.format("%s %s", firstName, surname);

        // When
        String actualStringValue = person.toString();

        // Then
        assertThat(actualStringValue, is(equalTo(expectedStringValue)));
    }

}
