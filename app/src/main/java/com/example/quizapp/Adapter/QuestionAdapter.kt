package com.example.quizapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.databinding.ViewholderQuestionBinding

class QuestionAdapter(val correctAnswer:String,
                      val users:MutableList<String> = mutableListOf(),
                      var returnScore:score

): RecyclerView.Adapter<QuestionAdapter.Viewholder>() {
    interface score {
        fun amount(number: Int, clickedAnswer: String)
    }

    private lateinit var binding: ViewholderQuestionBinding

    inner class Viewholder : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):QuestionAdapter.Viewholder{
        val inflater= LayoutInflater.from(parent.context)
        binding=ViewholderQuestionBinding.inflate(inflater, parent, false)
        return Viewholder()
    }

    override fun onBindViewHolder(holder: QuestionAdapter.Viewholder, position: Int) {
        val binding=ViewholderQuestionBinding.bind(holder.itemView)
        binding.answerTxt.text=differ.currentList[position]
        var currPos=0
        when(correctAnswer){
            "a"->{
                currPos=0
            }
            "b"->{
                currPos=1
            }
            "c"->{
                currPos=2
            }
            "d"->{
                currPos=3
            }
        }
        if(differ.currentList.size==5 && currPos==position){
            binding.answerTxt.setBackgroundResource(R.drawable.green_bg)
            val drawable= ContextCompat.getDrawable(binding.root.context, R.drawable.tick)
            binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
        }
        if(differ.currentList.size==5){
            var clickedPos=0
            when(differ.currentList[4]){
                "a"->{
                    clickedPos=0
                }
                "b"->{
                    clickedPos=1
                }
                "c"->{
                    clickedPos=2
                }
                "d"->{
                    clickedPos=3
                }
            }
            if(clickedPos==position && clickedPos!=currPos){
                binding.answerTxt.setBackgroundResource(R.drawable.red_bg)
                val drawable= ContextCompat.getDrawable(binding.root.context, R.drawable.thieves)
                binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
            }
        }
        if(position==4){
            binding.root.visibility= View.GONE
        }
        holder.itemView.setOnClickListener{
            var str = ""
            when(position){
                0->{
                    str="a"
                }
                1->{
                    str="b"
                }
                2->{
                    str="c"
                }
                3->{
                    str="d"
                }
            }
            users.add(4,str)
            notifyDataSetChanged()
            if(currPos==position){
                binding.answerTxt.setBackgroundResource(R.drawable.green_bg)
                val drawable= ContextCompat.getDrawable(binding.root.context, R.drawable.tick)
                binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
                returnScore.amount(5,str)
            }else{
                binding.answerTxt.setBackgroundResource(R.drawable.red_bg)
                val drawable= ContextCompat.getDrawable(binding.root.context, R.drawable.thieves)
                binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
                returnScore.amount(0,str)
            }
        }
        if(differ.currentList.size==5) holder.itemView.setOnClickListener(null)
    }

    override fun getItemCount()=differ.currentList.size

    private val differCallback=object: DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
           return oldItem==newItem
        }
    }

    val differ=AsyncListDiffer(this,differCallback)
}