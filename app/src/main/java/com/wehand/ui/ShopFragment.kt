package com.wehand.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wehand.R


class ShopFragment : Fragment() {

    companion object {
        val TAG: String = ShopFragment::class.java.simpleName
        fun newInstance() = ShopFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity.title = getString(R.string.title_shop)
        val view = inflater?.inflate(R.layout.fragment_shop, container, false)
        return view
    }

}