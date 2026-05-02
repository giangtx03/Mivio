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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mivio.wallet.core.designsystem.theme.Dimens
import com.mivio.wallet.core.designsystem.theme.DividerColor
import com.mivio.wallet.core.designsystem.theme.ExpenseColor
import com.mivio.wallet.core.designsystem.theme.IncomeColor
import com.mivio.wallet.core.designsystem.theme.Secondary
import com.mivio.wallet.core.designsystem.theme.TextPrimary
import com.mivio.wallet.core.designsystem.theme.Typography
import com.mivio.wallet.core.utils.formatAmount


@Preview(showBackground = true, backgroundColor = 1)
@Composable
fun SummaryCard(modifier: Modifier = Modifier, amount: Int = 16000000, spent: Int = 250000) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(Dimens.radius_large))
            .background(Secondary)
            .padding(Dimens.spacing_medium),
        verticalArrangement = Arrangement.spacedBy(Dimens.spacing_medium),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Số dư hiện tại: ",
                color = TextPrimary,
                style = Typography.bodyMedium
            )
            Text(
                text = "${(amount - spent).formatAmount()} VND",
                fontWeight = FontWeight.Bold,
                color = TextPrimary,
                style = Typography.headlineMedium
            )
        }

        HorizontalDivider(thickness = Dimens.divider_thickness, color = DividerColor)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MoneyItem(
                label = "Thu nhập",
                amount = "${amount.formatAmount()} VND",
                isPositive = true
            )

            VerticalDivider(thickness = Dimens.divider_thickness, color = DividerColor)

            MoneyItem(
                label = "Chi tiêu",
                amount = "${spent.formatAmount()} VND",
                isPositive = false
            );

        }
    }
}

@Composable
fun MoneyItem(modifier: Modifier = Modifier, label: String, amount: String, isPositive: Boolean) {
    val amountColor = if (isPositive) IncomeColor else ExpenseColor
    val sign = if (isPositive) "+" else "-"

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.spacing_tiny)
    ) {
        Text(
            text = label,
            color = TextPrimary,
            style = Typography.bodyMedium
        )
        Text(
            text = "$sign $amount",
            color = amountColor,
            style = Typography.bodyLarge
        )
    }
}
