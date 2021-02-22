package app.nocamelstyle.birthdatelist.ui.fastlist

import android.os.Bundle
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import app.nocamelstyle.birthdatelist.R
import app.nocamelstyle.birthdatelist.databinding.FragmentFastEventsBinding
import app.nocamelstyle.birthdatelist.models.Event
import app.nocamelstyle.birthdatelist.ui.EventsAdapter
import app.nocamelstyle.birthdatelist.ui.fulllist.AllEventsViewModel
import app.nocamelstyle.birthdatelist.utils.FragmentModule

class FastEventsFragment : FragmentModule<FragmentFastEventsBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_fast_events

    override fun bindViews(view: View, savedInstanceState: Bundle?) {
        dataBinding.item = FastEventsViewModel()
    }

    override fun onStart() {
        super.onStart()
        dataBinding.item?.update()
    }

}