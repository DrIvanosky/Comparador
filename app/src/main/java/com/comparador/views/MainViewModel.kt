package com.comparador.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.comparador.model.Comparador

class MainViewModel:ViewModel() {

    val comparador: LiveData<Comparador> get() = _comparador
    private var _comparador = MutableLiveData(Comparador("Seran o no Seran?"))

    fun comparar(texto1: String? , texto2: String? ){
        lateinit var  esIgual:String

        if (texto1==texto2){
            esIgual = "Son Iguales"
        }
        else {
            esIgual = "Son Distintas"
        }

        _comparador.value = Comparador(esIgual)
    }
}