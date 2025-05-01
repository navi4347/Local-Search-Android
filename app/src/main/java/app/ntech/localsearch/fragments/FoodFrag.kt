package app.ntech.localsearch.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.ntech.localsearch.R
import app.ntech.localsearch.adapter.DetailpageAdapter
import app.ntech.localsearch.databinding.FoodrfragBinding
import app.ntech.localsearch.roomDb.RoomDb

class FoodFrag : Fragment() {

    lateinit var mbinding : FoodrfragBinding
    var categorytype : String? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mbinding = DataBindingUtil.inflate(inflater, R.layout.foodrfrag, container, false)
        var userDao = RoomDb.getAppDatabase(requireActivity())?.userDao()
        categorytype = "Food"
        var userdata= categorytype?.let { userDao?.filtercategory(it) }
        Log.d("chan","Filter Category Data : "+userdata?.size)
        if(userdata?.size!! > 0) {
            mbinding.txtnodatafound.visibility = View.GONE
            mbinding.rvfoodlist.visibility = View.VISIBLE

            val adapter = DetailpageAdapter(requireActivity(),userdata,"Food")
            mbinding.rvfoodlist.setAdapter(adapter)
            var manager = LinearLayoutManager(requireActivity())
            mbinding.rvfoodlist.layoutManager = manager as RecyclerView.LayoutManager?
            mbinding.rvfoodlist.adapter
            mbinding.rvfoodlist.setHasFixedSize(true)
        }else{
            mbinding.txtnodatafound.visibility = View.VISIBLE
            mbinding.rvfoodlist.visibility = View.GONE
//            Toast.makeText(requireActivity(),"No Data Found", Toast.LENGTH_SHORT).show()
        }

        return mbinding.root
    }
}