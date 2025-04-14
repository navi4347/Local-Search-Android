package app.ntech.localsearch.adapter

import android.app.Activity
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.ntech.localsearch.HomepageData
import app.ntech.localsearch.R
import com.bumptech.glide.Glide

class CategoryListAdapter(var catlist : HomepageData, var activity: Activity, private val oncatItemClick: CategoryItemClick) : RecyclerView.Adapter<CategoryListAdapter.viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val inflater = LayoutInflater.from(parent.context)
        return viewholder(inflater,parent)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var resources: Resources = activity.resources
//        var resourceId : Int = resources.getIdentifier(catlist.categorylist.get(position).icon, "drawable", activity.packageName);
        var resourceId : Int = resources.getIdentifier(catlist.categorylist.get(position).icon, "drawable", activity.packageName);

        holder.catName?.setText(catlist.categorylist.get(position).name)
        Glide.with(activity).load(resourceId).placeholder(R.drawable.logo).into(holder.image!!)
//        holder.image?.setImageResource(resourceId)
        holder.image?.setOnClickListener {
            oncatItemClick.onItemClick(catlist.categorylist.get(position).name)
            Log.d("chan","bloodtype : " +catlist.categorylist.get(position).name)

        }
    }

    override fun getItemCount(): Int {
        return catlist.categorylist.size
    }

    class viewholder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.categoryadapter, parent, false)) {
        var image : ImageView?=null
        var catName : TextView?=null
        init {
            image = itemView.findViewById(R.id.bl_image)
            catName = itemView.findViewById(R.id.tvcatename)
        }
    }
    interface CategoryItemClick{

        fun onItemClick(categorytype : String)

    }
}