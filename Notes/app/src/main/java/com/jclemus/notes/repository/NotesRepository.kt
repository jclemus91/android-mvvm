package com.jclemus.notes.repository

import com.jclemus.notes.model.Note

interface NotesRepository {
    fun addNote(note: Note)
    fun getNotes(): List<Note>
}