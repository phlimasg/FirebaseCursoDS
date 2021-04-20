package br.org.lasalle.firebasecursods.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast

class util {

    public fun statusInternet(context: Context): Boolean {

        val conexao : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val informacao: NetworkInfo = conexao.getActiveNetworkInfo()

        if(informacao != null && informacao.isConnected()){
            return true
        }
        return false
    }


    public fun statusInternet(context: Context, texto_1: String, texto_2: String): Boolean {
        if(!texto_1.isEmpty() && !texto_2.isEmpty()){
            if(statusInternet(context)){
                return true
            }else{
                Toast.makeText(context, "Você está sem internet", Toast.LENGTH_LONG)
                return false
            }
        }
        else{
            Toast.makeText(context, "Preeencha os campos", Toast.LENGTH_LONG)
            return false
        }
    }
}