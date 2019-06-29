package com.jclemus.notes.ui.list.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import butterknife.BindView
import butterknife.ButterKnife
import com.jclemus.notes.R

class NotesFragment : Fragment() {

    companion object {
        fun newInstance() = NotesFragment()
    }

    private lateinit var viewModel: NotesViewModel

    @BindView(R.id.tvNotesCounter)
    protected lateinit var tvNotesCounter: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.notes_fragment, container, false)
        ButterKnife.bind(this, rootView)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        viewModel.setUp()
        viewModel.notesLiveData.observe(this, Observer {
            val notesString = StringBuilder()
            it.forEachIndexed { index, note ->
                notesString.append("$index - Title: ${note.title}\n")
            }
            tvNotesCounter.text = "Total notes: ${it.size}\n${notesString}"
        })
    }

}
