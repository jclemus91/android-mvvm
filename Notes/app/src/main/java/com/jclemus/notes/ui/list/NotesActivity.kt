package com.jclemus.notes.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.jclemus.notes.R
import com.jclemus.notes.ui.list.ui.add.AddNoteFragment
import com.jclemus.notes.ui.list.ui.notes.NotesFragment
import kotlinx.android.synthetic.main.notes_activity.*

class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes_activity)
        setSupportActionBar(toolbar)
        ButterKnife.bind(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NotesFragment.newInstance())
                .commitNow()
        }
    }

    @OnClick(R.id.fab)
    fun onFabClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AddNoteFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

}
