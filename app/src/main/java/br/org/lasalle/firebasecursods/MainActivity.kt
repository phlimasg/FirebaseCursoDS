package br.org.lasalle.firebasecursods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var cardView_Storage_Download: CardView
    private lateinit var cardView_Storage_Upload: CardView
    private lateinit var cardView_Database_LerDados: CardView
    private lateinit var cardView_Database_GravarAlterarExcluir: CardView
    private lateinit var cardView_Empresa: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardView_Storage_Download = findViewById<CardView>(R.id.cardView_Storage_Download)
        cardView_Storage_Upload = findViewById<CardView>(R.id.cardView_Storage_Upload)
        cardView_Database_LerDados = findViewById<CardView>(R.id.cardView_Database_LerDados)
        cardView_Database_GravarAlterarExcluir = findViewById<CardView>(R.id.cardView_Database_Gravar_Alterar_Excluir)
        cardView_Empresa = findViewById<CardView>(R.id.cardView_Empresas)

        cardView_Storage_Download.setOnClickListener(this)
        cardView_Storage_Upload.setOnClickListener(this)
        cardView_Database_LerDados.setOnClickListener(this)
        cardView_Database_GravarAlterarExcluir.setOnClickListener(this)
        cardView_Empresa.setOnClickListener(this)
    }
    //Tratamento dos click do CardView
    override fun onClick(v: View?) {
        if(v?.getId() == R.id.cardView_Storage_Download){

        }
        if(v?.getId() == R.id.cardView_Storage_Upload){

        }
        if(v?.getId() == R.id.cardView_Database_LerDados){

        }
        if(v?.getId() == R.id.cardView_Database_Gravar_Alterar_Excluir){

        }
        if(v?.getId() == R.id.cardView_Empresas){

        }
    }
}