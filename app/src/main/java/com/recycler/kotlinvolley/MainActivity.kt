package com.recycler.kotlinvolley

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.recycler.kotlinvolley.model.MovieModel
import com.recycler.kotlinvolley.network.HttpConstants
import com.recycler.kotlinvolley.network.VolleySingletion

class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    lateinit  var recycler_view: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view = findViewById(R.id.recycler_view) as RecyclerView
        sendRequest();
    }

    fun setAdapter(movieList: List<MovieModel.ResultsEntity>){
       var recyclerAdapter = RecyclerViewAdapter(this,  movieList)
       var linear = LinearLayoutManager(this)
       recycler_view.layoutManager = linear
       //recView.layoutManager = LinearLayoutManager(baseContext,LinearLayoutManager.VERTICAL,false)
       //recView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
       //recView.itemAnimator= DefaultItemAnimator()
       recycler_view.adapter = recyclerAdapter
   }

    fun sendRequest() {
        progressDialog = ProgressDialog(this)
        progressDialog.show()
        val request = StringRequest(HttpConstants.BASE_URL, Listener<String> {
            response ->
            var movieModel = Gson().fromJson(response, MovieModel::class.java)
            var movieList: List<MovieModel.ResultsEntity> = movieModel.results!!
//            for (item: MovieModel.ResultsEntity in movieList) {
//                println(item.original_title)
//            }
            setAdapter(movieList);
            progressDialog.dismiss()

        }, Response.ErrorListener {
            error ->
            loadToast(error.message)
            progressDialog.dismiss()

        })
        //
        VolleySingletion.requestQueque.add(request)
    }

    fun loadToast(content: String?) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }




}
