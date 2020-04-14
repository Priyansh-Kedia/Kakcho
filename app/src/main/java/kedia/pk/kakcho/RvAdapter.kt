package kedia.pk.kakcho

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RvAdapter(val items:List<String>,val context:Context) : RecyclerView.Adapter<Viewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(LayoutInflater.from(context).inflate(R.layout.card_view,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        Glide.with(context).load(items.get(position).toString()).into(holder?.tvimg)
    }


}

class Viewholder(view:View) : RecyclerView.ViewHolder(view) {
    val tvimg:ImageView = view.findViewById(R.id.image)
}
