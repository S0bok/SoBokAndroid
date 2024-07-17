package com.example.sobokandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sobokandroid.databinding.ActivityPolicyDetailBinding

class PolicyDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPolicyDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPolicyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intent로 전달된 데이터 받기
        val title = intent.getStringExtra("title")

        // 데이터 설정
        binding.policyDetailTitle.text = title

        // 뒤로 가기 버튼 클릭 리스너 설정
        binding.backBtn.setOnClickListener {
            finish()
        }
    }
}