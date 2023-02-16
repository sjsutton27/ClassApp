package com.example.classdemo3.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.classdemo3.R

class ChessDetailFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chess_detail, container, false)

        if (arguments != null) {
            val name = requireArguments().getString("name")
            val age = requireArguments().getInt("age")
            val image = requireArguments().getString("image")
            val universe = requireArguments().getString("universe")
            val chessPiece = requireArguments().getString("chessPiece")
            val chessColor = requireArguments().getString("chessColor")
            val chessValue = requireArguments().getInt("chessValue")

            view.findViewById<TextView>(R.id.chess_universe).text = universe
            view.findViewById<TextView>(R.id.chess_piece).text = chessPiece
            view.findViewById<TextView>(R.id.chess_value).text = chessValue.toString()
            view.findViewById<TextView>(R.id.chess_color).text = chessColor


        }

        return view
    }
}
