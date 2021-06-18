package com.app5.dict

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val words = listOf(
        Word("Apple ", " /ˈæp.əl/ \n" +
                "a round fruit with firm, white flesh and a green, red, or yellow skin:\n" +
                "to peel an apple\n" +
                "apple pie/sauce\n" +
                "an apple tree\n","apple_vid",R.raw.apple,R.drawable.apple),
        Word("University  ","/ˌjuː.nəˈvɝː.sə.t̬i/ s \n" +
                "a place where people study for an undergraduate (= first) or postgraduate (= higher level) degree:\n" +
                "Which university did you go to/were you at (= did you study at)?\n" +
                "She teaches at the University of Connecticut.\n" +
                "I graduated from Liverpool University in 2012.\n" +
                "a university campus/degree/professor" ,"university_vid",R.raw.university,R.drawable.university),
        Word("United","description"),
        Word("Unsatistafactory","description"),
        Word("Under","description"),
        Word("Understandable","description")

    )
    private lateinit var adapter: WordsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("DEBUG",words.toString())
        adapter = WordsAdapter(words,this){
            val intent = Intent(this@MainActivity,DetailActivity::class.java)
            intent.putExtra(PARCELABLE_DETAIL_WORD,it)
            startActivity(intent)
        }

        dict_recycler_view.let {
            it.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            it.adapter = adapter
        }


    }
    companion object{
        const val PARCELABLE_DETAIL_WORD = "PARCELABLE_DETAIL_WORD"
    }
}