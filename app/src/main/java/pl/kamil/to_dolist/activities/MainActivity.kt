package pl.kamil.to_dolist.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import pl.kamil.to_dolist.R
import pl.kamil.to_dolist.adapter.TabsPagerAdapter

class MainActivity : AppCompatActivity()
{
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var tab_layout: TabLayout

    //TODO: Aplikacja ma dodawac nowa rzecz do zrobienia, opcjonalnie jest możliwośc dodawania opisu do planowanej rzeczy oraz zdjecia/zdjec np obrazujacych dane zadanie
    //TODO: ma to na celu podejscie do tego co ma byc HANDYMAN, wszytsko zapisywane lokalnie
    //TODO: Po dłuższym kliknieciu ma sie pojawic menu albo po przeciagnieciu w bok z mozliwoscia edycji oraz usuniecia pozycji
    //TODO: jezeli edcja to moliows dodania ttulu, opisu i wzdjec tak samo
    //TODO: przyszlosciowo ma byc mozliwosc wrzucania tego do bazy w necie wraz z logowaniem sie użytkownika i przypisywaniem tasków do niego

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        resume()
    }

    private fun resume()
    {
        fabAdd = findViewById(R.id.fabAdd)
        fabAdd.setOnClickListener { Toast.makeText(applicationContext, "Add button clicked", Toast.LENGTH_LONG).show() }
        tab_layout.setSelectedTabIndicatorColor(Color.WHITE)
        tab_layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        tab_layout.tabTextColors = ContextCompat.getColorStateList(this, android.R.color.white)
        // Set different Text Color for Tabs for when are selected or not
        //tab_layout.setTabTextColors(R.color.normalTabTextColor, R.color.selectedTabTextColor)
        // Number Of Tabs
        val numberOfTabs = 2

        // Set Tabs in the center
        tab_layout.tabGravity = TabLayout.GRAVITY_CENTER
        // Show all Tabs in screen
        tab_layout.tabMode = TabLayout.MODE_FIXED
        // Scroll to see all Tabs
        tab_layout.tabMode = TabLayout.MODE_SCROLLABLE
        // Set Tab icons next to the text, instead above the text
        tab_layout.isInlineLabel = true

        val viewPagerAdapter = TabsPagerAdapter(this, supportFragmentManager, lifecycle, numberOfTabs)
        tabs_viewpager.adapter = viewPagerAdapter
        tabs_viewpager.isUserInputEnabled = true

        TabLayoutMediator(tab_layout, tabs_viewpager) { tab, position ->
            when (position)
            {
                0 -> {
                    tab.text = "To-Do"
                    tab.setIcon(R.drawable.to_do_task_list_icon)
                }

                1 -> {
                    tab.text = "Done"
                    tab.setIcon(R.drawable.done_task_list_icon)
                }
            }
            // Change color of the icons
            tab.icon?.colorFilter =
                BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    Color.WHITE,
                    BlendModeCompat.SRC_ATOP
                )
        }.attach()
    }
}