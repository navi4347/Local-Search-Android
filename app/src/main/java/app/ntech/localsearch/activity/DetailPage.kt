package app.ntech.localsearch.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.ntech.localsearch.HomepageData
import app.ntech.localsearch.R
import app.ntech.localsearch.adapter.DetailpageAdapter
import app.ntech.localsearch.databinding.DetailsPageListBinding
import app.ntech.localsearch.roomDb.RoomDb
import app.ntech.localsearch.roomDb.UserEntity

class DetailPage :AppCompatActivity() {
    var categorytype : String? =null
    var sub_categoryvalue : String? =null
    var userdata : List<UserEntity>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categorytype = intent.extras?.getString("categorytype").toString()
        sub_categoryvalue = intent.extras?.getString("sub_cat_boeolean").toString()

        if(categorytype.equals("Agriculture")){
            theme.applyStyle(R.style.Agriculture, true)
        }else if(categorytype.equals("Food")){
            theme.applyStyle(R.style.Food, true)
        }else if(categorytype.equals("Jobs")){
            theme.applyStyle(R.style.Jobs, true)
        }else if(categorytype.equals("Vehicles")){
            theme.applyStyle(R.style.Vehicles, true)
        }else if(categorytype.equals("B2B")){
            theme.applyStyle(R.style.B2B, true)
        }else if(categorytype.equals("B2C")){
            theme.applyStyle(R.style.B2C, true)

        }else if(categorytype.equals("C2B")){
            theme.applyStyle(R.style.C2B, true)

        }else if(categorytype.equals("C2C")){
            theme.applyStyle(R.style.C2C, true)

        }else if(categorytype.equals("24/7")){
            theme.applyStyle(R.style.twentyfour, true)

        }else if(categorytype.equals("SPA")){
            theme.applyStyle(R.style.SPA, true)

        }else if(categorytype.equals("Consultant")){
            theme.applyStyle(R.style.Consultant, true)

        }else if(categorytype.equals("Consultant")){
            theme.applyStyle(R.style.Consultant, true)

        }else if(categorytype.equals("Covid")){
            theme.applyStyle(R.style.Covid, true)

        }else if(categorytype.equals("Doctors")){
            theme.applyStyle(R.style.Doctors, true)

        }else if(categorytype.equals("Education")){
            theme.applyStyle(R.style.Education, true)

        }else if(categorytype.equals("Fitness")){
            theme.applyStyle(R.style.Fitness, true)

        }else if(categorytype.equals("Drivers")){
            theme.applyStyle(R.style.Drivers, true)

        }else if(categorytype.equals("Services")){
            theme.applyStyle(R.style.Services, true)

        }else if(categorytype.equals("Movies")){
            theme.applyStyle(R.style.Movies, true)

        }else if(categorytype.equals("Oxygen")){
            theme.applyStyle(R.style.Oxygen, true)

        }else if(categorytype.equals("Real Estate")){
            theme.applyStyle(R.style.RealEstate, true)

        }else if(categorytype.equals("Rents")){
            theme.applyStyle(R.style.Rents, true)

        }else if(categorytype.equals("Repairs")){
            theme.applyStyle(R.style.Repairs, true)

        }else if(categorytype.equals("Travels")){
            theme.applyStyle(R.style.Travels, true)
        }
        var mbinding = DataBindingUtil.setContentView<DetailsPageListBinding>(this,
            R.layout.details_page_list
        )
        if(categorytype.toString().isNotEmpty()){
            mbinding.txtheadername.setText(categorytype+" Details")
        }
        if(categorytype.equals("Agriculture")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Agriculture))
        }else if(categorytype.equals("Food")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Food))
        }else if(categorytype.equals("Jobs")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Jobs))
        }else if(categorytype.equals("Vehicles")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Vehicles))
        }else if(categorytype.equals("B2B")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.B2B))
        }else if(categorytype.equals("B2C")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.B2C))
        }else if(categorytype.equals("C2B")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.C2B))
        }else if(categorytype.equals("C2C")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.C2C))
        }else if(categorytype.equals("24/7")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.twentyfour))

        }else if(categorytype.equals("SPA")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.SPA))

        }else if(categorytype.equals("Consultant")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Consultant))

        }else if(categorytype.equals("Consultant")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Consultant))

        }else if(categorytype.equals("Covid")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Covid))

        }else if(categorytype.equals("Doctors")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Doctor))

        }else if(categorytype.equals("Education")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Education))

        }else if(categorytype.equals("Fitness")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Fitness))

        }else if(categorytype.equals("Drivers")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Drivers))

        }else if(categorytype.equals("Services")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Services))

        }else if(categorytype.equals("Movies")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Movies))

        }else if(categorytype.equals("Oxygen")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Oxygen))

        }else if(categorytype.equals("Real Estate")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.RealEstate))

        }else if(categorytype.equals("Rents")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Rents))

        }else if(categorytype.equals("Repairs")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Repairs))

        }else if(categorytype.equals("Travels")){
            mbinding.mainappbar.setBackgroundColor(resources.getColor(R.color.Travels))
        }
        var userDao = RoomDb.getAppDatabase(this)?.userDao()
        Log.d("chan","category : "+categorytype)
        if(sub_categoryvalue.equals("true")){
            userdata= categorytype?.let { userDao?.filtersubcategory(it) }
            Log.d("chan","Filter Sub Category Data : "+userdata?.size)
        }else{
            userdata= categorytype?.let { userDao?.filtercategory(it) }
            Log.d("chan","Filter Category Data : "+userdata?.size)
        }
        if(userdata?.size!! > 0) {
            mbinding.txtnodatafound.visibility = View.GONE
            mbinding.detailslist.visibility = View.VISIBLE
            val adapter = DetailpageAdapter(this,userdata, categorytype!!)
            mbinding.detailslist.setAdapter(adapter)
            var manager = LinearLayoutManager(this)
            mbinding.detailslist.layoutManager = manager as RecyclerView.LayoutManager?
            mbinding.detailslist.adapter
            mbinding.detailslist.setHasFixedSize(true)
        }else{
            mbinding.txtnodatafound.visibility = View.VISIBLE
            mbinding.detailslist.visibility = View.GONE
//            Toast.makeText(this,"No Data Found",Toast.LENGTH_SHORT).show()
        }

        mbinding.imBack.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)

        }
    }
}