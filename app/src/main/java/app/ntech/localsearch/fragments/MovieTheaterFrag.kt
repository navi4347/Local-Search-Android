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
import app.ntech.localsearch.databinding.MovietheaterfragBinding
import app.ntech.localsearch.roomDb.RoomDb

class MovieTheaterFrag : Fragment(){
    lateinit var mbinding : MovietheaterfragBinding
    var categorytype : String? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mbinding = DataBindingUtil.inflate(inflater, R.layout.movietheaterfrag, container, false)
        var userDao = RoomDb.getAppDatabase(requireActivity())?.userDao()
        categorytype = "Movies"
        var userdata= categorytype?.let { userDao?.filtercategory(it) }
        Log.d("chan","Filter Category Data : "+userdata?.size)
        if(userdata?.size!! > 0) {
            mbinding.txtnodatafound.visibility = View.GONE
            mbinding.rvmovielist.visibility = View.VISIBLE

            val adapter = DetailpageAdapter(requireActivity(),userdata, categorytype!!)
            mbinding.rvmovielist.setAdapter(adapter)
            var manager = LinearLayoutManager(requireActivity())
            mbinding.rvmovielist.layoutManager = manager as RecyclerView.LayoutManager?
            mbinding.rvmovielist.adapter
            mbinding.rvmovielist.setHasFixedSize(true)
        }else{
            mbinding.txtnodatafound.visibility = View.VISIBLE
            mbinding.rvmovielist.visibility = View.GONE
            Toast.makeText(requireActivity(),"No Data Found", Toast.LENGTH_SHORT).show()
        }

        return mbinding.root
    }
}