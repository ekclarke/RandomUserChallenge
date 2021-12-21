package com.example.randomuserchallenge

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.randomuserchallenge.databinding.BottomSheetDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.SimpleDateFormat
import java.util.*

class DetailDialogFragment : BottomSheetDialogFragment() {
    companion object {
        fun newInstance(user: User): DetailDialogFragment {
            val detailFragment = DetailDialogFragment()
            detailFragment.passedUser = user
            return detailFragment
        }
    }

    private lateinit var passedUser: User
    private lateinit var binding: BottomSheetDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = BottomSheetDetailBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ImageHelper.loadImage(passedUser.picture.large, binding.userPicture)
        val title = passedUser.name.title
        if (title == "Ms" || title == "Mrs" || title == "Mr") {
            binding.userTitle.text = "$title."
        } else binding.userTitle.text = title
        binding.userFirstName.text = passedUser.name.first
        binding.userLastName.text = passedUser.name.last
        binding.userAge.text = passedUser.dob.age
        binding.userDob.text = formatDate(passedUser.dob.date)
        binding.userEmail.text = passedUser.email
        binding.userUuid.text = passedUser.login.username
        binding.userPhone.text = passedUser.phone
        binding.userCell.text = passedUser.cell
        binding.userAddressStreetNumber.text = passedUser.location.street.number
        binding.userAddressStreetName.text = passedUser.location.street.name
        val city = passedUser.location.city
        if ("," !in city) {
            binding.userAddressCity.text = "$city,"
        } else binding.userAddressCity.text = city
        binding.userAddressState.text = passedUser.location.state
        binding.userAddressZip.text = passedUser.location.postcode
    }

    private fun formatDate(rawDate: String): String {
        val fixedDate = rawDate.replace("Z", "-0000")
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US)
        val formattedDate = formatter.parse(fixedDate)!!
        val outputFormatter = SimpleDateFormat("MM-dd-yyyy", Locale.US)
        return outputFormatter.format(formattedDate).toString()
    }
}