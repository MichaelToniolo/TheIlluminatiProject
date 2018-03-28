package home.mensagens;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
/**
 * Created by michael on 28/02/17.
 */

public class BancoFavControle
{
    //region Controla Dados Add
    private SQLiteDatabase db;
    private dbfrasesopenhelper banco;

    public BancoFavControle (Context context)
    {
        banco = new dbfrasesopenhelper(context);

    }
    public String inserefrasefav(String frases)
    {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(dbfrasesopenhelper.FAV_FRASE, frases);
        resultado = db.insert(dbfrasesopenhelper.TABELA, null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao Adicionar Frase";
        else
            return "Frase adicionada aos Favoritos.";


    }
    //endregion

    //regin carrega dados para a listview
    public Cursor carregaDados()
    {
        Cursor cursor;
        String[] campos =  {banco.ID,banco.FAV_FRASE};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}

