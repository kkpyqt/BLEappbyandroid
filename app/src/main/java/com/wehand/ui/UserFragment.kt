package com.wehand.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wehand.R


class UserFragment : Fragment() {

    companion object {
        val TAG: String = UserFragment::class.java.simpleName
        fun newInstance() = UserFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity.title = getString(R.string.title_user)
        val view = inflater?.inflate(R.layout.fragment_user, container, false)
        return view
    }

}