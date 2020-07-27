package com.example.androidlesson02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class AddContactActivity extends AppCompatActivity {

    private TextInputLayout textInputName;
    private TextInputLayout textInputSurname;
    private TextInputLayout textInputPhone;
    private TextInputLayout textInputEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        textInputName = findViewById(R.id.text_input_name);
        textInputSurname = findViewById(R.id.text_input_surname);
        textInputPhone = findViewById(R.id.text_input_phone);
        textInputEmail = findViewById(R.id.text_input_email);
    }

    // Валидация
    private boolean validateName() {
        String nameInput = textInputName.getEditText().getText().toString().trim();

        // Проверка пустое ли поле Name
        // если да, то отображение ошибки снизу
        if (nameInput.isEmpty()) {
            textInputName.setError("Field can't be empty");
            return false;
        } else {
            textInputName.setError(null);
            return true;
        }
    }

    private boolean validatePhone() {
        String phoneInput = textInputPhone.getEditText().getText().toString().trim();

        // Проверка пустое ли поле Phone
        // если да, то отображение ошибки снизу
        if (phoneInput.isEmpty()) {
            textInputPhone.setError("Field can't be empty");
            return false;
        } else {
            textInputPhone.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        // Если пользователь вводит поле email, проверка соответствует ли введенный email паттерну
        if (!emailInput.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    public void addContact(View v) {
        if (!validateName() | !validatePhone() | !validateEmail()) {
            return;
        }

        String nameInput = textInputName.getEditText().getText().toString();
        String surnameInput = textInputSurname.getEditText().getText().toString().trim();
        String phoneInput = textInputPhone.getEditText().getText().toString().trim();
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        // Добавление нового контакта в псевдобазу для отображения в списке RecyclerView
        MainActivity.contacts.add(new Contact(nameInput, surnameInput, phoneInput, emailInput));
        MainActivity.adapter.notifyDataSetChanged();
        finish();
    }
}
