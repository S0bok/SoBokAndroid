package com.example.sobokandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class PolicyActivity : AppCompatActivity() {
    private lateinit var buttons: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_nav_view)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.navigation_policy -> {
                    true
                }
                R.id.navigation_chat -> {
                    startActivity(Intent(this, ChatActivity::class.java))
                    true
                }
                R.id.navigation_guide -> {
                    startActivity(Intent(this, GuideActivity::class.java))
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.selectedItemId = R.id.navigation_policy

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val policyList = listOf(
            Policy("저소득층 및 소외계층 난방연료 지원", "대구광역시", "매년 7월 ~ 12월", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 이사비용 지원", "대구광역시", "상시 신청", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 의료비 지원", "대구광역시", "상시 신청", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 및 소외계층 난방연료 지원", "대구광역시", "매년 7월 ~ 12월", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 이사비용 지원", "대구광역시", "상시 신청", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 의료비 지원", "대구광역시", "상시 신청", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 및 소외계층 난방연료 지원", "대구광역시", "매년 7월 ~ 12월", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 이사비용 지원", "대구광역시", "상시 신청", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 의료비 지원", "대구광역시", "상시 신청", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 및 소외계층 난방연료 지원", "대구광역시", "매년 7월 ~ 12월", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 이사비용 지원", "대구광역시", "상시 신청", "#저소득층", R.drawable.solid_15),
            Policy("저소득층 의료비 지원", "대구광역시", "상시 신청", "#저소득층", R.drawable.solid_15)
        )

        val adapter = PolicyAdapter(policyList) { policy ->
            val intent = Intent(this, PolicyDetailActivity::class.java).apply {
                putExtra("title", policy.title)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        buttons = listOf(
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6)
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                buttons.forEach { it.isSelected = false }
                button.isSelected = true
            }
        }
    }
}