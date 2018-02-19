package dayten.com.lrm.kotlinday10

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_base.*

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        btn.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                var intent:Intent

                intent= Intent(
                        this@BaseActivity,
                        MainActivity::class.java
                )
                startActivity(intent)
                finish()
            }
        })
    }
}
