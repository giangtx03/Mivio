package com.mivio.wallet.core.designsystem.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mivio.wallet.core.utils.formatAmount


@Preview(showBackground = true, backgroundColor = 1)
@Composable
fun SummaryCard(modifier: Modifier = Modifier, amount: Int = 16000000, spent: Int = 250000) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Số dư hiện tại: ")
            Text(text = "${(amount - spent).formatAmount()} VND", fontWeight = FontWeight.Bold, color = Color.Black)
        }

        HorizontalDivider(thickness = 2.dp)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MoneyItem(label = "Thu nhập", amount = "${amount.formatAmount()} VND", isPositive = true)

            VerticalDivider(thickness = 2.dp)

            MoneyItem(label = "Chi tiêu", amount = "${spent.formatAmount()} VND", isPositive = false);

        }
    }
}

@Composable
fun MoneyItem(modifier: Modifier = Modifier, label: String, amount: String, isPositive: Boolean) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = label)
        if (isPositive) {
            Text(text = "+ $amount", color = Color.Green)
        } else {
            Text(text = "- $amount", color = Color.Red)
        }
    }
}
