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
            detailFragment.passedUser = user
            return detailFragment
        }
    }

    private val TAG = "DetailDialogFragment"
    private lateinit var passedUser: User
    private lateinit var binding: BottomSheetDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        var fragmentBinding = BottomSheetDetailBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ImageHelper.loadImage(passedUser.picture.large, binding.userPicture)
        val title = passedUser.name.title
        if (title == "Ms" || title == "Mrs" || title == "Mr") {
            binding.userTitle.text = title + "."
        } else binding.userTitle.text = title
        binding.userFirstName.text = passedUser.name.first
        binding.userLastName.text = passedUser.name.last
        binding.userAge.text=passedUser.dob.age
        //TODO: convert to more readable dates
        binding.userDob.text=passedUser.dob.date
        binding.userEmail.text=passedUser.email
        binding.userUuid.text=passedUser.login.username
        binding.userPhone.text=passedUser.phone
        binding.userCell.text=passedUser.cell
        binding.userAddressStreetNumber.text=passedUser.location.street.number
        binding.userAddressStreetName.text=passedUser.location.street.name
        val city = passedUser.location.city
        if("," !in city){
            binding.userAddressCity.text=city+","
        }
        else binding.userAddressCity.text=city
        binding.userAddressState.text=passedUser.location.state
        binding.userAddressZip.text=passedUser.location.postcode
    }
}