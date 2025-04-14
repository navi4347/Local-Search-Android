package app.ntech.localsearch.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.ntech.localsearch.CommonUtils
import app.ntech.localsearch.HomepageData
import app.ntech.localsearch.R
import app.ntech.localsearch.activity.DetailPage
import app.ntech.localsearch.adapter.CategoryListAdapter
import app.ntech.localsearch.databinding.HomepagefragmentBinding
import app.ntech.localsearch.roomDb.RoomDb
import app.ntech.localsearch.roomDb.UserEntity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomePageFrag : Fragment() , CategoryListAdapter.CategoryItemClick{
    lateinit var mbinding : HomepagefragmentBinding
    lateinit var alllist : MutableLiveData<List<UserEntity>>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mbinding = DataBindingUtil.inflate(inflater, R.layout.homepagefragment, container, false)
        alllist = MutableLiveData<List<UserEntity>>()

        deletedata()
        try {
            var dataList : HomepageData =
                CommonUtils.getMenuJsonForAssociate(requireActivity(), "categorylist.json")
            if(dataList.categorylist.isNotEmpty()){
                val adapter = CategoryListAdapter(dataList,requireActivity(),this)
                mbinding.rvcategorylist.setAdapter(adapter)
                var manager = GridLayoutManager(requireActivity(),4)
                mbinding.rvcategorylist.layoutManager = manager
                mbinding.rvcategorylist.adapter
                mbinding.rvcategorylist.setHasFixedSize(true)
            }else{

            }

        } catch (e: Exception) {
            Log.d("chan","exception : "+e.toString())
            // handle your exception here
        }
        mbinding.lincarpenter.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Carpenter")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linelectrician.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Electrician")
            intent.putExtra("sub_cat_boeolean", "true")
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linpainter.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Painter")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linplumber.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Plumber")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linrentacar.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Rent a Car")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.lincarwash.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Car Wash")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linnewcar.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "New Car")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linsaleacar.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Sale a Car")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linbuy.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Buy")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linrent.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Rent")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linhotel.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Hotel")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linpg.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "PG")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.lingym.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Gym")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linsports.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Sports")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linswimming.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Swimming")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }
        mbinding.linyoga.setOnClickListener {
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("categorytype", "Yoga")
            intent.putExtra("sub_cat_boeolean", "true")

            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
        }

        return mbinding.root
    }

    private fun getdataFromFireBase() {
        deletedata()
        var database = FirebaseDatabase.getInstance()
        var usersReference = database.getReference("Users")
        usersReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (npsnapshot in dataSnapshot.children) {
                        val donorDetailsModelNew =
                            npsnapshot.getValue(UserEntity::class.java)
                        if (donorDetailsModelNew != null) {
                            Log.d("chan","Firebase Data : "+donorDetailsModelNew)
                            insertDataToDb(donorDetailsModelNew)
                        }
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }
    private fun getallDatafromDb() {
        var userDao = RoomDb.getAppDatabase(requireActivity())?.userDao()
        var userdata = userDao?.getAllUserInfo()
        alllist.postValue(userdata)
        Log.d("chan","DataBase Data : "+userdata?.size)
    }

    private fun insertDataToDb(entity: UserEntity) {
        var userDao = RoomDb.getAppDatabase(requireActivity())?.userDao()
        userDao?.insertUser(entity)
        getallDatafromDb()
    }

    private fun deletedata(){
        var userDao = RoomDb.getAppDatabase(requireActivity())?.userDao()
        userDao?.delete()
    }

    override fun onItemClick(categorytype: String) {
        val intent = Intent(requireActivity(), DetailPage::class.java)
        intent.putExtra("categorytype", categorytype)
        intent.putExtra("sub_cat_boeolean", "false")

        startActivity(intent)
        requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
    }

    override fun onResume() {
        super.onResume()
        try{
            getdataFromFireBase()
        }catch (e:Exception){

        }
    }
}