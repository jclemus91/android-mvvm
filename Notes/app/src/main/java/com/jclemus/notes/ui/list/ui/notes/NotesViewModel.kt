package com.jclemus.notes.ui.list.ui.notes

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jclemus.notes.model.Note
import com.jclemus.notes.repository.impl.notesRepository

class NotesViewModel : ViewModel() {

    val notesLiveData = MutableLiveData<List<Note>>()

    fun setUp() {
        // HACER ALGO AQUI COMO PONER A DESCARGAR DATOS O INICIALIZAR VARIABLES, LO QUE QUIERAS
        Handler().postDelayed({
            notesLiveData.value = notesRepository.getNotes()
        }, 3000)
    }

}
