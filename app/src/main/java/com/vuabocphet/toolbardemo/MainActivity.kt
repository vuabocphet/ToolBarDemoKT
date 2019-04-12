package com.vuabocphet.toolbardemo

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    var toolbar: Toolbar? =null
    var btnOpen:Button?=null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar=findViewById(R.id.toolbar) as Toolbar
        btnOpen=findViewById(R.id.btnOpen) as Button
        setSupportActionBar(toolbar);
        toolbar!!.logo=getDrawable(R.drawable.ic_launcher_background)
        toolbar!!.title="Hello Moto!!!"
        toolbar!!.setNavigationIcon(android.R.drawable.ic_menu_save)
        btnOpen!!.setOnClickListener(View.OnClickListener {
            showPopUp(it)
        })

        registerForContextMenu(btnOpen);


    }


    fun showPopUp(v:View) {
      var  popupMenu:PopupMenu=PopupMenu(this,v)
        var menuInflater:MenuInflater=getMenuInflater()
        menuInflater.inflate(R.menu.my_menu, popupMenu.getMenu())
        popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {

            when(it!!.itemId){

                R.id.menuOpen->{
                    showMessage("You clicked Open")
                }
                R.id.menuClose->{
                    showMessage("You clicked Close")
                }
                R.id.menuExit->{
                    showMessage("You clicked Exit")
                }
                R.id.menuLogOut->{
                    showMessage("You clicked LogOut")
                }



            }

               true

        })

        popupMenu.show();
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menuInflater.inflate(R.menu.my_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){


                R.id.menuOpen->{
                    showMessage("You clicked Open")
                }
                R.id.menuClose->{
                    showMessage("You clicked Close")
                }
                R.id.menuExit->{
                    showMessage("You clicked Exit")
                }
                R.id.menuLogOut->{
                    showMessage("You clicked LogOut")
                }




        }

        return super.onContextItemSelected(item)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){


            R.id.menuOpen->{
                showMessage("You clicked Open")
            }
            R.id.menuClose->{
                showMessage("You clicked Close")
            }
            R.id.menuExit->{
                showMessage("You clicked Exit")
            }
            R.id.menuLogOut->{
                showMessage("You clicked LogOut")
            }




        }
        return super.onOptionsItemSelected(item)
    }


    fun showMessage(txt:String) {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }
}
