package com.example.graduationproject.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationproject.BR
import com.example.graduationproject.R
import com.example.graduationproject.databinding.TopDestinationsRecyclerItemBinding
import com.example.graduationproject.model.general.GeneralModel
import com.squareup.picasso.Picasso

class TopAdapter(
    private val list:  List<GeneralModel>,
    private val onItemClickHandler: (GeneralModel: GeneralModel) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.top_destinations_recycler_item,parent,false
        )
        return TravelViewHolder(travelBinding)
    }

    class TravelViewHolder(
        private val travelBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(travelBinding.root) {
        private val image by lazy { itemView.findViewById<ImageView>(R.id.tab_layout_all_img_2)}
        fun onBind(generalModel: GeneralModel, onItemClickHandler: (GeneralModel: GeneralModel) -> Unit){
            val binding = travelBinding as TopDestinationsRecyclerItemBinding
            binding.setVariable(BR.travelModel, generalModel)
            Picasso.get().load(generalModel.images[0].url).into(image)
            binding.allCardView2.setOnClickListener {onItemClickHandler(generalModel)}
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TravelViewHolder).onBind(list[position],onItemClickHandler)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}