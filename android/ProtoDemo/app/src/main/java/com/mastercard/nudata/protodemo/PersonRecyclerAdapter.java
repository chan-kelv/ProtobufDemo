package com.mastercard.nudata.protodemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonRecyclerAdapter.PersonViewHolder> {
    List<AbstractPerson> schoolPeople;

    public PersonRecyclerAdapter(List<AbstractPerson> schoolPeople) {
        this.schoolPeople = schoolPeople;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_person, parent, false);
        return new PersonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        AbstractPerson person = schoolPeople.get(position);
        holder.name.setText(person.getPerson().getName());
        holder.phone.setText(person.getPerson().getPhones(0).getNumber());
        holder.email.setText(person.getPerson().getEmail());

        StringBuilder ageAndRole = new StringBuilder();
        ageAndRole.append("Age: ").append(person.getPerson().getAge());
        if (person instanceof Student) {
            ageAndRole.append(" - Student");
        } else {
            ageAndRole.append(" - Teacher");
        }
        holder.ageAndRole.setText(ageAndRole.toString());
    }

    @Override
    public int getItemCount() {
        return schoolPeople.size();
    }

    public void addPerson(AbstractPerson person) {
        schoolPeople.add(person);
        notifyDataSetChanged();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView email;
        TextView phone;
        TextView ageAndRole;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_name);
            email = itemView.findViewById(R.id.txt_email);
            phone = itemView.findViewById(R.id.txt_phone);
            ageAndRole = itemView.findViewById(R.id.ageAndRole);
        }
    }
}
