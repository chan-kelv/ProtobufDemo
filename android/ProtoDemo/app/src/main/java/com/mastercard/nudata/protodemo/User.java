package com.mastercard.nudata.protodemo;

import com.google.protobuf.ByteString;
import com.mastercard.protobuf.UserProto;

public class User {
    static UserProto.Person generatePerson() {
        UserProto.Person.Builder userBuilder = UserProto.Person.newBuilder()
                .setName("Kelvin")
                .setEmail("chan-kelv@github.com");

        UserProto.Person.PhoneNumber.Builder phoneBuilder = UserProto.Person.PhoneNumber.newBuilder()
                .setNumber("800-555-1111")
                .setType(UserProto.Person.PhoneType.MOBILE);

        userBuilder.addPhones(phoneBuilder.build());

        return userBuilder.build();
    }

    static ByteString generateByte(UserProto.Person person) {
        return UserProto.Person.newBuilder(person).build().toByteString();
    }
}
