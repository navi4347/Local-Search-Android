package app.ntech.localsearch.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import app.ntech.localsearch.R
import app.ntech.localsearch.activity.DetailPage
import app.ntech.localsearch.databinding.FoodrfragBinding

class ProfilePageFrag : Fragment() {

    lateinit var mbinding : FoodrfragBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mbinding = DataBindingUtil.inflate(inflater, R.layout.foodrfrag, container, false)
        onItemClick("Food")

        return mbinding.root
    }

    fun onItemClick(categorytype: String) {
        val intent = Intent(requireActivity(), DetailPage::class.java)
        intent.putExtra("categorytype", categorytype)
        startActivity(intent)
        requireActivity().overridePendingTransition(R.anim.mom_slide_in_right, R.anim.mom_slide_out_left)
    }
}