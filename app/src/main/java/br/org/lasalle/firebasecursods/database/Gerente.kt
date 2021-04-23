package br.org.lasalle.firebasecursods.database

import java.math.BigInteger

class Gerente {
    private lateinit var nome: String
    private var idade: Int = 0
    private var fumante: Boolean = false

    public fun Gerente(){

    }

    public fun Gerente(nome : String, idade: Int, fumante: Boolean) {
        this.nome = nome
        this.idade = idade
        this.fumante = fumante
    }

    fun getNome(): String {
        return this.nome
    }

    fun getIdade(): Int {
        return this.idade

    }


}