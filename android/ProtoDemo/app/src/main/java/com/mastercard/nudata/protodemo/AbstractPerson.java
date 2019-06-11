package com.mastercard.nudata.protodemo;

import com.mastercard.protobuf.PersonProto;

public abstract class AbstractPerson {
    PersonProto.Person person;

    public PersonProto.Person getPerson() {
        return person;
    }

    public void setPerson(PersonProto.Person person) {
        this.person = person;
    }
}
