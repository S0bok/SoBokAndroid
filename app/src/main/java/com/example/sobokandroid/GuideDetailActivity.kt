package com.example.sobokandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sobokandroid.databinding.ActivityGuideDetailBinding

class GuideDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuideDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuideDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 전달된 데이터 받기
        val title = intent.getStringExtra("title")
        val detail = intent.getStringExtra("detail")
        val date = intent.getStringExtra("date")

        // UI에 데이터 설정
        binding.guideTitle.text = title
        binding.guideDetail1.text = detail
        binding.guideDetail2.text = date

        // 뒤로 가기 버튼 클릭 리스너 설정
        binding.backBtn.setOnClickListener {
            finish()
        }
    }
}