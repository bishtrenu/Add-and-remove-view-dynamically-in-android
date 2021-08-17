package com.example.addremoveviewsdynamically

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    var mainview:LinearLayout?=null
    var btnAddNote:Button?=null
    var btnPrint:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainview=findViewById(R.id.addNotesMainLayout)
        btnAddNote=findViewById(R.id.btn_add_notes)
        btnPrint=findViewById(R.id.btn_printValue)
        btnPrint?.setOnClickListener {
            printValue()
        }
        btnAddNote?.setOnClickListener {
            addNote()
        }
        addNote()

    }

    fun addNote()
    {
        val noteView=layoutInflater.inflate(R.layout.notes_layout,null, false)

        var removeBtn=noteView.findViewById<ImageView>(R.id.btn_Remove)
        if(mainview?.childCount==0)
            removeBtn.visibility=View.GONE
        removeBtn.setOnClickListener {
            removeView(noteView)
        }

        mainview?.addView(noteView)

    }

    private fun removeView(noteView: View?) {

        mainview?.removeView(noteView)

    }

    fun printValue()
    {
        var count=(mainview?.childCount?:1)-1
            for( i in 0..count)
            {
                var childView=mainview?.getChildAt(i)
                var title=childView?.findViewById<TextView>(R.id.txt_key)
                var description=childView?.findViewById<TextView>(R.id.txt_value)
                Toast.makeText(this, "${title?.text} -> ${ description?.text}", Toast.LENGTH_SHORT).show()

            }
    }
}