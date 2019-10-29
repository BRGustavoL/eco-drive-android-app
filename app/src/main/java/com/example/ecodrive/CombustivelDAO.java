package com.example.ecodrive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CombustivelDAO extends SQLiteOpenHelper {

    public CombustivelDAO( Context context) {
        //  super(context, name, factory, version);
        super(context, "Combustivel", null, 1);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        String sql = "CREATE TABLE Contatos (id INTEGER PRIMARY KEY, " +
                "nome TEXT NOT NULL, telefone TEXT, email TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Contatos";
        db.execSQL(sql);
        onCreate(db);
    }
    // private final static List<Contato> contatos = new ArrayList<>();

    public void salvar(Contato contato){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("nome", contato.getNome());
        dados.put("telefone", contato.getTelefone());
        dados.put("email", contato.getEmail());
        db.insert("Contatos", null, dados );
    }
    public List<Contato> todosContatos(){
        String sql = "SELECT * FROM Contatos;";
        SQLiteDatabase db =  getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Contato> contatos = new ArrayList<Contato>();
        while (c.moveToNext()) {
            Contato contato = new Contato();
            contato.setId(c.getLong(c.getColumnIndex("id")));
            contato.setNome(c.getString(c.getColumnIndex("nome")));
            contato.setTelefone(c.getString(c.getColumnIndex("telefone")));
            contato.setEmail(c.getString(c.getColumnIndex("email")));
            contatos.add(contato);
        }
        c.close();
        return contatos;

    }
//    public void deleta(Contato contato){
//        SQLiteDatabase db = getWritableDatabase();
//
//        String [] params = {String.valueOf(contato.getId())};
//        db.delete("Contatos", "id = ?", params);
//    }

    public void altera(Combustivel_Class combustivel_class){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("Valor Combustivel: ", combustivel_class.getValorCombustivel());
        dados.put("Valor Abastecido: ", combustivel_class.getValorAbastecido());
        dados.put("Quilometragem Atual: ", combustivel_class.getKmAtual());

        String[] params ={combustivel_class.getId().toString()};
        db.update("Abastecida", dados, "Id = ?", params);
    }


}
