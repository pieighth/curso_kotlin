package br.com.peagah.mycrazyapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.peagah.mycrazyapp.fragments.DolarFragment
import br.com.peagah.mycrazyapp.fragments.HeatherFragment
import br.com.peagah.mycrazyapp.fragments.StackFragment

class FragmentTabs(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
{

    private val dolarFragment = DolarFragment()
    private val stackFragment = StackFragment()
    private val heatherFragment = HeatherFragment()



    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> dolarFragment
            1 -> stackFragment
            else -> heatherFragment
        }
    }

    override fun getCount(): Int {

       return 3
    }

}