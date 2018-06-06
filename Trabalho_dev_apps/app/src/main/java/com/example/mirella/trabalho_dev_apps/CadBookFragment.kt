package com.example.mirella.trabalho_dev_apps

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CadBookFragment : Fragment() {

    fun selectImageInAlbum() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_SELECT_IMAGE_IN_ALBUM)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    companion object {
        private val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cad_book, container, false)
    }

}
