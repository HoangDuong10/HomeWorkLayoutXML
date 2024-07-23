package com.example.homeworklayoutxml.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworklayoutxml.databinding.ItemCustomerInformationBinding
import com.example.homeworklayoutxml.model.User
import java.time.LocalTime
import kotlin.random.Random

class CustomerInformationAdapter(private val listData : List<User>) :
    RecyclerView.Adapter<CustomerInformationAdapter.CustomerInformationViewHolder>() {
    inner class CustomerInformationViewHolder(private val binding : ItemCustomerInformationBinding) : RecyclerView.ViewHolder(binding.root){
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(user : User){
            binding.ivAvata.setImageDrawable(ContextCompat.getDrawable(binding.ivAvata.context,user.imgAvata))
            binding.tvName.text = user.name
            binding.tvTitle1.text = "${user.title[0]} ${getRandomTime()}"
            binding.tvTitle2.text = "${user.title[1]} ${getRandomTime()}"
            binding.tvTitle3.text = "${user.title[2]} ${getRandomTime()}"
            binding.ivPrint1.setOnClickListener {
                if(binding.ivCheck1.visibility == View.VISIBLE){
                    binding.ivCheck1.visibility = View.GONE
                }else{
                    binding.ivCheck1.visibility = View.VISIBLE
                }
            }

            binding.ivPrint2.setOnClickListener {
                if(binding.ivCheck2.visibility == View.VISIBLE){
                    binding.ivCheck2.visibility = View.GONE
                }else{
                    binding.ivCheck2.visibility = View.VISIBLE
                }
            }

            binding.ivPrint3.setOnClickListener {
                if(binding.ivCheck3.visibility == View.VISIBLE){
                    binding.ivCheck3.visibility = View.GONE
                }else{
                    binding.ivCheck3.visibility = View.VISIBLE
                }
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomerInformationViewHolder {
        val binding = ItemCustomerInformationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomerInformationViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CustomerInformationViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getRandomTime(): LocalTime {
        val randomHour = Random.nextInt(0, 24)
        val randomMinute = Random.nextInt(0, 60)
        return LocalTime.of(randomHour, randomMinute)
    }
}