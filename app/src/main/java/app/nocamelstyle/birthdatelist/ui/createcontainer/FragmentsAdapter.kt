package app.nocamelstyle.birthdatelist.ui.createcontainer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentsAdapter(
    ctx: FragmentActivity,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(ctx) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}