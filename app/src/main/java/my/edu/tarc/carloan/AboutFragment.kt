package my.edu.tarc.carloan

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import my.edu.tarc.carloan.databinding.FragmentAboutBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {
    private var _binding : FragmentAboutBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Enable menu handler
        setHasOptionsMenu(true)

    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_about).isVisible = false
        menu.findItem(R.id.action_settings).isVisible = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAboutBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Create an instance of Package Manager
        val pm: PackageManager = context?.packageManager!!
        val info: PackageInfo = pm.getPackageInfo(
            context?.packageName!!,
            PackageManager.GET_ACTIVITIES
        )

        binding.textViewVersion.text = String.format("%s : %s",
                getString(R.string.version), info.versionName)

        binding.textViewTnC.setOnClickListener{
            val intent = Intent(context,TnCActivity::class.java)
            startActivity(intent)
        }

    }

}