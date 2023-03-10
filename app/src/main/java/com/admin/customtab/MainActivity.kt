package com.admin.customtab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import com.admin.customtab.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding ?=null
    private val binding get()=_binding!!

    lateinit var tLayout:TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)

        tLayout=binding.tabLayout

        //2 tane tab layout olusturcaz
        tLayout.addTab((tLayout.newTab()))
        tLayout.addTab((tLayout.newTab()))

        TabOlustur()

        tLayout.addOnTabSelectedListener(object  : TabLayout.OnTabSelectedListener{
            //Buraya fonksiyonu vereceğime en alttakine verdim.Videodan ezbere gittim
            override fun onTabSelected(tab: TabLayout.Tab?) {
                TabSec(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        //İlk sayfanın burda hemen gözükmesi için yoksa 2 den 1 e geçince Sınıf geliyor
        TabSec(0)
    }
    fun TabSec(index:Int){
        val ft=supportFragmentManager.beginTransaction()
        if(index==0){
            ft.replace(R.id.container,Fragment1())
        }
        else if(index==1){
            ft.replace(R.id.container,Fragment2())
        }
        ft.commit()
    }

    fun TabOlustur(){
        val tab1=LayoutInflater.from(this).inflate(R.layout.customtab,null)
        val baslik=tab1.findViewById<TextView>(R.id.tvBaslik)
        val icerik=tab1.findViewById<TextView>(R.id.tvSayi)
        baslik.text="Tab 1"
        icerik.text="1"
        tLayout.getTabAt(0)?.customView = tab1

        val tab2=LayoutInflater.from(this).inflate(R.layout.customtab,null)
        val baslik2=tab2.findViewById<TextView>(R.id.tvBaslik)
        val icerik2=tab2.findViewById<TextView>(R.id.tvSayi)
        baslik2.text="Tab 2"
        icerik2.text="2"

        tLayout.getTabAt(1)?.customView = tab2

    }
}