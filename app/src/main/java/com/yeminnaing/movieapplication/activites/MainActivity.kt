package com.yeminnaing.movieapplication.activites

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.yeminnaing.movieapplication.R
import com.yeminnaing.movieapplication.adapters.BannerAdapter
import com.yeminnaing.movieapplication.adapters.ShowCaseAdapter
import com.yeminnaing.movieapplication.data.models.MovieModel
import com.yeminnaing.movieapplication.data.models.MovieModelImpl
import com.yeminnaing.movieapplication.data.vos.GenreVo
import com.yeminnaing.movieapplication.delegates.BannerViewHolderDelegate
import com.yeminnaing.movieapplication.delegates.MovieViewHolderDelegate
import com.yeminnaing.movieapplication.delegates.ShowCaseViewHolderDelegate
import com.yeminnaing.movieapplication.viewpods.ActorsListViewPod
import com.yeminnaing.movieapplication.viewpods.MovieListViewPod
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BannerViewHolderDelegate, ShowCaseViewHolderDelegate,
    MovieViewHolderDelegate {
    lateinit var mShowCaseAdapter: ShowCaseAdapter;
    lateinit var mBannerAdapter: BannerAdapter
    lateinit var mBestPopularMovieListViewPot: MovieListViewPod
    lateinit var mMovieByGenreViewPod: MovieListViewPod
    lateinit var mActorListViewPod: ActorsListViewPod

    //Model
    private val mModelView: MovieModel = MovieModelImpl

    //Data
    private var mGenre: List<GenreVo>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpToolbar()
        setUpBannerViewPager()
//      setUpGenreTabLayout()
        setUpListener()
        setUpShowCaseRecyclerView()
        setUpViewPod()
        requestData()

    }

    private fun requestData() {
        mModelView.getNowPlayingMovie(
            onSuccess = {
                mBannerAdapter.setNewData(it)
            },
            onFailure = {

            }
        )

        mModelView.getPopularMovie(
            onSuccess = {
                mBestPopularMovieListViewPot.setData(it)
            },
            onFailure = {

            }
        )

        mModelView.getTopRatedMovie(
            onSuccess = {
                mShowCaseAdapter.setNewData(it)

            },
            onFailure = {

            }
        )
        mModelView.getGenre(
            onSuccess = {
                mGenre = it
                setUpGenreTabLayout(it)
                it.firstOrNull()?.id?.let { genreId ->
                    getMovieByGenreId(genreId)
                }
            },
            onFailure = {

            }
        )

        mModelView.getActors(
            onSuccess = {
                mActorListViewPod.setData(it)
            }, onFailure = {

            }
        )
    }

    private fun getMovieByGenreId(genreId: Int) {
        mModelView.getMovieByGenre(genreId = genreId.toString(),
            onSuccess = {
                mMovieByGenreViewPod.setData(it)
            }, onFailure = {

            })
    }

    fun setUpViewPod() {
        mBestPopularMovieListViewPot = vpBestMoviePopularList as MovieListViewPod
        mBestPopularMovieListViewPot.setUpMovieListViewPod(this)
        mMovieByGenreViewPod = vpMovieByGenre as MovieListViewPod
        mMovieByGenreViewPod.setUpMovieListViewPod(this)

        mActorListViewPod = vpActorsHomeScreen as ActorsListViewPod
    }

    private fun setUpListener() {
        // Genre Tab Layout
        tabLayoutGenre.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                mGenre?.get(tab?.position ?: 0)?.id?.let {
                    getMovieByGenreId(it)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    private fun setUpBannerViewPager() {
        mBannerAdapter = BannerAdapter(this)
        viewPagerBanner.adapter = mBannerAdapter
        dotIndicatorBanner.attachTo(viewPagerBanner)

    }

    private fun setUpGenreTabLayout(genreList: List<GenreVo>) {

//        dummyGenreList.forEach {
//            val tab = tabLayoutGenre.newTab()
//            tab.text = it;
//            tabLayoutGenre.addTab(tab)
//        }

        genreList.forEach {
            tabLayoutGenre.newTab().apply {
                text = it.name
                tabLayoutGenre.addTab(this)
            }
        }
    }

    private fun setUpShowCaseRecyclerView() {
        mShowCaseAdapter = ShowCaseAdapter(this)
        rvShowCases.adapter = mShowCaseAdapter
        rvShowCases.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_discover, menu)
        return true
    }

    override fun onTapMovieFromBanner(movieId: Long) {

        startActivity(MovieDetailsActivity.newIntent(this, movieId))
    }

    override fun onTapMovieFromShowCase(movieId: Long) {

        startActivity(MovieDetailsActivity.newIntent(this, movieId))
    }

    override fun onTapMovie(movieId: Long) {

        startActivity(MovieDetailsActivity.newIntent(this, movieId))
    }
}