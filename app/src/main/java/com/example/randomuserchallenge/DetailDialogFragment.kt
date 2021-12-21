package com.example.randomuserchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.randomuserchallenge.databinding.BottomSheetDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DetailDialogFragment : BottomSheetDialogFragment() {
    companion object {
        fun newInstance(user: User): DetailDialogFragment {
             val detailFragment = DetailDialogFragment()
            detailFragment.passedUser=user
            return detailFragment
        }
    }

    private val TAG = "DetailDialogFragment"
    private lateinit var passedUser: User
    private lateinit var binding: BottomSheetDetailBinding
    private val sharedViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = BottomSheetDetailBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.addressTitle.text=
    }
}