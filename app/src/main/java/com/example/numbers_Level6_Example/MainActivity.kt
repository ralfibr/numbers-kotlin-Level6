package com.example.numbers_Level6_Example
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
/**
 * @author Raeef Ibrahim
 * 500755393
 */
class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        fab.setOnClickListener {
            viewModel.getRandomTrivia()// Get a random number trivia when the fab is clicked.

        }
    }

    private fun initViewModel() {
        // Initialize the MainActivityViewModel.
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        // Observe the trivia object.
        viewModel.trivia.observe(this, Observer {
            tvTrivia.text = it?.text
        })

        // Observe the error message.
        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
