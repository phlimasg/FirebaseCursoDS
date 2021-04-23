package br.org.lasalle.firebasecursods.database

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.org.lasalle.firebasecursods.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue


class DatabaseLerDadosActivity : AppCompatActivity() {

    lateinit var textView_Nome: TextView
    lateinit var textView_Idade: TextView
    lateinit var textView_Fumante: TextView

    lateinit var textView_Nome_2: TextView
    lateinit var textView_Idade_2: TextView
    lateinit var textView_Fumante_2: TextView

    lateinit var fd: FirebaseDatabase
    lateinit var valueEventListener: ValueEventListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.database_ler_dados_activity)

        textView_Nome = findViewById(R.id.textView_Database_Lerdados_Nome)
        textView_Idade = findViewById(R.id.textView_Database_Lerdados_Idade)
        textView_Fumante = findViewById(R.id.textView_Database_Lerdados_Fumante)

        textView_Nome_2 = findViewById(R.id.textView_Database_Lerdados_Nome_2)
        textView_Idade_2 = findViewById(R.id.textView_Database_Lerdados_Idade_2)
        textView_Fumante_2 = findViewById(R.id.textView_Database_Lerdados_Fumante_2)

        fd = FirebaseDatabase.getInstance()
        ouvinte_1()
    }

    fun ouvinte_1(){
        val reference : DatabaseReference = fd.getReference().child("BD").child("Gerentes")
        reference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val gerentes = ArrayList<Gerente>()

                for (data in dataSnapshot.getChildren()) {
                    val gerente = data.getValue<Gerente>()
                    if (gerente != null) {
                        gerentes.add(gerente)
                        Log.i("FireBase", "Adicionou!!! Valor do FB: ${gerente.getNome()}")
                    }
                    //val gerente: Gerente = data.getValue() as Gerente
                    //gerentes.add(gerente)
                }
                //textView_Nome.setText(gerentes?.get(0)?.getNome())
                //textView_Idade.setText(gerentes?.get(0)?.getIdade().toString())

                /*textView_Nome.setText(gerente?.getNome())
                textView_Idade.setText(gerente?.getIdade().toString())*/


                /*var nomes = arrayListOf<String>()
                var idades = arrayListOf<Int>()
                var fumantes = arrayListOf<Boolean>()

                for (data in snapshot.children){
                    var nome : String = data.child("nome").getValue().toString()
                    var idade : Int = data.child("idade").getValue().toString().toInt()
                    var fumante : Boolean = data.child("fumante").getValue() as Boolean

                    nomes.add(nome)
                    idades.add(idade)
                    fumantes.add(fumante)

                }
                textView_Nome.setText(nomes.get(0))
                textView_Nome_2.setText(nomes.get(1))
                textView_Idade.setText(idades.get(0).toString())
                textView_Idade_2.setText(idades.get(1).toString())
                if(fumantes.get(0) == true)
                    textView_Fumante.setText("Verdadeiro")
                else
                    textView_Fumante.setText("Falso")
                if(fumantes.get(1) == true)
                    textView_Fumante_2.setText("Verdadeiro")
                else
                    textView_Fumante_2.setText("Falso")


            /*var nome : String = snapshot.child("nome").getValue().toString()
                var fumante : Boolean = snapshot.child("fumante").getValue() as Boolean
                val idade : Int = snapshot.child("idade").getValue().toString().toInt()

                val dialogAlerta : DialogAlerta = DialogAlerta("Valor", nome +"\n"+ idade +"\n"+ fumante)
                dialogAlerta.show(getSupportFragmentManager(),"1")

                 */

                 */
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(getBaseContext(), "ERROOOO", Toast.LENGTH_LONG).show()
            }

        })
    }
}