package com.example.quizapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.quizapp.Adapter.LeaderAdapter
import com.example.quizapp.Domain.UserMode
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityLeaderBinding

class LeaderActivity : AppCompatActivity() {
    lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        binding.apply {
            scoreTxt1.text=loadData().get(0).score.toString()
            scoreTxt2.text=loadData().get(1).score.toString()
            scoreTxt3.text=loadData().get(2).score.toString()
            titleTop1Txt.text=loadData().get(0).name
            titleTop2Txt.text=loadData().get(1).name
            titleTop3Txt.text=loadData().get(2).name

            val drawableResourceId1:Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic,"drawable",binding.root.context.packageName
            )
            val drawableResourceId2:Int = binding.root.resources.getIdentifier(
                loadData().get(1).pic,"drawable",binding.root.context.packageName
            )
            val drawableResourceId3:Int = binding.root.resources.getIdentifier(
                loadData().get(2).pic,"drawable",binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic1)

            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(pic2)

            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(pic3)

            bottomMenu.setItemSelected(R.id.Board)
            bottomMenu.setOnItemSelectedListener {
                if(it==R.id.home){
                    startActivity(Intent(this@LeaderActivity,MainActivity::class.java))
                }
            }
            var list:MutableList<UserMode> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)
            leaderView.apply {
                layoutManager=LinearLayoutManager(this@LeaderActivity)
                adapter=leaderAdapter
            }
        }

    }
    private fun loadData():MutableList<UserMode>{
        val users:MutableList<UserMode> = mutableListOf()
        users.add(UserMode(1,"Gourav","person1",4850))
        users.add(UserMode(2,"Nandini","person2",4560))
        users.add(UserMode(3,"Manya","person3",3873))
        users.add(UserMode(4,"Mansha", "person4",3250))
        users.add(UserMode(5,"Muskan","person5",3015))
        users.add(UserMode(6,"Quinzy","person6", 2978))
        users.add(UserMode(7,"Dupinder","person7",2870))
        users.add(UserMode(8,"Mantav","person8",2670))
        users.add(UserMode(9,"Kanika","person9",2380))
        users.add(UserMode(10,"Simran","person10",2380))
        return users
    }
}