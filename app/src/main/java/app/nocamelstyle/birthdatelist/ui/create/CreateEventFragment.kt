package app.nocamelstyle.birthdatelist.ui.create

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import app.nocamelstyle.birthdatelist.R
import app.nocamelstyle.birthdatelist.getDateFromDateDialog
import app.nocamelstyle.birthdatelist.models.Event
import app.nocamelstyle.birthdatelist.utils.Setting

class CreateEventFragment : Fragment(R.layout.fragment_create_event) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var date: Long = 0
        view.findViewById<TextView>(R.id.editTextTextPersonName2).setOnClickListener {
            requireContext().getDateFromDateDialog { selectedDate, formattedDate ->
                view.findViewById<TextView>(R.id.editTextTextPersonName2).text = formattedDate
                date = selectedDate.time / 1000
            }
        }

        view.findViewById<View>(R.id.button).setOnClickListener {
            Setting(requireContext()).addEvent(Event(
                    view.findViewById<EditText>(R.id.editTextTextPersonName).text.toString(),
                    date,
                    view.findViewById<EditText>(R.id.editTextTextPersonName3).text.toString()
            ))
        }
    }

}