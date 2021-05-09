package ru.gladkov.sciencehub.androidApp.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.gladkov.sciencehub.androidApp.databinding.NewsFragmentBinding
import ru.gladkov.sciencehub.androidApp.ui.details.DetailsFragment
import ru.gladkov.sciencehub.androidApp.ui.routing.Navigator
import ru.gladkov.sciencehub.androidApp.ui.utils.showSnackBar

class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private var newsAdapter: NewsAdapter? = null
    private lateinit var binding: NewsFragmentBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val inflate = NewsFragmentBinding.inflate(inflater, container, false)
        binding = inflate
        return inflate.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        initUI()
        observeData()
    }

    private fun observeData() {
        viewModel.news.observe(viewLifecycleOwner) { news ->
            newsAdapter?.submitList(news)
        }
        viewModel.error.observe(viewLifecycleOwner) { err ->
            err.takeIf { it.isNotBlank() }?.let { binding.root.showSnackBar(err) }
        }
    }

    private fun initUI() {
        newsAdapter = NewsAdapter { hubbleNew ->
            (requireActivity() as? Navigator)?.navigateTo(
                fragment = DetailsFragment.newInstance(
                    bundleOf(
                        DetailsFragment.ARG_NEW_ID to hubbleNew.newsId
                    )
                ),
                addToBackStack = true
            )
        }
        binding.rvNewsList.adapter = newsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        newsAdapter = null
    }
}
