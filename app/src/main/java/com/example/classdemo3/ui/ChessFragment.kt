package com.example.classdemo3.ui


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classdemo3.Chess
import com.example.classdemo3.ChessAdapter
import com.example.classdemo3.R
import kotlin.random.Random

class ChessFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chess, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.chess_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val chess = mutableListOf<Chess>()
        val chessPiece = mutableListOf("Pawn","Rook","Knight","Bishop","King","Queen")
        val chessColor = mutableListOf("White","Black")
        val chessValue = mutableListOf(1,2,3,4,5,6,7)
        val genders = mutableListOf("Male", "Female", "Pickle", "Squanch", "01010")
        val characterLocations = mutableListOf(
            "Earth",
            "Citadel of Ricks",
            "Interdimensional Cable",
            "Random Dimension"
        )
        val nameMods = mutableListOf("Pickle", "", "Smart", "Fused", "Big Arm")
        val characterNames = mutableListOf("Rick", "Morty", "Summer", "Jerry", "Beth")

        for (i in 0..30) {
            chess.add(
                createChess(
                    "${nameMods.random()} ${characterNames.random()}".trimStart(),
                    characterLocations.random(),
                    genders.random(),
                    i,
                    chessPiece.random(),
                    chessColor.random(),
                    chessValue.random(),
                )
            )
        }

        val adapter = ChessAdapter(chess)
        recyclerView.adapter = adapter

        return view
    }

    private fun createChess(
        name: String,
        location: String,
        gender: String,
        id: Int,
        chessPiece: String,
        chessColor: String,
        chessValue: Int,
    ) = Chess(
        name = name,
        age = Random.nextInt(10, 99),
        image = "https://en.wikipedia.org/wiki/Pawn_%28chess%29#/media/File:Chess_piece_-_White_pawn.JPG",
        gender = gender,
        universe = location,
        id = id,
        relation = listOf(),
        chessPiece = chessPiece,
        chessColor = chessColor,
        chessValue = chessValue
    )



}