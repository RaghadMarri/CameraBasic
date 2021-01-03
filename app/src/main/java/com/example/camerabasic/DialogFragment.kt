package com.example.camerabasic

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_dialog.*


/**
 * A simple [Fragment] subclass.
 */
class DialogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {


            val builder = AlertDialog.Builder(requireContext())
            //set title for alert dialog
            builder.setTitle("R.string.dialogTitle")
            //set message for alert dialog
            builder.setMessage("R.string.dialogMessage")


            //performing positive action
            builder.setPositiveButton("Open Camera") { dialogInterface, which ->
                var mFragment = DocumentCaptureFragment()
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, mFragment).commit()
            }
            //performing cancel action
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(
                    requireContext(),
                    "clicked cancel\n operation cancel",
                    Toast.LENGTH_LONG
                ).show()
            }
            //performing negative action
            builder.setNegativeButton("No") { dialogInterface, which ->
                Toast.makeText(requireContext(), "clicked No", Toast.LENGTH_LONG).show()
            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()

        }
    }

}
