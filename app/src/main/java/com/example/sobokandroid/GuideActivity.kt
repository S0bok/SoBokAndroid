package com.example.sobokandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class GuideActivity : AppCompatActivity(), GuideAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val guides = createDummyGuides() // 더미 데이터 생성
        val adapter = GuideAdapter(guides, this)
        recyclerView.adapter = adapter

        // BottomNavigationView 설정
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.navigation_policy -> {
                    startActivity(Intent(this, PolicyActivity::class.java))
                    true
                }
                R.id.navigation_chat -> {
                    startActivity(Intent(this, ChatActivity::class.java))
                    true
                }
                R.id.navigation_guide -> {
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.selectedItemId = R.id.navigation_guide
    }

    private fun createDummyGuides(): List<Guide> {
        val dummyGuides = mutableListOf<Guide>()
        for (i in 1..10) {
            dummyGuides.add(
                Guide(
                    "온라인으로 제출서류 발급받는 방법",
                    "정부 24를 통해 제출서류를 온라인으로 간편하게 받아보세요!",
                    "2024.07.17"
                )
            )
        }
        return dummyGuides
    }

    override fun onItemClick(guide: Guide) {
        val intent = Intent(this, GuideDetailActivity::class.java).apply {
            putExtra("title", guide.title)
            putExtra("detail", guide.detail)
            putExtra("date", guide.date)
        }
        startActivity(intent)
    }
}
