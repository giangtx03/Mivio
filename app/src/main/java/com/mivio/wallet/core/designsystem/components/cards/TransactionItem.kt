package com.mivio.wallet.core.designsystem.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mivio.wallet.core.designsystem.theme.Dimens
import com.mivio.wallet.core.designsystem.theme.ExpenseColor
import com.mivio.wallet.core.designsystem.theme.IncomeColor
import com.mivio.wallet.core.designsystem.theme.Secondary
import com.mivio.wallet.core.designsystem.theme.SurfaceVariant
import com.mivio.wallet.core.designsystem.theme.TextHint
import com.mivio.wallet.core.designsystem.theme.TextPrimary
import com.mivio.wallet.core.designsystem.theme.TextSecondary
import com.mivio.wallet.core.designsystem.theme.Typography
import com.mivio.wallet.core.designsystem.theme.WarningBgColor
import com.mivio.wallet.core.utils.formatAmount


@Composable
fun TransactionItem(
    modifier: Modifier = Modifier,
    bankName: String,
    time: String,
    amount: Int,
    isPositive: Boolean
) {
    val amountColor = if (isPositive) IncomeColor else ExpenseColor
    val badgeBgColor = if (isPositive) Secondary else WarningBgColor
    val sign = if (isPositive) "+" else "-"
    val typeText = if (isPositive) "Nhận tiền" else "Chuyển tiền"

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimens.spacing_medium,
                vertical = Dimens.spacing_small
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimens.spacing_medium)
    ) {
        Box(
            modifier = Modifier
                .size(Dimens.icon_xlarge)
                .clip(CircleShape)
                .background(SurfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = "Bank Logo",
                tint = TextSecondary
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(Dimens.spacing_tiny)
        ) {
            Text(text = bankName, color = TextPrimary, style = Typography.bodyLarge)
            Text(text = time, color = TextSecondary, style = Typography.labelSmall)
        }
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(Dimens.spacing_tiny)
        ) {
            Text(
                text = "$sign ${amount.formatAmount()} VND",
                color = amountColor,
                style = Typography.bodyLarge
            )
            Text(
                text = typeText,
                color = TextPrimary,
                style = Typography.labelSmall,
                modifier = Modifier
                    .clip(RoundedCornerShape(Dimens.radius_small))
                    .background(badgeBgColor)
                    .padding(horizontal = Dimens.padding_badge_horizontal, vertical = Dimens.padding_badge_vertical)
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Chi tiết",
            tint = TextHint
        )
    }
}

@Preview(showBackground = true, backgroundColor = 1)
@Composable
fun TransitionItemPreview(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.background(Color.White),
        verticalArrangement = Arrangement.spacedBy(Dimens.spacing_tiny)
    ) {
        TransactionItem(Modifier, "VCB", "05/01/2026, 12:00", 10000000, true)
        HorizontalDivider(thickness = Dimens.divider_thickness)
        TransactionItem(Modifier, "VCB", "05/01/2026, 12:00", 10000000, false)
    }
}