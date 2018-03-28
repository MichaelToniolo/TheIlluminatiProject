package home.mensagens;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.text.StaticLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by michael on 28/02/17.
 */

public class dbfrasesopenhelper extends SQLiteOpenHelper
{



    public static final String NOME_BANCO = "favoritos.db";
    public static final String TABELA = "frases";
    public static final String ID = "_id";
    public  static final String FAV_FRASE = "frasefav";

    private static final int VERSAO = 1;

    public dbfrasesopenhelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {/*

        String sql = "CREATE TABLE" + "INTEGER PRIMARY KEY AUTOINCREMENT," + FAV_FRASE + "text";
        String sql = "CREATE TABLE" + TABELA + "("+ID + "integer primary key autoincrement," + FAV_FRASE + "text)";
        */

        String sql = "CREATE TABLE " + dbfrasesopenhelper.TABELA  + "("
                + dbfrasesopenhelper.ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + dbfrasesopenhelper.FAV_FRASE + " TEXT )";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);

    }

    public List<BDFrasesTeste> selectFrase()
    {
        List<BDFrasesTeste> ListaFrase = new ArrayList<BDFrasesTeste>();

        SQLiteDatabase db = getReadableDatabase();

        String sqlSelectFrase = "SELECT * FROM frases";

        Cursor c = db.rawQuery(sqlSelectFrase, null);
        if (c.moveToFirst())
        {
            do {


                BDFrasesTeste frase = new BDFrasesTeste();
                frase.setId(c.getInt(0));
                frase.setFrase(c.getString(1));

                ListaFrase.add(frase);
            }while (c.moveToFirst());
            db.close();

        }
        return ListaFrase;
    }
}
