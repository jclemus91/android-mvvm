package com.jclemus.notes.ui.list.ui.add

import androidx.lifecycle.ViewModel
import com.jclemus.notes.model.Note
import com.jclemus.notes.repository.impl.NotesRepositoryImpl
import com.jclemus.notes.repository.impl.notesRepository

class AddNoteViewModel : ViewModel() {
    fun saveNote(title: String, message: String) {
        notesRepository.addNote(Note(title, message))
    }
}
