package com.example.demoemoji

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.EditText
import com.cwb.libemoji.FaceCenter
import com.cwb.libemoji.bean.FaceBean
import com.cwb.libemoji.callback.OnFaceClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //使用fragment
        /*
         val beginTransaction = supportFragmentManager.beginTransaction()
          beginTransaction.replace(
              R.id.frame,
              FaceFragment.getInstance(object : OnFaceClickListener {
                  override fun onClick(bean: FaceBean) {
                      Toast.makeText(baseContext, "content: ${bean.content}", Toast.LENGTH_SHORT)
                          .show()
                  }

                  override fun onDelete() {
                  }

              })
          )
          beginTransaction.commit()

         */

        //使用FaceLayout
        face_layout.setOnFaceClickListener(object : OnFaceClickListener {

            @SuppressLint("SetTextI18n")
            override fun onClick(bean: FaceBean) {
                val text = "${tv_face.text}${bean.content}"
                FaceCenter.showFace(tv_face, text, 30f)
                FaceCenter.showFace(edit_input, text, 30f)
            }

            override fun onDelete() {
                FaceCenter.deleteFace(tv_face, 30f)
                FaceCenter.deleteFace(edit_input, 30f)
            }

        })

        edit_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s == null) return
                val text = s.toString()
                //FaceCenter.showFace(tv_face, text, 30f)
                tv_face.text = text
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

        edit_input.setOnKeyListener { v, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                FaceCenter.deleteFace(v as EditText, 30f)
                true
            } else
                false
        }

    }
}
