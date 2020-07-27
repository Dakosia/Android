package com.example.androidlesson02;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<Contact> contacts = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Инициализация RecyclerView
        recyclerView = findViewById(R.id.recycleView);

        //Магия котораю постараюсь обьяснить в будущем.
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);

        //Инициализируем нашу псевдо базу данных
        contacts = initDatabase();
        //Создаем адаптер
        adapter = new MyAdapter(contacts);
        //и устанавливаем его
        recyclerView.setAdapter(adapter);
    }

    //Метод создающий меню приложения
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Получаем menuInflater, компонент который загружает меню из xml файла.
        MenuInflater inflater = getMenuInflater();
        //Загружаем меню из xml файла
        inflater.inflate(R.menu.menu, menu);
        //Возвращаем значение true, которое уведомляет систему андроид создать меню для приложения
        return true;
    }

    //Метот обрабатывающий клики на пункты меню.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Извлекаем ID пункта меню и ищем подходящий case.
        switch (item.getItemId()) {
            case R.id.exit:
                finish();
                return true;
            case R.id.setting:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.addNewContact:
                Intent intent2 = new Intent(this, AddContactActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Contact> initDatabase() {
        contacts.add(new Contact("Ваня", "Волошин","+77771324567", "vanya@example.com"));
        contacts.add(new Contact("Петя", "Иванов", "+77771324568", "petya@example.com"));
        contacts.add(new Contact("Маша", "Савченко", "+77771324569", "masha@example.com"));
        contacts.add(new Contact("Катя", "Петрова","+77771324567", "katya@example.com"));
        contacts.add(new Contact("Алёна", "Васильева", "+77771324568", "alyona@example.com"));
        contacts.add(new Contact("Настя", "Смирнова", "+77771324569", "nastya@example.com"));
        contacts.add(new Contact("Вадя", "Кузнецов","+77771324567", "vadya@example.com"));
        contacts.add(new Contact("Николай", "Новиков", "+77771324568", "nikolai@example.com"));
        contacts.add(new Contact("Женя", "Зайцев", "+77771324569", "zhenya@example.com"));
        contacts.add(new Contact("Витя", "Белов","+77771324567", "vitya@example.com"));
        contacts.add(new Contact("Максим", "Ковалев", "+77771324568", "maxim@example.com"));
        contacts.add(new Contact("Анна", "Лебедева", "+77771324569", "anna@example.com"));
        return contacts;
    }
}
