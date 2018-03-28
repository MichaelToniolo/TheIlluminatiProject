package home.mensagens;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ActivityTeste extends Activity {

    ListView lsvTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teste);

        lsvTeste = (ListView) findViewById(R.id.lsvteste);



    }
}
