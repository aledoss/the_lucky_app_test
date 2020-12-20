package com.example.theluckyapptest.helpers

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.theluckyapptest.data.Margin

class MarginItemDecoration(
    private val margin: Margin
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            top = margin.top
            left = margin.left
            right = margin.right
            bottom = margin.bottom
        }
    }
}