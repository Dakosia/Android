package com.example.androidlesson02;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Этот класс который представляет одну строку в RecyclerView
 * Он  содержит ссылки на те обьекты которые необходимо отобразить.
 * В нашем случае это два объекта TextView, которые отображают имя и телефнон.
 */
public class MyHolder extends RecyclerView.ViewHolder {
    private TextView nameView;
    private TextView surnameView;
    private TextView phoneView;
    private TextView emailView;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
        this.nameView = (TextView) itemView.findViewById(R.id.name);
        this.surnameView = (TextView) itemView.findViewById(R.id.surname);
        this.phoneView = (TextView) itemView.findViewById(R.id.phone);
        this.emailView = (TextView) itemView.findViewById(R.id.email);
    }

    public TextView getNameView() {
        return nameView;
    }

    public TextView getSurnameView() {
        return surnameView;
    }

    public TextView getPhoneView() {
        return phoneView;
    }

    public TextView getEmailView() {
        return emailView;
    }
}
