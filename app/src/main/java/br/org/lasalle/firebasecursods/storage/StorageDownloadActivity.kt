package br.org.lasalle.firebasecursods.storage

import android.graphics.Bitmap
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import br.org.lasalle.firebasecursods.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class StorageDownloadActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var imageView: ImageView
    lateinit var progressBar: ProgressBar
    lateinit var button_Remover: Button
    lateinit var button_Download: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.storage_download_activity)

        imageView = findViewById(R.id.imageView_Download)
        progressBar = findViewById(R.id.progressBar_Storage_Download)
        button_Remover = findViewById(R.id.button_Storage_Remove)
        button_Download = findViewById(R.id.button_Storage_Download)

        button_Remover.setOnClickListener(this)
        button_Download.setOnClickListener(this)

        progressBar.isVisible = false
    }

    override fun onClick(v: View?) {

        if(v?.getId() == R.id.button_Storage_Download){
            progressBar.isVisible = true
            download_imagem_1()
            Toast.makeText(this, "STORAGE DOWNLOADs CLICADO", Toast.LENGTH_LONG).show()
        }

        if(v?.getId() == R.id.button_Storage_Remove){
            Toast.makeText(this, "STORAGE REMOVE CLICADO", Toast.LENGTH_LONG).show()
        }

    }

    private fun download_imagem_1() {
        val url = "https://firebasestorage.googleapis.com/v0/b/udemy-3f6d1.appspot.com/o/image%2Fpc.png?alt=media&token=ebfef659-4a8c-4972-8b3a-0adbbb305b05"
        /*Picasso.get().load(url).into(imageView, object : Callback {
            override fun onSuccess() {
                progressBar.isVisible = false
                Toast.makeText(getBaseContext(), "Carregou a imagem", Toast.LENGTH_LONG).show()
            }

            override fun onError(e: Exception?) {
                Toast.makeText(getBaseContext(), "Deu ruim: " + e?.message, Toast.LENGTH_LONG).show()
            }
        })

         */

        Glide.
        with(getBaseContext()).
        asBitmap().
        load(url).
        listener(object :
            RequestListener<Bitmap> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Bitmap>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

            override fun onResourceReady(
                resource: Bitmap?,
                model: Any?,
                target: Target<Bitmap>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.isVisible = false
                return false
            }

        }).into(imageView)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_storage_download, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.getItemId() == R.id.item_criar_pdf){
            Toast.makeText(this, "PDF ITEM CLICADO", Toast.LENGTH_LONG).show()
        }
        if(item.getItemId() == R.id.item_compartilhar){
            Toast.makeText(this, "COMPARTILHAR ITEM CLICADO", Toast.LENGTH_LONG).show()
        }


        return super.onOptionsItemSelected(item)
    }
}