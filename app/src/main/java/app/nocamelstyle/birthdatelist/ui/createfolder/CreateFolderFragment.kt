package app.nocamelstyle.birthdatelist.ui.createfolder

import android.os.Bundle
import android.view.View
import app.nocamelstyle.birthdatelist.R
import app.nocamelstyle.birthdatelist.databinding.FragmentCreateFolderBinding
import app.nocamelstyle.birthdatelist.utils.FragmentModule

class CreateFolderFragment  : FragmentModule<FragmentCreateFolderBinding>() {

    override fun bindViews(view: View, savedInstanceState: Bundle?) {}

    override fun getLayoutRes(): Int = R.layout.fragment_create_folder

}