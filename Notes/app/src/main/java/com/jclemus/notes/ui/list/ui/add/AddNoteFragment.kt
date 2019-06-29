package com.jclemus.notes.ui.list.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.jclemus.notes.R

class AddNoteFragment : Fragment() {

    companion object {
        fun newInstance() = AddNoteFragment()
    }

    private lateinit var viewModel: AddNoteViewModel

    @BindView(R.id.etTitle)
    protected lateinit var etTitle: EditText
    @BindView(R.id.etMessage)
    protected lateinit var etMessage: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.add_note_fragment, container, false)
        ButterKnife.bind(this, rootView)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddNoteViewModel::class.java)
    }

    @OnClick(R.id.save)
    fun onSaveClick() {
        viewModel.saveNote(etTitle.text.toString(), etMessage.text.toString())
    }
}
