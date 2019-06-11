package com.mastercard.nudata.protodemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mastercard.protobuf.PersonProto;
import com.mastercard.protobuf.StudentProto;

import java.util.ArrayList;
import java.util.List;

public class CreateUserFragment extends Fragment {
    private RecyclerView createPersonRecycleView;
    private Button registerBttn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup group = (ViewGroup) inflater.inflate(R.layout.fragment_create_use, container, false);
        createPersonRecycleView = group.findViewById(R.id.recycler_person_list);

        registerBttn = group.findViewById(R.id.btn_register);
        registerBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerStudent();
            }
        });

        List<AbstractPerson> abstractPeople = new ArrayList<>();
        PersonRecyclerAdapter adapter = new PersonRecyclerAdapter(abstractPeople);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        createPersonRecycleView.setLayoutManager(layoutManager);
        createPersonRecycleView.setAdapter(adapter);

        addStudent("Stan Marsh",
                "stan.marsh@southpark.com",
                "800-555-1111",
                PersonProto.Person.PhoneType.HOME,
                10,
                5);


        return group;
    }

    private void registerStudent() {
        String name = ((EditText)getView().findViewById(R.id.input_name)).getText().toString();
        String email = ((EditText)getView().findViewById(R.id.input_email)).getText().toString();
        String ageString = ((EditText)getView().findViewById(R.id.input_age)).getText().toString();
        int age = Integer.valueOf(ageString);
        String phoneString = ((EditText)getView().findViewById(R.id.input_phone)).getText().toString();
        boolean isStudent = ((Switch)getView().findViewById(R.id.switch_role)).isChecked();

        addStudent(name, email, phoneString, PersonProto.Person.PhoneType.HOME, age, 5);
    }

    private void addStudent(String name, String email, String phoneNum, PersonProto.Person.PhoneType phoneType, int age, int grade) {
        // Math class
        StudentProto.Student.SchoolSubject mathSubject = StudentProto.Student.SchoolSubject.newBuilder()
                .setName("MATH")
                .setClassroom(101)
                .build();

        // English Class
        StudentProto.Student.SchoolSubject englishSubject = StudentProto.Student.SchoolSubject.newBuilder()
                .setName("ENGL")
                .setClassroom(402)
                .build();

        // Student 1
        StudentProto.Student.Builder studentBuilder1 = StudentProto.Student.newBuilder();
        StudentProto.Student studentProto1 = studentBuilder1
                .setGrade(grade)
                .addEnrolled(mathSubject)
                .addEnrolled(englishSubject)
                .build();

        PersonProto.Person.PhoneNumber phoneNumber = PersonProto.Person.PhoneNumber.newBuilder()
                .setNumber(phoneNum)
                .setType(phoneType)
                .build();
        PersonProto.Person personProto = PersonProto.Person.newBuilder()
                .setAge(10)
                .setName(name)
                .setEmail(email)
                .addPhones(phoneNumber)
                .build();
        Student student1 = new Student(studentProto1, personProto);

        ((PersonRecyclerAdapter)createPersonRecycleView.getAdapter()).addPerson(student1);
    }
}
