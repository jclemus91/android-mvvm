package com.jclemus.notes.repository.impl

import com.jclemus.notes.model.Note
import com.jclemus.notes.repository.NotesRepository

//Esto deberia ser un singleton, lo puse aqui nomás para que nos demos una idea
// singleton o inyeccion con kodein como prefieras pero debe ser una instancia
// aqui pones las peticiones a retrofit
val notesRepository = NotesRepositoryImpl()

class NotesRepositoryImpl : NotesRepository {

    private val fakeDB = arrayListOf<Note>()

    override fun addNote(note: Note) {
        fakeDB.add(note)
    }

    override fun getNotes(): List<Note> = fakeDB
}