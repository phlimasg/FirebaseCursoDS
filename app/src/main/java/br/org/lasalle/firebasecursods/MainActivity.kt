package br.org.lasalle.firebasecursods

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView
import br.org.lasalle.firebasecursods.storage.StorageDownloadActivity
import br.org.lasalle.firebasecursods.util.Permissao
import java.util.jar.Manifest

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var cardView_Storage_Download: CardView
    private lateinit var cardView_Storage_Upload: CardView
    private lateinit var cardView_Database_LerDados: CardView
    private lateinit var cardView_Database_GravarAlterarExcluir: CardView
    private lateinit var cardView_Empresa: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissoes()

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
    //permissao dos usuarios

    private fun permissoes(){

        val permissoes = arrayOf(
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.INTERNET,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )

        Permissao.permissao(this,  0, permissoes)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for (result in grantResults){
            if(result == PackageManager.PERMISSION_DENIED){
                Toast.makeText(this, "Aceite todas as permissoes", Toast.LENGTH_LONG).show()
                Log.w("PERMISSOES", "Grand" + grantResults + "Rsult: " + result)
                finish()
                break
            }
        }
    }




    //Tratamento dos click do CardView
    override fun onClick(v: View?) {
        if(v?.getId() == R.id.cardView_Storage_Download){
            val intent: Intent = Intent(baseContext,StorageDownloadActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "cardView_Storage_Download", Toast.LENGTH_LONG).show()
        }
        if(v?.getId() == R.id.cardView_Storage_Upload){
            Toast.makeText(this, "cardView_Storage_Upload", Toast.LENGTH_LONG).show()
        }
        if(v?.getId() == R.id.cardView_Database_LerDados){
            Toast.makeText(this, "cardView_Database_LerDados", Toast.LENGTH_LONG).show()
        }
        if(v?.getId() == R.id.cardView_Database_Gravar_Alterar_Excluir){
            Toast.makeText(this, "cardView_Database_Gravar_Alterar_Excluir", Toast.LENGTH_LONG).show()
        }
        if(v?.getId() == R.id.cardView_Empresas){
            Toast.makeText(this, "cardView_Empresas", Toast.LENGTH_LONG).show()
        }
    }
}