package com.mastercard.nudata.protodemo;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.mastercard.protobuf.PersonProto;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void serializePerson() throws InvalidProtocolBufferException {
        // create a phone number for the person
        PersonProto.Person.PhoneNumber phoneNumber = PersonProto.Person.PhoneNumber.newBuilder()
                .setNumber("800-555-1111")
                .setType(PersonProto.Person.PhoneType.HOME)
                .build();

        // Person can be directly created with the buildler
        PersonProto.Person person = PersonProto.Person.newBuilder()
                .setAge(10)
                .setName("Stan Marsh")
                .setEmail("stan.marsh@southpark.com")
                .addPhones(phoneNumber)
                .build();

        // byte array can be created from the proto person object to be sent to another system
        ByteString serializePerson = person.toByteString();

        // any input byte stream (e.g. from another system) can be deseriazed back into a person to be used
        PersonProto.Person deserializePerson = PersonProto.Person.parseFrom(serializePerson);
        assertEquals(person, deserializePerson);
        assertEquals(person.getName(), deserializePerson.getName());
    }
}