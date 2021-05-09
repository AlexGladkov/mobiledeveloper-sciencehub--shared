package ru.gladkov.sciencehub.androidApp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import ru.gladkov.sciencehub.androidApp.databinding.DetailsFragmentBinding

class DetailsFragment : Fragment() {

    companion object {
        const val ARG_NEW_ID = "ARG_NEW_ID"
        fun newInstance(bundle: Bundle) = DetailsFragment().apply { arguments = bundle }
    }

    private lateinit var binding: DetailsFragmentBinding
    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val inflate = DetailsFragmentBinding.inflate(inflater, container, false)
        binding = inflate
        return inflate.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        observeData()
        viewModel.getNew(arguments?.getString(ARG_NEW_ID))
    }

    private fun observeData() {
        viewModel.detail.observe(viewLifecycleOwner) { newDetails ->
            with(binding) {
                tvHeader.text = newDetails.name
                tvPublicationDate.text = newDetails.date
                tvDescription.text = newDetails.description
                Glide.with(this@DetailsFragment)
                    .load(newDetails.img)
                    .into(ivThmb)
            }
        }
        viewModel.error.observe(viewLifecycleOwner) { err ->
            err.takeIf { it.isNotBlank() }?.let { Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show() }
        }
    }
}