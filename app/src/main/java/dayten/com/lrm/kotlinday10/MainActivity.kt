package dayten.com.lrm.kotlinday10

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animateLeft(cl_one,-350f,0.0f,false)
        animateRight(cl_two,350f,0.0f)

        tv_click_here.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                animateLeft(cl_two,0.0f,-350f,true)
                animateRight(cl_one,0.0f,350f)

            }
        })

    }


    fun animateLeft(view:View, scale1:Float,scale2: Float,buttonClick:Boolean)
    {
        //-350
        val animatorLeft = ObjectAnimator.ofFloat(cl_one, "translationX", scale1,scale2)
        animatorLeft.duration = 500
        animatorLeft.start()
        animatorLeft.addListener(object :Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {
                           }

            override fun onAnimationEnd(p0: Animator?) {
                cl_one.visibility=View.VISIBLE
                cl_two.visibility=View.VISIBLE
                if(buttonClick)
                {
                    var intent: Intent

                    intent= Intent(
                            this@MainActivity,
                            BaseActivity::class.java
                    )
                    startActivity(intent)
                    finish()
                }
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {
            }

        })
    }


    fun animateRight(view: View,scale1:Float,scale2: Float)
    {
        //350
        val animatorRight = ObjectAnimator.ofFloat(cl_two, "translationX",scale1,scale2)
        animatorRight.duration = 500
        animatorRight.start()
        animatorRight.addListener(object :Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationEnd(p0: Animator?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                cl_one.visibility=View.VISIBLE
                cl_two.visibility=View.VISIBLE
            }

            override fun onAnimationCancel(p0: Animator?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationStart(p0: Animator?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}
