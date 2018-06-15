package com.example.mirella.trabalho_dev_apps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_cad_book.view.*

class CadBookFragment : Fragment() {

    fun selectImageInAlbum() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_SELECT_IMAGE_IN_ALBUM)
    }

    lateinit var comunicador: Comunicador
    lateinit var book: Book

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    companion object {
        private val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_cad_book, container, false)
        val list = listOf("Imagem 1","Imagem 2","Imagem 3","Imagem 4","Imagem 5")
        rootView.imageBookSpinner.adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, list)
        var imageSelect = 0
        rootView.imageBookSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == -1) return

                parent?.let {
                    imageSelect = when (parent.getItemAtPosition(position).toString()) {
                        list[0] -> R.drawable.capa_toda_poesia
                        list[1] -> R.drawable.culpa_e_das_estrelas
                        list[2] -> R.drawable.enigma_do_principe
                        list[3] -> R.drawable.o_pequeno_principe
                        list[4] -> R.drawable.prisioneiro_de_azkaban
                        else -> R.drawable.prisioneiro_de_azkaban
                    }
                }
            }
        }

        var title = rootView.titleWrapper.editText!!.text.toString()
        var description = rootView.descriptionWrapper.editText!!.text.toString()
        rootView.save_button.setOnClickListener {
            book = Book(title, description, imageSelect)
            comunicador.responde(book)
        }

        return rootView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        comunicador = activity as Comunicador
    }
}
