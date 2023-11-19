package com.jesus.moviesskell.paging

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jesus.moviesskell.R

private const val TAG = "LoaderAdapter"
class LoaderAdapter: LoadStateAdapter<LoaderAdapter.LoaderViewHolder>() {

    class LoaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val progressBar = itemView.findViewById<ProgressBar>(R.id.dataLoaderProgressBar)
        private val errorTextView = itemView.findViewById<TextView>(R.id.dataLoaderErrorText)

        fun bind(loadState: LoadState) {
            Log.i(TAG, "bind: $loadState")
            progressBar.isVisible = loadState is LoadState.Loading
            errorTextView.isVisible = loadState is LoadState.Error
        }
    }

    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_loader, parent, false)
        return LoaderViewHolder(view)
    }

}