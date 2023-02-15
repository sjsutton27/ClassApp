package com.example.classdemo3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classdemo3.ui.ChessDetailFragment

class ChessAdapter (private val chess: List<Chess>) :
    RecyclerView.Adapter<ChessAdapter.ChessViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChessViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chess_card_view, parent, false)
        return ChessViewHolder(view) { position ->
            val chess = chess[position]

            val bundle = bundleOf(
                "name" to chess.name,
                "age" to chess.age,
                "image" to chess.image,
                "universe" to chess.universe,
                "chessPiece" to chess.chessPiece,
                "chessColor" to chess.chessColor,
                "chessValue" to chess.chessValue
            )

            val detailFragment = ChessDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = chess.size

    override fun onBindViewHolder(holder: ChessViewHolder, position: Int) {
        val chess = chess[position]
        Glide
            .with(holder.itemView.context)
            .load(chess.image)
            .into(holder.chessImage)

        holder.chessName.text = chess.name
        holder.chessAge.text = chess.age.toString()
        holder.chessPiece.text = chess.chessPiece
        holder.chessColor.text = chess.chessColor
        holder.chessValue.text = chess.chessValue.toString()
    }

        inner class ChessViewHolder(
            itemView: View,
            private val onItemClick: (adapterPosition: Int) -> Unit
        ) : RecyclerView.ViewHolder(itemView) {
            val chessImage: ImageView = itemView.findViewById(R.id.chess_image)
            val chessName: TextView = itemView.findViewById(R.id.chess_name)
            val chessAge: TextView = itemView.findViewById(R.id.chess_age)
            val chessPiece: TextView = itemView.findViewById(R.id.chess_piece)
            val chessColor: TextView = itemView.findViewById(R.id.chess_color)
            val chessValue: TextView = itemView.findViewById(R.id.chess_value)
            init {
                itemView.setOnClickListener {
                    onItemClick(adapterPosition)
                }
            }

    }
}