package com.example.sobokandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sobokandroid.databinding.PolicyRecyclerViewBinding

class PolicyAdapter(
    private val policyList: List<Policy>,
    private val itemClickListener: (Policy) -> Unit
) : RecyclerView.Adapter<PolicyAdapter.PolicyViewHolder>() {

    inner class PolicyViewHolder(private val binding: PolicyRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(policy: Policy) {
            // 제목 길이 20글자 내로 제한
            val title = if (policy.title.length > 20) {
                "${policy.title.substring(0, 20)}..."
            } else {
                policy.title
            }

            binding.policyRecyclerText.text = title
            binding.areaTitle.text = policy.location
            binding.dateText.text = policy.period
            binding.peopleText.text = policy.target
            binding.policyRecyclerLayout.setImageResource(policy.imageResource)

            binding.root.setOnClickListener {
                itemClickListener(policy)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PolicyViewHolder {
        val binding = PolicyRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PolicyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PolicyViewHolder, position: Int) {
        holder.bind(policyList[position])
    }

    override fun getItemCount(): Int = policyList.size
}