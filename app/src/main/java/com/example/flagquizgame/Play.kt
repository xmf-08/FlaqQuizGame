package com.example.flagquizgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.children
import com.example.flagquizgame.MyData.getArray
import kotlinx.android.synthetic.main.activity_play.*
import kotlinx.android.synthetic.main.activity_starter.*
import java.util.*
import kotlin.collections.ArrayList

class Play : AppCompatActivity(), View.OnClickListener {
    lateinit var flagArrayList: ArrayList<Flag>
    var count = 0
    var countryName = ""
    lateinit var buttonArrayList: ArrayList<Button>
    lateinit var flag:Flag
    lateinit var linerMatn: LinearLayout
    lateinit var linerBtn1: LinearLayout
    lateinit var linerBtn2: LinearLayout
    lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val i = intent.getIntExtra("cals", 0)
        flagArrayList = MyData.getArray(i)
        buttonArrayList = ArrayList()

        idea.setOnClickListener{
            val a =  flagArrayList[count].name?.toUpperCase()

            val start = a!!.subSequence(0,1)
            val end = a.subSequence(a.length-1,a.length)

            Toast.makeText(this, "Start:$start\n" +
                    "End:$end", Toast.LENGTH_SHORT).show()
        }
        linerMatn = findViewById(R.id.lin_1_matn)
        linerBtn1 = findViewById(R.id.lin_2_btn_1)
        linerBtn2 = findViewById(R.id.lin_3_btn_2)
        image = findViewById(R.id.image_1)

        btnJoylaCount()


    }



    fun btnJoylaCount() {
        image.setImageResource(flagArrayList[count].image!!)
        linerMatn.removeAllViews()
        linerBtn1.removeAllViews()
        linerBtn2.removeAllViews()
        countryName = ""
        btnJoyla(flagArrayList[count].name)
    }

    private fun btnJoyla(countryName: String?) {
        val btnArray: ArrayList<Button> = randomBtn(countryName)
        for (i in 0..5) {
            linerBtn1.addView(btnArray[i])
        }
        for (i in 6..11) {
            linerBtn2.addView(btnArray[i])
        }
    }

    private fun randomBtn(countryName: String?): ArrayList<Button> {
        val array = ArrayList<Button>()
        val arrayText = ArrayList<String>()

        for (c in countryName!!) {
            arrayText.add(c.toString())
        }
        if (arrayText.size != 12) {
            val str = "ABCDEFGHIJKLMNOPQRSTUVXYZ"
            for (i in arrayText.size until 12) {
                val random = Random().nextInt(str.length)
                arrayText.add(str[random].toString())
            }
        }
        arrayText.shuffle()

        for (i in 0 until arrayText.size) {
            val button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f
            )
            button.text = arrayText[i]
            button.setOnClickListener(this)
            array.add(button)
        }
        return array
    }

    override fun onClick(v: View?) {
        val button1 = v as Button
        if (buttonArrayList.contains(button1)) {
            linerMatn.removeView(button1)
            var hasC = false
            linerBtn1.children.forEach { button ->
                if ((button as Button).text.toString() == button1.text.toString()) {
                    button.visibility = View.VISIBLE
                    countryName = countryName.substring(0, countryName.length - 1)
                    hasC = true
                }
            }
            linerBtn2.children.forEach { button ->
                if ((button as Button).text.toString() == button1.text.toString()) {
                    button.visibility = View.VISIBLE
                    if (!hasC) {
                        countryName = countryName.substring(0, countryName.length - 1)
                    }
                }
            }

        }else{
            button1.visibility = View.INVISIBLE
            countryName += button1.text.toString().toUpperCase()
            val button2 = Button(this)
            button2.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f)
            button2.text = button1.text
            button2.setOnClickListener(this)
            buttonArrayList.add(button2)
            linerMatn.addView(button2)
            matnTogri()
        }
    }

    private fun matnTogri() {
        if (countryName == flagArrayList[count].name?.toUpperCase()){
            Toast.makeText(this, "true", Toast.LENGTH_SHORT).show()
            if (count == flagArrayList.size-1){
                count=0
            }else{
                count++
            }
            btnJoylaCount()
        }else{
            if (countryName.length == flagArrayList[count].name?.length){
                Toast.makeText(this, "False try again", Toast.LENGTH_SHORT).show()
                linerMatn.removeAllViews()
                linerBtn2.removeAllViews()
                linerBtn1.removeAllViews()
                btnJoyla(flagArrayList[count].name)
                countryName = ""
            }
        }
    }
}
