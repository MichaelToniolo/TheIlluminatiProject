package home.mensagens;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivityFav extends Activity {

    ListView lsvFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fav);

        /*
        BancoFavControle crud = new BancoFavControle(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] Frase = new String[] {dbfrasesopenhelper.ID,dbfrasesopenhelper.FAV_FRASE};
        int[] idViews = new int[] {R.id.txtTexto};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_main_fav,cursor,Frase,idViews,0);
        lsvFavoritos = (ListView)findViewById(R.id.lsvFavoritos);
        lsvFavoritos.setAdapter(adaptador);
*/


        //lsvFavoritos = (ListView) findViewById(R.id.lsvFavoritos);

        //MetodoFavotitos();

        //Intent intent = getIntent();
        //Bundle bundle = intent.getExtras();
        //String texto = bundle.getString("txt");


    }

    //region Favoritos
    /*
    public void MetodoFavotitos()
    {
        String temp = "";
        String[] monthsArray = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY",
                "AUG", "SEPT", "OCT", "NOV", "DEC" };

        try
        {
            InputStream a ;
            a = openFileInput("bancoFavs");
            InputStreamReader ab = new InputStreamReader(a, "UTF-8");
            int c;
            while( (c = ab.read()) != -1){
                temp += Character.toString((char)c);
            }

            ArrayList<String> listItems=new ArrayList<String>();
            ArrayAdapter<String> adapter;

            adapter=new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    listItems);
            listItems.add(temp);
            //adapter.notifyDataSetChanged();
            lsvFavoritos.setAdapter(adapter);

            //ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp);
            //lsvFavoritos.setAdapter(arrayAdapter);

        }
        catch(Exception e)
        {

        }


    }
    */
    //endregion

}
