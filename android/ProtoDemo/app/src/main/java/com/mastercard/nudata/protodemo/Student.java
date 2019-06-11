package com.mastercard.nudata.protodemo;

import com.mastercard.protobuf.PersonProto;
import com.mastercard.protobuf.StudentProto;

public class Student extends AbstractPerson {
    StudentProto.Student student;

    public StudentProto.Student getStudent() {
        return student;
    }

    public Student(StudentProto.Student student, PersonProto.Person person) {
        this.student = student;
        this.person = person;
    }
}
