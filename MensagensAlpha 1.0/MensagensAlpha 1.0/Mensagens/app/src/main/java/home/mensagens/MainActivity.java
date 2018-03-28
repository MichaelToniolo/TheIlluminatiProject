package home.mensagens;

//import android.content.Context;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.Toast;
//import android.widget.ListView;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
//Import Bancos
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    //Cria Classe Banco


    //region Main
    Button btnProximo;
    Button btnVoltar;
    TextView txtTexto;
    Button btnCompartilhar;
    Button btnFavorito;



    //region Array Frases
    private ArrayList<String> lista = new ArrayList<String>();

    String fd1 = "Seja positivo. Coisas boas vão acontecer.";
    String fd2 = "Tudo o que você decidir fazer, certifique-se se isso te fará feliz.";
    String fd3 = "Não confie em palavras, confie em ações.";
    String fd4 = "Não lute por atenção de alguém. Se eles realmente se importam, irão perceber as suas ações.";
    String fd5 = "Aqueles que não conseguem entender como colocar seus pensamentos no gelo não deve entrar no calor do debate.";
    String fd6 = "Duas regras para o sucesso: 1- Nunca revele tudo o que sabe.";
    String fd7 = "Bom ou mau, apenas sorria. Você tem muito a agradecer.";
    String fd8 = "Cada dia é uma oportunidade para começar de novo.";
    String fd9 = "Fique perto do que te faz feliz.";
    String fd10 = "Siga a luz, a Verdade, o conhecimento e seja iluminado";
    String fd11 = "Há sempre espaço para ser uma pessoa melhor. Sempre.";
    String fd12 = "Pare, Pense, Reflita.";
    String fd13 = "Seja positivo. Coisas boas vão acontecer.";
    String fd14 = "Não deixe que seu dia-a-dia seja comum, transforme-o em algo grandioso.";
    String fd15 = "É bom sonhar, mas é melhor sonhar e trabalhar. A fé é poderosa, mas a ação com fé é mais poderosa ainda.";
    String fd16 = "Os dias nascem de acordo com aquilo que plantamos, por isso selecione as melhores sementes para hoje.";
    String fd17 = "O segredo da felicidade está na simplicidade de ver a vida acontecer na alegria do outro.";
    String fd18 = "Muitas vezes passamos horas, dias tentando decifrar os mistérios da vida, e de repente descobrimos que somos nós mesmos o próprio mistério.";
    String fd19 = "teste1";
    String fd20 = "teste2";
    String fd21 = "teste3";
    String fd22 = "teste4";
    String fd23 = "final.......................";

    String frasesP[] = {fd1, fd2, fd3, fd4, fd5, fd6, fd7, fd8, fd9, fd10, fd11, fd12, fd13, fd14, fd15, fd16, fd17, fd18, fd19, fd20, fd21, fd22, fd23};

    int count = -1;

    //endregion

    //region onCreate Declaração dos objetos
    private static final String insert = "insert into fav_frases values" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTexto = (TextView)  this.findViewById(R.id.txtTexto);


        btnProximo = (Button) findViewById(R.id.btnProximo);
        btnProximo.setOnClickListener(MainActivity.this);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(MainActivity.this);

        txtTexto = (TextView) findViewById(R.id.txtTexto);

        btnCompartilhar = (Button) findViewById(R.id.btnCompartilhar);
        btnCompartilhar.setOnClickListener(MainActivity.this);

        btnFavorito = (Button) findViewById(R.id.btnFavorito);
        btnFavorito.setOnClickListener(MainActivity.this);


        //region click longo no favoritos
        btnFavorito = (Button) findViewById(R.id.btnFavorito);
        btnFavorito.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                switch (v.getId())
                {
                    case R.id.btnFavorito:



                        //region favoritos em txt
                        /*try {
                            //FileInputStream fin = openFileInput("bancoFavs", "UTF-8");

                            InputStream a ;//= new FileInputStream(getFileStreamPath("bancoFavs"));
                            a = openFileInput("bancoFavs");
                            InputStreamReader ab = new InputStreamReader(a, "UTF-8");
                            int c;
                            String temp="";
                            while( (c = ab.read()) != -1){
                                temp = temp + Character.toString((char)c);
                            }
                            Toast.makeText(getBaseContext(),temp,Toast.LENGTH_SHORT).show();


                        }
                        catch(Exception e){
                        }
                        */
                        //endregion


                        Intent telaFav = new Intent(MainActivity.this, ActivityTeste.class);
                        startActivity(telaFav);

                }
                return true;
            }
        });
        //endregion


        MarlonRandom();
    }
    //endregion

    //region Click View Botões
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnProximo:
                if (count >= -1) {
                    count++;

                    if (count == 23) {
                        count = 0;
                    }
                    txtTexto.setText(count + " - " + frasesP[count]);
                } else {
                    count = 0;
                }
                break;

            case R.id.btnVoltar:
                if (count >= 0) {
                    count--;

                    if (count == -1) {
                        count = 0;
                    } else {
                        txtTexto.setText(count + " - " + frasesP[count]);
                    }
                    txtTexto.setText(count + " - " + frasesP[count]);
                } else {
                    count = 0;
                }
                break;

            case R.id.btnCompartilhar:
                shareText();
                break;

            case R.id.btnFavorito:
                frasesFav();
                break;
        }

    }
    //endregion

    //region Testando o Metodo Favoritos
    public void frasesFav() {
        AlertDialog.Builder MensagemFav = new AlertDialog.Builder(this);
        MensagemFav.setTitle("Notificação");
        MensagemFav.setIcon(R.drawable.starcircle);
        MensagemFav.setMessage("Adicionar aos Favoritos").setCancelable(false).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                //Inserindo itens na lista
                BancoFavControle crud = new BancoFavControle(getBaseContext());
                TextView txtTexto = (TextView)findViewById(R.id.txtTexto);
                String frasefavorita = txtTexto.getText().toString();
                String Resultado;


                Resultado = crud.inserefrasefav(frasefavorita);

                Toast.makeText(getApplicationContext(), Resultado, Toast.LENGTH_LONG).show();

                //region  Script inutilizado
                /*if (count >= 0) {



                    String msgFav = new String(frasesP[count]);
                    msgFav.toString();

                //region favoritos para arquivos

                    /*
                    try
                    {

                        //fim script de adição ao banco



                        Filename favoritos Txt
                        String filename = "bancoFavs";
                        String string = frasesP[count];
                        FileOutputStream outputStream;
                        outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                        outputStream.write(string.getBytes("UTF-8"));
                        outputStream.close();
                        Toast.makeText(getBaseContext(), "Mensagem Salva!", Toast.LENGTH_SHORT).show();






                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //endregion



                } else {
                    int n = 2;
                }
            */
                //endregion

            }

        }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alertDialog = MensagemFav.create();
        alertDialog.show();
    }

    //endregion


    //region Metodo Random
    public void MarlonRandom() {
        String f1 = "Não perca tempo em vingança. As pessoas que você machucar acabará por enfrentar o seu próprio carma.";
        String f2 = "Não desperdice seu tempo com pessoas que não apreciam você.";
        String f3 = "Fique perto do que te faz feliz.";
        String f4 = "Um dia, você vai ser apenas uma memória para algumas pessoas. Faça o seu melhor para ser uma boa.";
        String f5 = "As pessoas vêm e vão, mas a vida é simplesmente sobre ver quem se importa o suficiente para ficar.";
        String f6 = "Nunca se esqueça da pessoa que estava ao seu lado quando todo mundo se esqueceu de você.";
        String f7 = "O problema com o mundo é que as pessoas inteligentes estão cheios de dúvidas enquanto os estúpidos estão cheios de confiança.";
        String f8 = "Siga a luz, Verdade, conhecimento e a Iluminação";
        String f9 = "Grandes coisas levam tempo.";
        String f10 = "Nossa vida não mudará se nós não mudarmos isso.";
        String f11 = "Se você quer isto, persiga e busca.";
        String f12 = "Aprenda a deixar ir, nem todo mundo em sua vida é pra ficar.";
        String f13 = "Fé.";
        String f14 = "O que você pensa sobre você, é muito mais importante do que o que os outros pensam de você.";
        String f15 = "Às vezes é preciso perder tudo o que você pensou que precisava, para ganhar tudo o que você sempre quis.";
        String f16 = "Há sempre espaço para ser uma pessoa melhor. Sempre.";
        String f17 = "Pare de se preocupar sobre o que pode dar errado, fique animado sobre o que pode dar certo.";
        String f18 = "Seja destemido quando se trata de vida, e descuidados quando se trata de o que as pessoas dizem e pensam sobre você.";
        String f19 = "Às vezes você se encontra no meio do nada, e às vezes no meio do nada, você se encontra";
        String f20 = "Pare, Pense, Reflita (PPR).";
        String f21 = "Às vezes você espera mais de alguém, porque você faria muito isso para eles.";
        String f22 = "Nunca deixe alguém que é infeliz destruir sua felicidade.";
        String f23 = ".......................";

        Random rnd1 = new Random();
        int f = rnd1.nextInt(23);
        //String textofrases[] = {f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23};
        txtTexto.setText(frasesP[f]);
    }
    //endregion

    //region Metodo recebe conteudo da textview para compartilhar
    private void shareText() {
        // cria a intent e define a ação
        Intent intent = new Intent(Intent.ACTION_SEND);
        // tipo de conteúdo da intent
        intent.setType("text/plain");
        // string a ser enviada para outra intent
        intent.putExtra(Intent.EXTRA_TEXT, txtTexto.getText());
        // inicia a intent
        startActivity(intent);
    }
    //endregion

    //region Menus na ActionBar (compartilhamento)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem shareItem = menu.findItem(R.id.compartilhar);

        android.widget.ShareActionProvider share = (android.widget.ShareActionProvider) shareItem.getActionProvider();

        share.setShareIntent(getDefaultIntent());

        return true;
    }

    private Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "COMPARTILHANDO TELA DE CADASTRO");

        return intent;
    }
    //endregion

}
