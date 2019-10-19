# EmojiLib-support
A EmojiLib for show emoji in android program which library version is "support".


![GIF](show.gif)


## How to use it 

It's very easy to use.

in xml layout

    <com.cwb.libemoji.ui.FaceLayout
          android:id="@+id/face_layout"
          android:layout_width="match_parent"
          android:layout_height="200dp" />

in class

    face_layout.setOnFaceClickListener(object : OnFaceClickListener {

        override fun onClick(bean: FaceBean) {
            val text = "... ${bean.content}"
            FaceCenter.handlerFaceText(tv_face, text, 30f)
        }

        override fun onDelete() {
            FaceCenter.deleteFace(tv_face, 30f)
        }

    })
  
## Add EmojiLib-support to your project.

[![](https://jitpack.io/v/codwb/EmojiLib-support.svg)](https://jitpack.io/#codwb/EmojiLib-support)

    allprojects {
      repositories {
        
        maven { url 'https://jitpack.io' }
      }
    }

	implementation 'com.github.codwb:EmojiLib-support:Tag'