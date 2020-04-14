package kedia.pk.kakcho

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var REQUEST_CODE = 108
    var isMultipleSelection = true
    lateinit var unsplash:UnsplashPhoto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var api:Api = retrofit.create()

        var call: Call<List<UnsplashPhoto>> = api.getPhoto()

        call.enqueue(object : Callback<List<UnsplashPhoto>>{
            override fun onFailure(call: Call<List<UnsplashPhoto>>, t: Throwable) {
                Toast.makeText(applicationContext,t.toString(),Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<UnsplashPhoto>>, response: Response<List<UnsplashPhoto>>) {
                var heroes:List<UnsplashPhoto> = response.body()!!
                Log.d("TAG!!!!",heroes.toString())
//                recycler.layoutManager = GridLayoutManager(applicationContext,2)
//                recycler.adapter = RvAdapter(list!!,applicationContext)

                val list: MutableList<String> = ArrayList()
                for (hero:UnsplashPhoto in heroes){
                    Log.d("TAG!!!!",hero.urls.thumb.toString())
                   // Glide.with(this@MainActivity).load(hero.urls.thumb.toString()).into(tv)
                    list.add(hero.urls.thumb.toString())
                    Log.d("TAG!!!!",list.toString())
                }
                                recycler.layoutManager = GridLayoutManager(applicationContext,2)
                recycler.adapter = RvAdapter(list!!,applicationContext)

            }
        })

//        UnsplashPhotoPicker.init(
//                application, // application
//                "12crTwn2h6STA9FaDtS9sGQkP_LevQQjwsC_EZ7suZU",
//                "PFLslACy1p8Z88oGvbbXqMMevnfylE8VtDcotmj2v8U"
//        )



//        startActivityForResult(
//                UnsplashPickerActivity.getStartingIntent(
//                        this, isMultipleSelection
//                ), REQUEST_CODE
//        )


    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
//            val photos: ArrayList<UnsplashPhoto>? = data?.getParcelableArrayListExtra(UnsplashPickerActivity.EXTRA_PHOTOS)
//            // use your photos here
//            Log.d("TAGG!!!!","FETCHEC" + photos!!.size)
//        }
//    }
}
