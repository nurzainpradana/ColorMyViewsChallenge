package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import org.w3c.dom.Text

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    lateinit var box_three_text: TextView
//    lateinit var box_four_text: TextView
//    lateinit var box_five_text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    /**
     * Attaches listeners to all the views.
     */
    private fun setListeners() {


        val clickableViews: List<View> =
            listOf(
                box_one_text,
                box_two_text,
                box_three_text,
                box_four_text,
                box_five_text,
                constraint_layout,
                red_button,
                green_button,
                yellow_button
            )

        for (item in clickableViews) {
            item.setOnClickListener { makeColored2(it) }
        }
    }

    /**
     * Sets the background color of a view depending on it's resource id.
     * This is a way of using one click handler to do similar operations on a
     * group of views.
     */

    public fun makeColored(view: View) {
        when (view) {

            // Boxes using Color class colors for background
            box_one_text-> view.setBackgroundColor(Color.DKGRAY)
            box_two_text -> view.setBackgroundColor(Color.GRAY)

            box_three_text -> view.setBackgroundColor(Color.BLUE)
            box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            box_five_text -> view.setBackgroundColor(Color.BLUE)

            // Boxes using custom colors for background
            red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            green_button -> box_five_text.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun makeColored2(view: View) {
//        //Save every id of combo box and text box to a map
        val checkBoxView: Map<CheckBox, TextView> =
            mapOf(
                cb_one to box_one_text,
                cb_two to box_two_text,
                cb_three to box_three_text,
                cb_four to box_four_text,
                cb_five to box_five_text
            )
//
//        if(cb_one.isChecked){
//            when (view.id) {
//                // Boxes using custom colors for background
//                R.id.red_button -> box_one_text.setBackgroundResource(R.color.my_red)
//                R.id.yellow_button -> box_two_text.setBackgroundResource(R.color.my_yellow)
//                R.id.green_button -> box_three_text.setBackgroundResource(R.color.my_green)
//            }
//        }
        //Loop every single item in map
        for ((checkItem, boxItem) in checkBoxView) {
            if (checkItem.isChecked) {
                when (view) {
                    // Boxes using custom colors for background
                    red_button -> boxItem.setBackgroundResource(R.color.my_red)
                    yellow_button -> boxItem.setBackgroundResource(R.color.my_yellow)
                    green_button -> boxItem.setBackgroundResource(R.color.my_green)
                }
            }
        }

    }
}
