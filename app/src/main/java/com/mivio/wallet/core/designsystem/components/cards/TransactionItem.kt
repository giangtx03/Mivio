package com.mivio.wallet.core.designsystem.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
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

class TransactionItemUiState(
    val icon: ImageVector = Icons.Rounded.Person,
    val bankName: String = "",
    val time: String = "",
    val amount: Int = 0,
    val isPositive: Boolean = true
)

@Composable
fun TransactionItem(
    modifier: Modifier = Modifier,
    state: TransactionItemUiState
) {
    val amountColor = if (state.isPositive) IncomeColor else ExpenseColor
    val badgeBgColor = if (state.isPositive) Secondary else WarningBgColor
    val sign = if (state.isPositive) "+" else "-"
    val typeText = if (state.isPositive) "Nhận tiền" else "Chuyển tiền"

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.transaction_height),
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
                imageVector = state.icon,
                contentDescription = "Bank Logo",
                tint = TextSecondary
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(Dimens.spacing_tiny)
        ) {
            Text(text = state.bankName, color = TextPrimary, style = Typography.bodyLarge)
            Text(text = state.time, color = TextSecondary, style = Typography.labelSmall)
        }
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(Dimens.spacing_tiny)
        ) {
            Text(
                text = "$sign ${state.amount.formatAmount()} VND",
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
                    .padding(
                        horizontal = Dimens.padding_badge_horizontal,
                        vertical = Dimens.padding_badge_vertical
                    )
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
        TransactionItem(
            Modifier,
            state = TransactionItemUiState(
                Icons.Filled.Person,
                "VCB",
                "05/01/2026, 12:00",
                10000000,
                true
            )
        )
        HorizontalDivider(thickness = Dimens.divider_thickness)
        TransactionItem(
            Modifier, state = TransactionItemUiState(
                Icons.Filled.Person,
                "VCB",
                "05/01/2026, 12:00",
                10000000,
                false
            )
        )
    }
}