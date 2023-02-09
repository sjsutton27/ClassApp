package com.example.classdemo3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.chess_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val chess = mutableListOf<Chess>()

        for (i in 0..30) {
            chess.add(createCharacters())
        }
        val adapter = ChessAdapter(chess)
        recyclerView.adapter = adapter
    }

    private fun createCharacters() = Chess(
        name= "Chess",
        age = 10,
        image = R.drawable.baseline_10k_24,
        pawn= "Pawn",
        pawnImage = R.drawable.pawn,
        rook = "Rook",
        rookImage = R.drawable.rook,
        bishop = "Bishop",
        bishopImage = R.drawable.bishop,
        knight = "Knight",
        knightImage = R.drawable.knight,
        queen = "Queen",
        queenImage = R.drawable.queen,
        king = "King",
        kingImage = R.drawable.king,
    )
}
