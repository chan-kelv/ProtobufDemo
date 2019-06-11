package com.mastercard.nudata.protodemo;

import com.mastercard.protobuf.PersonProto;
import com.mastercard.protobuf.TeacherProto;

public class Teacher extends AbstractPerson {
    TeacherProto.Teacher teacher;

    public TeacherProto.Teacher getTeacher() {
        return teacher;
    }

    public Teacher(TeacherProto.Teacher teacher, PersonProto.Person person) {
        this.person = person;
        this.teacher = teacher;
    }
}
