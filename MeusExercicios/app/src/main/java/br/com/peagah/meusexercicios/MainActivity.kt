package br.com.peagah.meusexercicios

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.peagah.meusexercicios.Controller.validateUser
import br.com.peagah.meusexercicios.models.User
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_button.setOnClickListener {

            if (validateUser(login_user.text.toString(), login_password.text.toString())){
                val user = User(login_user.text.toString(), login_password.text.toString())

                val intent = Intent(this,DashboardActivity::class.java)
                val bundle = Bundle()

                bundle.putParcelable("user", user)
                intent.putExtras(bundle)
                startActivity(intent)

            }else{
                Snackbar.make(it.rootView, "Usuario não informado", Snackbar.LENGTH_LONG)
                    .setAction("Wrong way", null).show()
            }
        }
    }


}
