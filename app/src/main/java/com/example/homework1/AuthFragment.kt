package com.example.homework1

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.homework1.databinding.AlertDialogBinding
import com.example.homework1.databinding.FragmentAuthBinding
import com.example.homework1.databinding.FragmentContactBinding



class AuthFragment : Fragment() {
    private lateinit var binding: FragmentAuthBinding
    private lateinit var sharedPref:SharedPreferences




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =FragmentAuthBinding.inflate(inflater,container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            registerButton.setOnClickListener {
                val direction = AuthFragmentDirections.actionAuthFragmentToMainProfileFragment("gdfgfgdgd")
               findNavController().navigate(direction)
            }
        }
    }

    class CustomButton(context: Context, attrs: AttributeSet): AppCompatButton(context,attrs){
        val paint = Paint()
        init{
            paint.style= Paint.Style.FILL
            paint.color = Color.WHITE


        }
        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            val width =  MeasureSpec.getSize(widthMeasureSpec)
            val height = MeasureSpec.getSize(heightMeasureSpec)

            super.setMeasuredDimension(width,height)

        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            canvas.drawRect(5.2f,5.2f,5.2f,5.2f,paint)

        }






    }


}




