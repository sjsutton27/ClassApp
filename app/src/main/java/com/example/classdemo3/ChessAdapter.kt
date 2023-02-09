package com.example.classdemo3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChessAdapter (private val chess: List<Chess>) : RecyclerView.Adapter<ChessAdapter.ChessViewHolder>(){

    class ChessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val chessImage: ImageView = itemView.findViewById(R.id.chess_image)
        val chessName: TextView = itemView.findViewById(R.id.chess_name)
        val chessAge: TextView = itemView.findViewById(R.id.chess_age)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChessViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chess_card_view, parent, false)
        return ChessViewHolder(view)
    }

    override fun getItemCount() = chess.size

    override fun onBindViewHolder(holder: ChessViewHolder, position: Int) {
        val chess = chess[position]
        holder.chessImage.setImageResource(chess.image)
        holder.chessName.text = chess.name
        holder.chessAge.text = chess.age.toString()
    }
}