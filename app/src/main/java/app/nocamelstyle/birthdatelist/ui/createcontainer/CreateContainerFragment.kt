package app.nocamelstyle.birthdatelist.ui.createcontainer

import android.os.Bundle
import android.view.View
import app.nocamelstyle.birthdatelist.R
import app.nocamelstyle.birthdatelist.databinding.FragmentCreateContainerBinding
import app.nocamelstyle.birthdatelist.ui.createevent.CreateEventFragment
import app.nocamelstyle.birthdatelist.ui.createfolder.CreateFolderFragment
import app.nocamelstyle.birthdatelist.utils.FragmentModule
import com.google.android.material.tabs.TabLayoutMediator

class CreateContainerFragment : FragmentModule<FragmentCreateContainerBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_create_container

    override fun bindViews(view: View, savedInstanceState: Bundle?) = dataBinding.run {
        viewPager.adapter = FragmentsAdapter(
            ctx = requireActivity(),
            fragments = listOf(
                CreateEventFragment(),
                CreateFolderFragment()
            )
        )

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "ИЗБРАННОЕ"
                1 -> "ПОИСКИ"
                else -> "ПОДБОРКИ"
            }
        }.attach()
    }

}