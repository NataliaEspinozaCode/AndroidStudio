package com.example.arraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listalibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminSQL  admin = new adminSQL(this,"libreria", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();

        Cursor fila =bd.rawQuery("select isbn_libro from libros",null);
        if(!fila.moveToFirst()){

            ContentValues registro1 = new ContentValues();
            ContentValues registro2 = new ContentValues();
            ContentValues registro3 = new ContentValues();
            ContentValues registro4 = new ContentValues();
            ContentValues registro9 = new ContentValues();
            ContentValues registro10 = new ContentValues();
            ContentValues registro11 = new ContentValues();
            ContentValues registro12 = new ContentValues();

            registro1.put("isbn_libro", 1);
            registro1.put("nombre_libro", "El gran Gatsby");
            registro1.put("autor", "F. Scott Fitzgerald");
            registro1.put("editorial", "Anagrama");
            registro1.put("tipo", "Novela Clásica");
            registro1.put("encuadernacion", " Tapa blanda");
            registro1.put("precio", 150);

            registro2.put("isbn_libro", 2);
            registro2.put("nombre_libro", " El retrato de Dorian Gray");
            registro2.put("autor", "Oscar Wilde");
            registro2.put("editorial", "El Ateneo");
            registro2.put("tipo", "Novela Clásica");
            registro2.put("encuadernacion", " Tapa blanda");
            registro2.put("precio", 40);

            registro3.put("isbn_libro", 3);
            registro3.put("nombre_libro", "Orgullo y Prejuicio");
            registro3.put("autor", "Jane Austen");
            registro3.put("editorial", " Alma");
            registro3.put("tipo", "Novela Rosa");
            registro3.put("encuadernacion", " Tapa Dura");
            registro3.put("precio", 100);

            registro4.put("isbn_libro", 4);
            registro4.put("nombre_libro", " Llamame por tu nombre");
            registro4.put("autor", "André Aciman");
            registro4.put("editorial", "Alfaguara");
            registro4.put("tipo", "Novela Clásica");
            registro4.put("encuadernacion", " Tapa blanda");
            registro4.put("precio", 210);


            registro9.put("isbn_libro", 5);
            registro9.put("nombre_libro", " Harry Potter y la cámara secreta");
            registro9.put("autor", "J.K. Rowling");
            registro9.put("editorial", "Salamandra");
            registro9.put("tipo", "Infantil-Juvenil");
            registro9.put("encuadernacion", " Tapa dura");
            registro9.put("precio", 150);

            registro10.put("isbn_libro", 6);
            registro10.put("nombre_libro", " Harry Potter y el prisionero de Azkaban");
            registro10.put("autor", "J.K. Rowling");
            registro10.put("editorial", "Salamandra");
            registro10.put("tipo", "Infantil-Juvenil");
            registro10.put("encuadernacion", " Tapa dura");
            registro10.put("precio", 150);

            registro11.put("isbn_libro", 7);
            registro11.put("nombre_libro", " Harry Potter y el cáliz de fuego");
            registro11.put("autor", "J.K. Rowling");
            registro11.put("editorial", "Salamandra");
            registro11.put("tipo", "Infantil-Juvenil");
            registro11.put("encuadernacion", " Tapa dura");
            registro11.put("precio", 150);

            registro12.put("isbn_libro", 8);
            registro12.put("nombre_libro", "  Harry Potter y La Piedra Filosofal");
            registro12.put("autor", "J.K. Rowling");
            registro12.put("editorial", "Salamandra");
            registro12.put("tipo", "Infantil-Juvenil");
            registro12.put("encuadernacion", " Tapa blanda");
            registro12.put("precio", 80);

            SQLiteDatabase bdEscritura = admin.getWritableDatabase();
            bdEscritura.insert("libros", null, registro1);
            bdEscritura.insert("libros", null, registro2);
            bdEscritura.insert("libros", null, registro3);
            bdEscritura.insert("libros", null, registro4);
            bdEscritura.insert("libros", null, registro9);
            bdEscritura.insert("libros", null, registro10);
            bdEscritura.insert("libros", null, registro11);
            bdEscritura.insert("libros", null, registro12);

        }

        Cursor consulta =bd.rawQuery("select isbn_libro,nombre_libro from libros",null);
        listalibros = new ArrayList<String>();
        while (consulta.moveToNext()){

            //toda la informacion que seleccionamos se guarda en el arraylist(lista libros) mediante un while
            listalibros.add(consulta.getInt(0)+": "+consulta.getString(1));
        }

        consulta.close();

        bd.close();


    }

    public void Listalibros(){

        adminSQL  admin = new adminSQL(this,"libreria", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();

        Cursor consulta =bd.rawQuery("select isbn_libro,nombre_libro from libros",null);
        listalibros = new ArrayList<String>();
        while (consulta.moveToNext()){

            //toda la informacion que seleccionamos se guarda en el arraylist(lista libros) mediante un while
            listalibros.add(consulta.getInt(0)+": "+consulta.getString(1));
        }

        consulta.close();
        bd.close();

    }
}