package app.ntech.localsearch.adapter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import app.ntech.localsearch.R
import app.ntech.localsearch.roomDb.UserEntity
import com.bumptech.glide.Glide

class DetailpageAdapter(var activity: Activity, val list: List<UserEntity>?, var type :String) : RecyclerView.Adapter<DetailpageAdapter.viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val inflater = LayoutInflater.from(parent.context)
        return viewholder(inflater,parent)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.txtname?.text = list?.get(position)?.Username
        holder.txtaddress?.text = list?.get(position)?.Address
        holder.txttimings?.text = list?.get(position)?.Timings
        if(type.equals("Agriculture")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Agriculture))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Agriculture))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Agriculture))
        }else if(type.equals("Food")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Food))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Food))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Food))
        }else if(type.equals("Jobs")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Jobs))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Jobs))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Jobs))
        }else if(type.equals("Vehicles")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Vehicles))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Vehicles))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Vehicles))
        }else if(type.equals("B2B")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.B2B))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.B2B))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.B2B))
        }else if(type.equals("B2C")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.B2C))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.B2C))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.B2C))
        }else if(type.equals("C2B")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.C2B))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.C2B))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.C2B))
        }else if(type.equals("C2C")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.C2C))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.C2C))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.C2C))
        }else if(type.equals("24/7")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.twentyfour))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.twentyfour))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.twentyfour))
        }else if(type.equals("SPA")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.SPA))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.SPA))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.SPA))
        }else if(type.equals("Consultant")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Consultant))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Consultant))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Consultant))
        }else if(type.equals("Contractor")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Contractor))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Contractor))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Contractor))
        }else if(type.equals("Covid")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Covid))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Covid))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Covid))
        }else if(type.equals("Doctors")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.C2B))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.C2B))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.C2B))
        }else if(type.equals("Education")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Education))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Education))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Education))
        }else if(type.equals("Fitness")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Fitness))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Fitness))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Fitness))
        }else if(type.equals("Drivers")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Drivers))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Drivers))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Drivers))
        }else if(type.equals("Services")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Services))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Services))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Services))
        }else if(type.equals("Movies")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Movies))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Movies))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Movies))
        }else if(type.equals("Oxygen")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Oxygen))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Oxygen))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Oxygen))
        }else if(type.equals("Real Estate")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.RealEstate))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.RealEstate))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.RealEstate))
        }else if(type.equals("Rents")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Rents))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Rents))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Rents))
        }else if(type.equals("Repairs")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Repairs))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Repairs))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Repairs))
        }else if(type.equals("Travels")){
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.Travels))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.Travels))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.Travels))
        }else{
            holder.phncall?.setCardBackgroundColor(activity.getColor(R.color.colorPrimary))
            holder.sharemsg?.setCardBackgroundColor(activity.getColor(R.color.colorPrimary))
            holder.locamap?.setCardBackgroundColor(activity.getColor(R.color.colorPrimary))
        }
        holder.imgbanner?.let {
            Glide.with(activity).load(list?.get(position)?.ImageUrl).placeholder(R.drawable.logo).into(it) }

        holder.phncall?.setOnClickListener {
            if(list?.get(position)?.Phone!!.isNotEmpty() && list?.get(position)?.Phone!!.length >= 10 ){
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:"+list?.get(position)?.Phone)
                activity.startActivity(intent)
            }else{
                Toast.makeText(activity,"Number not found",Toast.LENGTH_SHORT).show()
            }
        }
        holder.sharemsg?.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Name : "+list?.get(position)?.Username+", Address : "+list?.get(position)?.Address
                        +", Timings : "+list?.get(position)?.Timings+", Location : "+list?.get(position)?.GoogleMaps)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            activity.startActivity(shareIntent)
        }

        if (!list?.get(position)?.GoogleMaps.equals("null")) {
            holder.locamap?.visibility = View.VISIBLE
        } else {
            holder.locamap?.visibility = View.GONE
        }

        holder.locamap?.setOnClickListener {
            val locationUrl = list?.get(position)?.GoogleMaps

            if (!locationUrl.isNullOrEmpty() && locationUrl != "null") {
                val gmmIntentUri = Uri.parse(locationUrl)
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                activity.startActivity(mapIntent)
            } else {
                val toast = Toast.makeText(activity, "Location not available", Toast.LENGTH_LONG)
                toast.show()

                // Extend toast to 5 seconds manually
                android.os.Handler().postDelayed({ toast.cancel() }, 1000)
            }
        }


        if(!list?.get(position)?.Email.equals("")) {
            holder.txtemail?.setText("Email: " + list?.get(position)?.Email.toString())
        }else{
            holder.txtemail?.visibility = View.GONE
        }
         if(!list?.get(position)?.Website.equals("")) {
             holder.txtwebsite?.setText("Website: "+list?.get(position)?.Website.toString())
        }else{
             holder.txtwebsite?.visibility = View.GONE
         }

    }
    override fun getItemCount(): Int {
        return list!!.size
    }
    class viewholder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.singledetailspageitem, parent, false)) {
        var txtname : TextView?=null
        var txttimings : TextView?=null
        var imgbanner : ImageView?=null
        var txtaddress : TextView?=null
        var phncall : CardView? = null
        var sharemsg : CardView? = null
        var locamap : CardView?=null
        var txtemail : TextView?=null
        var txtwebsite : TextView?=null

        init {
            txtname = itemView.findViewById(R.id.txtname)
            txttimings = itemView.findViewById(R.id.txt_timings)
            imgbanner = itemView.findViewById(R.id.imbanner)
            txtaddress = itemView.findViewById(R.id.txt_address)
            phncall = itemView.findViewById(R.id.linphone)
            sharemsg = itemView.findViewById(R.id.linshare)
            locamap = itemView.findViewById(R.id.linlocation)
            txtemail = itemView.findViewById(R.id.txt_email)
            txtwebsite = itemView.findViewById(R.id.txt_website)
        }
    }
}

